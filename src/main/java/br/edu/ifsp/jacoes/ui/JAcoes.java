/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jacoes.ui;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author bruno e carlos
 */
public class JAcoes extends javax.swing.JFrame {
    
    public JAcoes() {
        initComponents();
        jBaseAtivos.getListaAtivos().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlBaseAtivosMouseClicked(evt);
            }
        });
        jConfiguracoes.getJbSalvar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarDiretorioActionPerformed(evt);
            }
        });
        setLocationRelativeTo(null);
    }      
    
    private void jlBaseAtivosMouseClicked(java.awt.event.MouseEvent evt){
        jtfAtivoAtual.setText(jBaseAtivos.getListaAtivos().getSelectedValue());
        painelConfigGrafico.validate();
    }
    
    private void jbSalvarDiretorioActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        jConfiguracoes.setVisible(false);
        if(!(jBaseAtivos.getParent() == painelBaseAtivos)){
            painelBaseAtivos.remove(jBaseAtivos);
        }
        painelBaseAtivos.add(jBaseAtivos);
        jBaseAtivos.setVisible(true);
        jBaseAtivos.setDiretorio(jConfiguracoes.getDiretorio());
        jbPlotarGrafico.setEnabled(true);
        jbReset.setEnabled(true);
        jtfExibicao.setEnabled(true);
        jtfIntMMA.setEnabled(true);
        jtfAtivoAtual.setEnabled(true);
        jcbIntCandles.setEnabled(true);
        jtfExibicao.setText("14");
        jtfIntMMA.setText("14");
        try {
            jBaseAtivos.setMaximum(true);
        } catch (PropertyVetoException ex) {
            System.err.println("Não foi possível maximizar o painel de ativos!");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelGrafico = new javax.swing.JPanel();
        painelBaseAtivos = new javax.swing.JPanel();
        painelConfigGrafico = new javax.swing.JPanel();
        jtfAtivoAtual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlbExibicao = new javax.swing.JLabel();
        jtfExibicao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbIntCandles = new javax.swing.JComboBox<>();
        jlbIntMMA = new javax.swing.JLabel();
        jtfIntMMA = new javax.swing.JTextField();
        jbPlotarGrafico = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFerramentas = new javax.swing.JMenu();
        jmiAbrirConfig = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAcoes");
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        painelPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));

        painelGrafico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painelBaseAtivos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout painelBaseAtivosLayout = new javax.swing.GroupLayout(painelBaseAtivos);
        painelBaseAtivos.setLayout(painelBaseAtivosLayout);
        painelBaseAtivosLayout.setHorizontalGroup(
            painelBaseAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );
        painelBaseAtivosLayout.setVerticalGroup(
            painelBaseAtivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );

        painelConfigGrafico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfAtivoAtual.setColumns(6);
        jtfAtivoAtual.setText("NULL0");
        jtfAtivoAtual.setEnabled(false);
        jtfAtivoAtual.setMaximumSize(new java.awt.Dimension(89, 27));
        jtfAtivoAtual.setMinimumSize(new java.awt.Dimension(89, 27));
        jtfAtivoAtual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfAtivoAtualMouseClicked(evt);
            }
        });
        jtfAtivoAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfAtivoAtualKeyReleased(evt);
            }
        });

        jLabel1.setText("Ação");

        jlbExibicao.setText("Int. Exibição (dias)");

        jtfExibicao.setText("00");
        jtfExibicao.setEnabled(false);

        jLabel3.setText("Int. Candles");

        jcbIntCandles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diario", "Semanal" }));
        jcbIntCandles.setEnabled(false);
        jcbIntCandles.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbIntCandlesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jlbIntMMA.setText("Int. MMA (dias)");

        jtfIntMMA.setText("00");
        jtfIntMMA.setEnabled(false);

        jbPlotarGrafico.setText("Plotar!");
        jbPlotarGrafico.setEnabled(false);
        jbPlotarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlotarGraficoActionPerformed(evt);
            }
        });

        jbReset.setText("Resetar");
        jbReset.setEnabled(false);
        jbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConfigGraficoLayout = new javax.swing.GroupLayout(painelConfigGrafico);
        painelConfigGrafico.setLayout(painelConfigGraficoLayout);
        painelConfigGraficoLayout.setHorizontalGroup(
            painelConfigGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConfigGraficoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfAtivoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbExibicao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfExibicao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbIntCandles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbIntMMA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIntMMA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPlotarGrafico)
                .addContainerGap())
        );
        painelConfigGraficoLayout.setVerticalGroup(
            painelConfigGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConfigGraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConfigGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAtivoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jlbExibicao)
                    .addComponent(jtfExibicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcbIntCandles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbIntMMA)
                    .addComponent(jtfIntMMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPlotarGrafico)
                    .addComponent(jbReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelBaseAtivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelConfigGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBaseAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(painelConfigGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jmFerramentas.setText("Arquivos");

        jmiAbrirConfig.setText("Configurar Diretório");
        jmiAbrirConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbrirConfigActionPerformed(evt);
            }
        });
        jmFerramentas.add(jmiAbrirConfig);

        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmFerramentas.add(jmiSair);

        jMenuBar1.add(jmFerramentas);

        jmAjuda.setText("Ajuda");

        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jmAjuda.add(jmiSobre);

        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiSobreActionPerformed

    private void jmiAbrirConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrirConfigActionPerformed
        // TODO add your handling code here:
        jConfiguracoes.setVisible(true);
        jConfiguracoes.setLocationRelativeTo(this);
    }//GEN-LAST:event_jmiAbrirConfigActionPerformed

    private void jbPlotarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlotarGraficoActionPerformed
        // TODO add your handling code here:
        painelGrafico.removeAll();
        Grafico g = new Grafico();
        ChartPanel chart;
        
        for(int i = 0; i < jBaseAtivos.getListaAtivos().getModel().getSize(); i++){
            if(jtfAtivoAtual.getText().equals(jBaseAtivos.getListaAtivos().getModel().getElementAt(i))){
                jBaseAtivos.getListaAtivos().setSelectedIndex(i);
                break;
            }
        }
        
        int intervaloExibicao;
        int intervaloMMA;
        
        try{
            intervaloExibicao = Integer.parseInt(jtfExibicao.getText());
            intervaloMMA = Integer.parseInt(jtfIntMMA.getText());
        }catch(NumberFormatException e){
            intervaloExibicao = (int) Double.parseDouble(jtfExibicao.getText());
            intervaloMMA = (int) Double.parseDouble(jtfIntMMA.getText());
            jtfExibicao.setText(String.valueOf((int) Double.parseDouble(jtfExibicao.getText())));
            jtfIntMMA.setText(String.valueOf((int) Double.parseDouble(jtfIntMMA.getText())));
        }
        
        if(jcbIntCandles.getSelectedIndex() == 1){
            intervaloMMA*=7;
        }
        
        if(intervaloMMA > 24 || intervaloMMA < 1){
            if(jcbIntCandles.getSelectedIndex() == 1){
                JOptionPane.showMessageDialog(rootPane, "Insira um valor entre 1 e 3 semanas", "Erro!", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Insira um valor entre 1 e 24 dias", "Erro!", JOptionPane.WARNING_MESSAGE);
            }  
        }
        else if(intervaloExibicao > 240 || intervaloExibicao < 1){
            if(jcbIntCandles.getSelectedIndex() == 1){
                JOptionPane.showMessageDialog(rootPane, "Insira um valor entre 1 e 34 semanas");
            }else{
                JOptionPane.showMessageDialog(rootPane, "Insira um valor entre 1 e 240 dias!", "Erro!", JOptionPane.WARNING_MESSAGE);
            }  
        }
        else if(!verificaInputAtivo(jtfAtivoAtual.getText())){
            JOptionPane.showMessageDialog(rootPane, "O Ativo Digitado não está na Base de Ativos!", "Erro!", JOptionPane.WARNING_MESSAGE);
        }
        else{
            try {
            chart = g.plotarGrafico(jtfAtivoAtual.getText(), jConfiguracoes.getDiretorio()+"/"+jtfAtivoAtual.getText()+".csv", intervaloExibicao, intervaloMMA, jcbIntCandles.getSelectedIndex());
            painelGrafico.setLayout(new java.awt.BorderLayout());
            painelGrafico.add(chart); 
            painelGrafico.validate();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JAcoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_jbPlotarGraficoActionPerformed

    private void jtfAtivoAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAtivoAtualKeyReleased
        // TODO add your handling code here:
        jtfAtivoAtual.setText(jtfAtivoAtual.getText().toUpperCase());
        painelConfigGrafico.validate();
    }//GEN-LAST:event_jtfAtivoAtualKeyReleased

    private void jtfAtivoAtualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfAtivoAtualMouseClicked
        // TODO add your handling code here:
        jtfAtivoAtual.setText(null);
    }//GEN-LAST:event_jtfAtivoAtualMouseClicked

    private void jbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetActionPerformed
        // TODO add your handling code here:
        if(jcbIntCandles.getSelectedIndex() == 0){
            jtfExibicao.setText("14");
            jtfIntMMA.setText("14");
        }else{
            jtfExibicao.setText("7");
            jtfIntMMA.setText("2");
        }        
    }//GEN-LAST:event_jbResetActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jcbIntCandlesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbIntCandlesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if(jcbIntCandles.getSelectedIndex() == 0){
            jlbExibicao.setText("Int. Exibição (dias)");
            jlbIntMMA.setText("Int. MMA (dias)");
            jtfExibicao.setText("14");
            jtfIntMMA.setText("14");
        }
        else{
            jlbExibicao.setText("Int. Exibição (sem.)");
            jlbIntMMA.setText("Int. MMA (sem.)");
            jtfExibicao.setText("7");
            jtfIntMMA.setText("2");
        }
    }//GEN-LAST:event_jcbIntCandlesPopupMenuWillBecomeInvisible

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JAcoes().setVisible(true);
            }
        });
    }
    
    private boolean verificaInputAtivo(String ativo){
        for (int i = 0; i < jBaseAtivos.getListaAtivos().getModel().getSize(); i++) {
            if(jBaseAtivos.getListaAtivos().getModel().getElementAt(i).equals(ativo)){
                return true;
            }
        }
        return false;
    }
    
    BaseAtivos jBaseAtivos = new BaseAtivos();
    Configuracoes jConfiguracoes = new Configuracoes();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbPlotarGrafico;
    private javax.swing.JButton jbReset;
    private javax.swing.JComboBox<String> jcbIntCandles;
    private javax.swing.JLabel jlbExibicao;
    private javax.swing.JLabel jlbIntMMA;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenu jmFerramentas;
    private javax.swing.JMenuItem jmiAbrirConfig;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JTextField jtfAtivoAtual;
    private javax.swing.JTextField jtfExibicao;
    private javax.swing.JTextField jtfIntMMA;
    private javax.swing.JPanel painelBaseAtivos;
    private javax.swing.JPanel painelConfigGrafico;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
