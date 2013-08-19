/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsueca;

import java.util.Iterator;

/**
 *
 * @author francisco
 */
public class Carta implements Comparable<Carta>{
    
    
    private UpdateMesa um;
    private char naipe;
    private char figura;
    private int indiceComparacao;
    
    public Carta(String carta, UpdateMesa um) throws Exception {
        if (carta.length()!=2) {
            throw new Exception("A carta só pode ter duas letras");
        }
        char n = carta.charAt(1);
        char f = carta.charAt(0);
        this.um = um;

        defCarta(n, f);
    }
    
    private boolean naipeValido(){
        char naipes[] = {'C','E','O','P'};
        for (char c : naipes) {
            if(naipe == c)return true;
        }
        return false;
    }
    
    
    private void defCarta(char naipe, char figura) throws Exception{
        this.naipe = naipe;
        if(!naipeValido())
            throw new Exception("Naipe inválido:"+naipe);
        this.figura = figura;
        indiceComparacao = calculaIndiceComparacao();
        if(indiceComparacao == -1)
            throw new Exception("A figura é inválida:"+figura);
    }
    
    public char getFigura() {
        return figura;
    }

    public void setFigura(char figura) {
        this.figura = figura;
    }
    
    public char getNaipe() {
        return naipe;
    }

    public void setNaipe(char naipe) {
        this.naipe = naipe;
    }

    
    public boolean eTrunfo(){
        return um.getNaipeTrunfo() == this.naipe;
    }
        
    public int getValor(){
        switch(figura){
            case '2':return 0;
            case '3':return 0;
            case '4':return 0;
            case '5':return 0;
            case '6':return 0;
            case 'D':return 2;
            case 'V':return 3;
            case 'R':return 4;
            case '7':return 10;
            case 'A':return 11;
        }
        return -1;
    }
    private int calculaIndiceComparacao(){
        switch(figura){
            case '2':return 0;
            case '3':return 1;
            case '4':return 2;
            case '5':return 3;
            case '6':return 4;
            case 'D':return 5;
            case 'V':return 6;
            case 'R':return 7;
            case '7':return 8;
            case 'A':return 9;
        }
        return -1;
    }

    @Override
    public String toString() {
        return ""+figura+naipe;
    }
    
    @Override
    public int compareTo(Carta c1) {
        if(this.eTrunfo()&&!c1.eTrunfo())
            return 1;
        if(!this.eTrunfo()&&c1.eTrunfo())
            return -1;
        char naipePuxado = this.um.puxada().getNaipe();
        if(naipePuxado == getNaipe() && c1.getNaipe() != naipePuxado)
            return 1;
        if(naipePuxado != getNaipe() && c1.getNaipe()==naipePuxado)
            return -1;
        if(getValor()>c1.getValor())
            return 1;
        return -1;
    }
}
