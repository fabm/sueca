package servidorsueca;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorSueca extends Thread {

    public static void main(String args[]) {

        try {

            ServerSocket s = new ServerSocket(8081);
            while (true) {

                System.out.print("Servidor:A espera que alguem se conecte...");

                Socket conexao = s.accept();
                System.out.println("Servidor: Conectado em:" + conexao.getPort());
                // cria uma nova thread para tratar essa conexão
                Thread t = new ServidorSueca(conexao);
                t.start();
                // voltar ao loop
            }
        } catch (IOException e) {
            System.out.println("Servidor:IOException: " + e);
        }
    }
    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private Socket conexao;

    public ServidorSueca(Socket s) {
        conexao = s;
    }

    @Override
    public void run() {
        try {

            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            PrintStream saida = new PrintStream(conexao.getOutputStream());

            if (mesas.isEmpty()) {
                mesas.add(new Mesa());
            }
            Mesa ultimaMesa = mesas.get(mesas.size() - 1);


            if (ultimaMesa.mesaCheia()) {
                ultimaMesa = new Mesa();
                mesas.add(ultimaMesa);
            }

            ultimaMesa.addJogador(entrada, saida);

            boolean var = true;
            while (var) {
            }

            conexao.close();
        } catch (IOException e) {
            // Caso ocorra alguma excessão de E/S, mostre qual foi.
            System.out.println("Servidor:IOException: " + e);
        }
    }
}
