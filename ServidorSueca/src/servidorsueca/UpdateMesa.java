/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsueca;

/**
 *
 * @author francisco
 */
public interface UpdateMesa {
    String update(Jogador origem,String str);
    char getNaipeTrunfo();
    String getTrunfo();

    public Carta puxada();
}
