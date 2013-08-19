/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsueca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author francisco
 */
public class Mesa implements UpdateMesa {

    public Mesa() {
        Random rand = new Random();
        rodada = new Rodada(rand.nextInt(4));
    }
    private String trunfo;
    private Jogador[] jogadores = new Jogador[4];
    private Rodada rodada;
    private Carta[] jogada = new Carta[4];
    private ArrayList<Integer> jogosVencidos = new ArrayList<>();
    private int indice = 0;// do jogador até ao 4 e depois disso da puxada

    public boolean mesaCheia() {
        if (indice == 4) {
            return true;
        }
        return false;
    }

    @Override
    public char getNaipeTrunfo() {
        return trunfo.charAt(1);
    }

    synchronized public Jogador addJogador(BufferedReader entrada, PrintStream saida) throws IOException {
        if (mesaCheia()) {
            throw new RuntimeException("mesa:Não é possível adicionar jogadores à mesa");
        }
        Jogador jogador = new Jogador(entrada, saida, this);
        jogadores[indice] = jogador;
        jogador.setNum(indice);
        indice++;
        if (mesaCheia()) {
            indice = -1;
            while (true) {
                int pontos[] = jogo();
                jogosVencidos.add(pontos[0]==pontos[1]?-1:
                        pontos[0]>pontos[1]?0:1
                        );
                for (int i = 0; i < 4; i++) {
                    jogadores[i].fimJogo(pontos,jogosVencidos);
                }
            }
        }
        return jogador;
    }

    public int[] jogo() throws IOException {
        int pontosEquipa[] = {0, 0};
        distribuiCartas();
        Jogador pjaj = jogadores[rodada.getJogador()];//primeiro jogador a jogar
        //enviar trunfos
        this.trunfo = pjaj.getStrMao().substring(0, 2);
        for (int i = 0; i < 4; i++) {
            jogadores[i].comunicaTrunfo(rodada.getJogador());
        }
        indice = rodada.getJogador();
        //TODO alterar para 10
        for (int j = 0; j < 10; j++) {
            while (!rodada.fimRodada()) {
                pjaj.pedeParaJogar();
                Carta carta = pjaj.joga(); //proximo jogador a jogar
                int indiceJogador = rodada.getJogador();
                jogada[indiceJogador] = carta;
                //comunicação aos 3 restantes jogadores
                Rodada restantes = new Rodada(indiceJogador);
                restantes.proximo();
                while (!restantes.fimRodada()) {
                    System.out.println("Servidor:Comunicado ao jogador " + restantes.getJogador() + " a jogada " + carta + " feita por " + indiceJogador);
                    jogadores[restantes.getJogador()].comunicaJogada(indiceJogador, carta);
                    restantes.proximo();
                }
                rodada.proximo();
                pjaj = jogadores[rodada.getJogador()];
            }
            int jv = jogadorVencedor();
            indice = jv;
            rodada.setJogador(jv);// O jogador vencedor vencedor vai ser o primeiro na próxima jogada
            //pontos da jogada
            pjaj = jogadores[jv];
            int pontosRodada = 0;
            for (int i = 0; i < 4; i++) {
                pontosRodada += jogada[i].getValor();
            }
            pontosEquipa[jv % 2] += pontosRodada;
            for (int i = 0; i < 4; i++) {
                jogadores[i].comunicaVitoria(jv,pontosRodada);
            }
            jogada[indice] = null;
        }
        return pontosEquipa;
    }

    
    private int jogadorVencedor() {
        //ver qual é a carta mais alta
        Carta cma = jogada[0];
        int ima = 0;//indice mais aulto
        for (int i = 1; i < 4; i++) {
            if (cma.compareTo(jogada[i]) == -1) {
                cma = jogada[i];
                ima = i;
            }
        }
        return ima;
    }

    public void distribuiCartas() {
        LinkedList<String> baralho = new LinkedList<>();
        char naipes[] = {'P', 'O', 'C', 'E'};
        char figuras[] = {'D', 'V', 'R', '7', 'A'};
        for (char n : naipes) {
            for (int i = 2; i < 7; i++) {
                baralho.push("" + i + n);
            }
            for (char f : figuras) {
                baralho.push("" + f + n);
            }
        }

        for (int i = 0; i < 4; i++) {
            String strMao = "";
            for (int j = 0; j < 10; j++) {
                Random r = new Random();
                int ipc = r.nextInt(baralho.size());//indice da proxima carta
                strMao += baralho.get(ipc);
                baralho.remove(ipc);
            }
            jogadores[i].criaMao(strMao);
            jogadores[i].setMao(strMao);
        }
    }

    @Override
    public String update(Jogador origem, String str) {

        if (origem == jogadores[rodada.getJogador()]) {
        }
        return null;
    }

    @Override
    public String getTrunfo() {
        return trunfo;
    }

    @Override
    public Carta puxada() {
        if (indice == -1) {
            return null;
        }
        return jogada[indice];
    }
}
