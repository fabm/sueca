/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsueca;

/**
 *
 * @author francisco
 */
public class Rodada {

    public Rodada(int n) {
        this.n = n;
    }
    private int n;
    private int c = 0;

    public boolean fimRodada() {
        if (c > 3) {
            c = 0;
            return true;
        }
        return false;
    }

    public int getEquipa() {
        return this.n % 2;
    }

    public void proximo() {
        c++;
        if (n >= 3) {
            n = 0;
        } else {
            n++;
        }
    }

    public void anterior() {
        c++;
        if (n <= 0) {
            n = 3;
        } else {
            n--;
        }
    }

    public void setJogador(int jogador) {
        this.n = jogador;
    }

    public int getJogador() {
        return n;
    }

    public int getOrdem() {
        return c;
    }
}
