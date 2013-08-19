/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogosueca.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import jogosueca.cliente.Carta;

/**
 *
 * @author francisco
 */
public interface ClienteIndirecto{
    void setCliente(ClienteSueca clienteSueca);
    public void updatedNum(int num);
    public String cartaJogada();

    public void comunicaJogada(int indiceJogador, String carta);

    public void excepcao(Exception ex);

    public boolean joga(ClienteSueca cs);

    public void jogouACarta(String cj);

    public void cartaValidada(String cj);

    public void cartaInvalidada(String cj);

    public void vencedor(int vencedor, int pontos);

    public void updateMao(TreeSet<Carta> mao, String trunfo, int jogador);

    public void pontosFinais(int pontos0, int pontos1, ArrayList<String> lista);
}
