package servidorsueca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author francisco
 */
public class Jogador {

    private PrintStream saida;
    private BufferedReader entrada;
    private UpdateMesa updateMesa;
    private ArrayList<Carta> mao;

    Jogador(BufferedReader entrada, PrintStream saida, UpdateMesa um) {
        this.entrada = entrada;
        this.saida = saida;
        this.updateMesa = um;
        this.mao = new ArrayList<>();
    }

    public void criaMao(String strMao) {
        this.mao.clear();
        for (int i = 0; i < 10; i++) {
            try {
                this.mao.add(new Carta(strMao.substring(i * 2, (i + 1) * 2), updateMesa));
            } catch (Exception ex) {
                Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setMao(String strMao) {
        saida.println("mao");
        saida.println(strMao);
    }

    public String getStrMao() {
        String strMao = "";
        for (Carta carta : mao) {
            strMao += carta;
        }
        return strMao;
    }

    private Carta cartaNaMao(String strCarta) {
        for (Carta carta : mao) {
            if (carta.toString().equals(strCarta)) {
                return carta;
            }
        }
        return null;
    }

    private boolean temONipe(char nipe) {
        for (Carta carta : mao) {
            if (nipe == carta.getNaipe()) {
                return true;
            }
        }
        return false;
    }

    public Carta joga() throws IOException {
        Carta carta = null;
        while (carta == null) {
            String jogada = entrada.readLine();
            carta = cartaNaMao(jogada);
            if (carta == null) {
                saida.println("invalida");
            } else if (updateMesa.puxada() == null
                    || updateMesa.puxada().getNaipe() == carta.getNaipe()
                    || !temONipe(updateMesa.puxada().getNaipe())) {
                saida.println();
            } else {
                System.out.println("Jogada Inválida");
                saida.println("invalida");
                carta = null;
            }
        }
        mao.remove(carta);
        return carta;
    }

    public void comunicaJogada(int indiceJogador, Carta carta) {
        saida.println("comunica");
        saida.println(indiceJogador + ":" + carta);
    }

    void pedeParaJogar() {
        saida.println("joga");
    }

    void setNum(int num) {
        saida.println(num);
    }

    void comunicaVitoria(int jv, int pontosRodada) {
        saida.println("fimrodada");
        saida.println(jv);
        saida.println(pontosRodada);
    }

    void fimJogo(int pe[], ArrayList<Integer> listaJogos) throws IOException {
        mao.clear();
        saida.println("fimjogo");
        saida.println(pe[0]);
        saida.println(pe[1]);
        for (Integer vencedor : listaJogos) {
            switch(vencedor){
               case -1:
                   saida.println("Empatados");
                   break;
               case 0:
               case 1:
                   saida.println("Equipa "+vencedor);
                   break;
            }
        }
        saida.println("fimlista");
    }
    

    void comunicaTrunfo(int jogador) {
        saida.println(updateMesa.getTrunfo());
        saida.println(jogador);
    }
}
