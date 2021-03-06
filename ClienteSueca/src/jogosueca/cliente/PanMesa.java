/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogosueca.cliente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author francisco
 */
public class PanMesa extends javax.swing.JPanel implements MouseListener, ClienteIndirecto, ActionListener {

    private JLabel[] jlTrunfos;
    private String strTrunfo;
    private JLabel jLPtEq1;
    private JPanelPontuacoes jPanelPontuacoes;

    /**
     * Creates new form PanelMesa
     */
    public PanMesa() {
        initComponents();
    }
    private ClienteSueca clienteSueca;
    private javax.swing.JButton jButOK;
    private javax.swing.JLabel jLEq0;
    private javax.swing.JLabel jLEq1;
    private javax.swing.JLabel jLInformacao;
    private javax.swing.JLabel jLJogadas[];
    private javax.swing.JLabel jLJogador0;
    private javax.swing.JLabel jLJogador1;
    private javax.swing.JLabel jLJogador2;
    private javax.swing.JLabel jLJogador3;
    private HashMap<JLabel, String> jLMao = null;
    private String strCartaJogada;
    private JLabel jlCartaJogada = null;
    private boolean minhaVez = false;
    private boolean jogado = false;
    private javax.swing.JLabel jLPotuacoes;
    private javax.swing.JLabel jLPtEq0;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JPanel jPanelInformacaoFimJogo;
    private javax.swing.JPanel jPanelInformacaoInicioJogo;
    private javax.swing.JPanel jPanelJogo;
    private javax.swing.JPanel jPanelMinhaMao;
    private Dimension dimH = new Dimension(103, 71);
    private Dimension dimV = new Dimension(71, 103);
    private Dimension dimCentral = new java.awt.Dimension(400, 300);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelJogo = new javax.swing.JPanel();
        jLJogadas = new JLabel[]{new JLabel(), new JLabel(), new JLabel(), new JLabel()};
        jLEstado = new javax.swing.JLabel("À espera da sua vez de jogar");
        jPanelInformacaoFimJogo = null;
        jLPotuacoes = new javax.swing.JLabel();
        jButOK = new javax.swing.JButton();
        jLEq0 = new javax.swing.JLabel();
        jLEq1 = new javax.swing.JLabel();
        jLPtEq0 = new javax.swing.JLabel();
        jLPtEq1 = new javax.swing.JLabel();
        jLJogador0 = new javax.swing.JLabel();
        jLJogador1 = new javax.swing.JLabel();
        jLJogador2 = new javax.swing.JLabel();
        jLJogador3 = new javax.swing.JLabel();
        jPanelMinhaMao = new javax.swing.JPanel();
        jPanelInformacaoInicioJogo = new javax.swing.JPanel();
        jLInformacao = new javax.swing.JLabel();


        setLayout(new java.awt.GridBagLayout());


        jLJogador0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJogador0.setText("Jogador 0");
        jLJogador0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLJogador0.setPreferredSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.8;
        add(jLJogador0, gridBagConstraints);

        jLJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJogador1.setText("Jogador 2");
        jLJogador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLJogador1.setPreferredSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.8;
        add(jLJogador1, gridBagConstraints);

        jLJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJogador2.setText("Jogador 3");
        jLJogador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLJogador2.setPreferredSize(new java.awt.Dimension(100, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.1;
        add(jLJogador2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        jLEstado.setPreferredSize(new Dimension(60, 30));
        jLEstado.setSize(new Dimension(60, 30));
        add(jLEstado, gridBagConstraints);

        criaMinhaLabel();
        mostraMinhaLabel();

        criaPainelJogo();
        mostraPainelJogo();
        criaJogadas();

        criarTrunfos();
        criaPainelFimDeJogo();
    }

    private void criaPainelPontuacoes(ArrayList<String> lista) {
        jPanelPontuacoes = new JPanelPontuacoes(lista);
        jPanelPontuacoes.setPreferredSize(dimCentral);
        jPanelPontuacoes.addBtOkActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanMesa.this.remove(jPanelPontuacoes);
                mostraPainelJogo();
                for (int i = 0; i < 4; i++) {
                    jlTrunfos[i].setIcon(null);
                }
                synchronized (clienteSueca) {
                    clienteSueca.notify();
                }
            }
        });
    }

    public void criaPainelFimDeJogo() {
        if (jPanelInformacaoFimJogo == null) {
            GridBagConstraints gridBagConstraints;
            jPanelInformacaoFimJogo = new JPanel(new GridBagLayout());
            jPanelInformacaoFimJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jPanelInformacaoFimJogo.setPreferredSize(dimCentral);
            jPanelInformacaoFimJogo.setLayout(new java.awt.GridBagLayout());

            jLPotuacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLPotuacoes.setText("Pontuações");
            jLPotuacoes.setPreferredSize(new java.awt.Dimension(100, 16));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jLPotuacoes, gridBagConstraints);

            jButOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PanMesa.this.remove(jPanelInformacaoFimJogo);
                    PanMesa.this.mostraPainelJogosVencidos();
                }
            });

            jButOK.setText("OK");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.gridwidth = 2;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jButOK, gridBagConstraints);

            jLEq0.setText("Equipa 0");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jLEq0, gridBagConstraints);

            jLEq1.setText("Equipa 1");
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jLEq1, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jLPtEq0, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            jPanelInformacaoFimJogo.add(jLPtEq1, gridBagConstraints);
        }
    }

    private void mostraPainelJogosVencidos() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelPontuacoes, gridBagConstraints);
        validate();
        repaint();
    }

    public void mostraPainelPontuacoes() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelPontuacoes, gridBagConstraints);
        validate();
        repaint();
    }

    private void mostraPainelJogo() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelJogo.setPreferredSize(dimCentral);
        add(jPanelJogo, gridBagConstraints);
        validate();
        repaint();
    }

    public void criaPainelJogo() {
        GridBagConstraints gridBagConstraints;
        jPanelJogo.setPreferredSize(dimCentral);
        jPanelJogo.setLayout(new java.awt.GridBagLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
    }

    private int getJogador(int t) {
        return (t + 4 - clienteSueca.getNum()) % 4;
    }

    private void apagaJogadas() {
        for (int i = 0; i < 4; i++) {
            jLJogadas[i].setIcon(null);
        }
    }

    private void criaJogadas() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        for (int i = 0; i < 4; i++) {
            jLJogadas[i] = new JLabel();
            JLabel jLJogada = jLJogadas[i];
            jLJogada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLJogada.setPreferredSize(i % 2 == 0 ? dimV : dimH);
        }
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelJogo.add(jLJogadas[1], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanelJogo.add(jLJogadas[0], gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        jPanelJogo.add(jLJogadas[3], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanelJogo.add(jLJogadas[2], gridBagConstraints);

    }

    public void criarTrunfos() {
        jlTrunfos = new JLabel[4];
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();

        for (int i = 0; i < 4; i++) {
            jlTrunfos[i] = new JLabel();
            jlTrunfos[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jlTrunfos[i].setPreferredSize(i % 2 == 0 ? dimV : dimH);
        }

        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        jPanelJogo.add(jlTrunfos[0], gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        jPanelJogo.add(jlTrunfos[1], gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanelJogo.add(jlTrunfos[2], gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        jPanelJogo.add(jlTrunfos[3], gridBagConstraints);
    }

    public void criaMinhaLabel() {
        jLJogador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJogador3.setText("Jogador 3");
        jLJogador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLJogador3.setPreferredSize(new java.awt.Dimension(100, 100));
    }

    public void mostraMinhaLabel() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.1;
        add(jLJogador3, gridBagConstraints);
    }

    public void mostrarMao() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.weighty = 0.1;
        add(jPanelMinhaMao, gridBagConstraints);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (minhaVez) {

            JLabel jlCarta = (JLabel) e.getSource();
            this.strCartaJogada = jLMao.get(jlCarta);
            this.jlCartaJogada = jlCarta;

            synchronized (clienteSueca) {
                this.clienteSueca.notify();
                minhaVez = false;
                jogado = true;
            }

        }
    }

    public void criaPainelInfirmacaoInicio() {
        jPanelInformacaoInicioJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInformacaoInicioJogo.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanelInformacaoInicioJogo.setLayout(new java.awt.GridBagLayout());

        jLInformacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInformacao.setText("À espera do jogador 1");
        jLInformacao.setPreferredSize(new java.awt.Dimension(100, 16));
        GridBagConstraints gridBagConstraints;
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelInformacaoInicioJogo.add(jLInformacao, gridBagConstraints);
    }

    public void mostraPainelInformacaoInicio() {
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelInformacaoInicioJogo, gridBagConstraints);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void setCliente(ClienteSueca clienteSueca) {
        this.clienteSueca = clienteSueca;
    }

    @Override
    public void updatedNum(int num) {
        //não é preciso
    }

    @Override
    public void updateMao(TreeSet<Carta> mao, String trunfo, int jogadorADar) {
        jPanelPontuacoes = null;
        if (jLMao == null) {
            jPanelMinhaMao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
            jPanelMinhaMao.setPreferredSize(new java.awt.Dimension(100, 100));
            jPanelMinhaMao.setLayout(new java.awt.GridLayout());
            this.strTrunfo = trunfo;

            int iJogador = getJogador(jogadorADar);
            jLMao = new HashMap<JLabel,String>(10);
            for (Carta carta : mao) {
                JLabel jlCarta = new JLabel(new ImageIcon(getClass().getResource(
                        String.format("/cartas/v/%s.png", carta.toString()))));
                jlCarta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                if (iJogador == 0 && carta.toString().equals(trunfo)) {
                    jLMao.put(jlTrunfos[0], carta.toString());
                    jlTrunfos[0].addMouseListener(this);
                } else {
                    jLMao.put(jlCarta, carta.toString());
                    jPanelMinhaMao.add(jlCarta);
                    jlCarta.addMouseListener(this);
                }
            }
            remove(jLJogador3);

            GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            add(jPanelMinhaMao, gridBagConstraints);

            jlTrunfos[iJogador].setIcon(new ImageIcon(getClass().getResource(
                    String.format("/cartas/%s/%s.png", iJogador % 2 == 0 ? 'v' : 'h', trunfo))));

            validate();
            repaint();

        }
    }

    @Override
    public String cartaJogada() {
        return this.strCartaJogada;
    }

    @Override
    public void comunicaJogada(int indiceJogador, String carta) {
        int tjogador = getJogador(indiceJogador);
        jLJogadas[tjogador].setIcon(new javax.swing.ImageIcon(getClass().getResource(
                String.format("/cartas/%s/%s.png", tjogador % 2 == 0 ? 'v' : 'h', carta)))); // NOI18N
        if (tjogador != 0 && carta.equals(strTrunfo)) {
            for (int i = 0; i < 4; i++) {
                jlTrunfos[i].setIcon(null);
            }
        }


        repaint();
    }

    @Override
    public void excepcao(Exception ex) {
        Logger.getLogger(PanMesa.class.getName()).log(Level.SEVERE, null, ex);
    }

    @Override
    public boolean joga(ClienteSueca cs) {
        String statusLbl = "É a sua vez de jogar";
        jLEstado.setText(statusLbl);
        minhaVez = true;

        return jogado;
    }

    @Override
    public void jogouACarta(String cj) {
        //TODO apagar porque já não é necessário
    }

    @Override
    public void cartaValidada(String cj) {
        if (jlTrunfos[0] == jlCartaJogada) {
            jlTrunfos[0].setIcon(null);
        } else {
            jPanelMinhaMao.remove(jlCartaJogada);
        }
        minhaVez = false;
        jogado = false;
        jLEstado.setText("Á espera dos restantes jogadores");
        comunicaJogada(clienteSueca.getNum(), cj);
    }

    @Override
    public void cartaInvalidada(String cj) {
        minhaVez = true;
        jogado = false;
    }

    @Override
    public void vencedor(int vencedor, int pontos) {
        try {
            jLEstado.setText("A equipa " + vencedor % 2 + " ganhou " + pontos);
            Thread.sleep(3000);
            jLEstado.setText("À espera da sua vez de jogar");
            apagaJogadas();
        } catch (InterruptedException ex) {
            Logger.getLogger(PanMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pontosFinais(int equipa0, int equipa1, ArrayList<String> lista) {
        remove(jPanelJogo);
        jLMao = null;
        criaPainelPontuacoes(lista);
        jPanelPontuacoes.setPontosEquipas(equipa0, equipa1);
        jPanelMinhaMao.removeAll();
        mostraPainelPontuacoes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostraPainelJogo();
    }
}
