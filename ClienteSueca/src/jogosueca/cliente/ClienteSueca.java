// EchoClient.java
// Teste de sockets - programa cliente
// L�, envia, recebe e mostra linhas de texto.
package jogosueca.cliente;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;


public class ClienteSueca extends Thread{

    private SoundManager soundManager = new SoundManager();
    private ClienteIndirecto clienteIndirecto;
    private int num;
    private Socket socket;
    private TreeSet<Carta> mao;
    private String jogada[] = new String[4];
    private BufferedReader entrada;
    private PrintStream saida;
    public ClienteSueca(String hostname, ClienteIndirecto clienteIndirecto) throws Exception {
        try {
            socket = new Socket(hostname, 8081);
            System.out.println("Socket = " + socket);
            entrada =
                    new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream()));
            saida =
                    new PrintStream(
                    socket.getOutputStream());
            this.clienteIndirecto = clienteIndirecto;
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public int getNum() {
        return num;
    }

    @Override
    public void run() {
        jogo();
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }

    private void jogo() {
        try {
            mao = new TreeSet();
            num = Integer.parseInt(entrada.readLine());
            clienteIndirecto.updatedNum(num);

            while (true) {
                String cj = null;
                String str = entrada.readLine();
                if (str.equals("mao")) {
                    setCartas(entrada.readLine(), entrada.readLine(),
                            Integer.parseInt(entrada.readLine()));

                } else if (str.equals("joga")) {
                    str = "invalida";
                    while (str.equals("invalida")) {
                        synchronized (this) {
                            if (!clienteIndirecto.joga(this)) {
                                wait();
                            }
                        }
                        cj = clienteIndirecto.cartaJogada();
                        if (cj == null) {
                            return;
                        } else {
                            saida.println(cj);
                            clienteIndirecto.jogouACarta(cj);
                            str = entrada.readLine();
                            if (str.equals("")) {
                                clienteIndirecto.cartaValidada(cj);

                            } else {
                                //som invalida
                                soundManager.playSong("som/horn-2.wav");
                                clienteIndirecto.cartaInvalidada(cj);
                            }
                        }
                    }
                    int indiceJogador = num;
                    jogada[indiceJogador] = cj;
                } else if (str.equals("fimrodada")) {
                    clienteIndirecto.vencedor(Integer.parseInt(entrada.readLine()),
                            Integer.parseInt(entrada.readLine()));

                } else if (str.equals("fimjogo")) {
                    int pontos0 = Integer.parseInt(entrada.readLine());
                    int pontos1 = Integer.parseInt(entrada.readLine());
                    ArrayList<String> lista = new ArrayList<String>();
                    String e = entrada.readLine();
                    while (!e.equals("fimlista")) {
                        lista.add(e);
                        e = entrada.readLine();
                    }
                    clienteIndirecto.pontosFinais(pontos0, pontos1, lista);

                    synchronized (this) {
                        wait();
                    }
                    mao.clear();

                } else if (str.equals("comunica")) {
                    str = entrada.readLine();
                    int indiceJogador = Integer.parseInt(str.substring(0, 1));
                    String carta = str.substring(2);
                    jogada[indiceJogador] = carta;
                    clienteIndirecto.comunicaJogada(indiceJogador, carta);

                }
            }
        } catch (IOException ex) {
            clienteIndirecto.excepcao(ex);
        } catch (Exception ex) {
            clienteIndirecto.excepcao(ex);
        }
    }

    private void setCartas(String strMao, String trunfo, int jogador) throws Exception {
        for (int i = 0; i < 10; i++) {
            mao.add(new Carta(strMao.substring(i * 2, (i + 1) * 2), trunfo.charAt(1)));
        }
        clienteIndirecto.updateMao(mao, trunfo, jogador);
    }
}  // end echoClient

