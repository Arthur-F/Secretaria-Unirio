/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Gerenciador;

import java.awt.Dimension;
import java.awt.Toolkit;
import model.entity.Aluno;
import model.requerimento.Requerimento;

/**
 *
 * @author tsuba
 */
public class ConfirmacaoEnvio extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmacaoEnvio
     */
    public ConfirmacaoEnvio() {
        initComponents();

    }
    Aluno aluno;
    Requerimento requerimento;

    public ConfirmacaoEnvio(Aluno aluno, Requerimento requerimento) {
        initComponents();
        this.aluno = aluno;
        this.requerimento = requerimento;
        centralizarTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        naoBotaoConfirmacao = new javax.swing.JButton();
        simBotaoConfirmacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Você deseja confirmar o envio do requerimento?");

        naoBotaoConfirmacao.setBackground(new java.awt.Color(56, 113, 156));
        naoBotaoConfirmacao.setForeground(new java.awt.Color(255, 255, 255));
        naoBotaoConfirmacao.setText("Não");
        naoBotaoConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoBotaoConfirmacaoActionPerformed(evt);
            }
        });

        simBotaoConfirmacao.setBackground(new java.awt.Color(56, 113, 156));
        simBotaoConfirmacao.setForeground(new java.awt.Color(255, 255, 255));
        simBotaoConfirmacao.setText("Sim");
        simBotaoConfirmacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simBotaoConfirmacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(naoBotaoConfirmacao)
                .addGap(38, 38, 38)
                .addComponent(simBotaoConfirmacao)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(naoBotaoConfirmacao)
                    .addComponent(simBotaoConfirmacao))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Centraliza a tela independentemente do tamanho
     */
    
    private void centralizarTela() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    
    /**
     * Confirma o envio apos o clique
     * @param evt evento do clique do mouse
     */
    private void simBotaoConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simBotaoConfirmacaoActionPerformed
        Gerenciador.analisaRequerimento(requerimento);
        EnviadoComSucesso janelaSucesso = new EnviadoComSucesso(aluno);
        janelaSucesso.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_simBotaoConfirmacaoActionPerformed

    /**
     * nega o envio apos o clique
     * @param evt evento do clique do mouse
     */
    private void naoBotaoConfirmacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoBotaoConfirmacaoActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_naoBotaoConfirmacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton naoBotaoConfirmacao;
    private javax.swing.JButton simBotaoConfirmacao;
    // End of variables declaration//GEN-END:variables
}
