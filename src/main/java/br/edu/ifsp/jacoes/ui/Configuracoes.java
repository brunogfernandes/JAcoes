/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jacoes.ui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author caca1
 */
public class Configuracoes extends javax.swing.JFrame {
    /**
     * Creates new form SelecionarArquivo
     */
    public Configuracoes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfDiretorio = new javax.swing.JTextField();
        jbSalvarDiretorio = new javax.swing.JButton();
        jbAbrir = new javax.swing.JButton();
        jbCancelarDiretorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Escolha o diretório de seus arquivos .csv");

        jtfDiretorio.setEditable(false);
        jtfDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDiretorioActionPerformed(evt);
            }
        });

        jbSalvarDiretorio.setText("Salvar");
        jbSalvarDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarDiretorioActionPerformed(evt);
            }
        });

        jbAbrir.setText("Abrir");
        jbAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbrirActionPerformed(evt);
            }
        });

        jbCancelarDiretorio.setText("Cancelar");
        jbCancelarDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarDiretorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addGap(0, 133, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfDiretorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAbrir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvarDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCancelarDiretorio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbrir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCancelarDiretorio)
                    .addComponent(jbSalvarDiretorio))
                .addGap(18, 18, 18))
        );

        getAccessibleContext().setAccessibleName("Selecionar diretório");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDiretorioActionPerformed

    }//GEN-LAST:event_jtfDiretorioActionPerformed

    private void jbCancelarDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarDiretorioActionPerformed
        jtfDiretorio.setText(dirAnterior);
    }//GEN-LAST:event_jbCancelarDiretorioActionPerformed

    private void jbSalvarDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarDiretorioActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalvarDiretorioActionPerformed

    private void jbAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbrirActionPerformed
        dirAnterior = jtfDiretorio.getText();
        
        JFileChooser fileChooser = new JFileChooser();
        // Nome
        fileChooser.setDialogTitle("Procurar diretório");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Seleciona apenas arquivos com extensão csv
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos csv", "csv");      
        fileChooser.setFileFilter(filter);

        int retorno = fileChooser.showOpenDialog(this);

        if(retorno == JFileChooser.APPROVE_OPTION){
            //Preenchimento do diretório
            file = fileChooser.getSelectedFile();
            jtfDiretorio.setText(file.getPath());
        }
    }//GEN-LAST:event_jbAbrirActionPerformed

    
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
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracoes().setVisible(true);
            }
        });
    }
    
    public String getDiretorio(){
        return jtfDiretorio.getText();
    }
    
    private File file;
    private String dirAnterior;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAbrir;
    private javax.swing.JButton jbCancelarDiretorio;
    private javax.swing.JButton jbSalvarDiretorio;
    private javax.swing.JTextField jtfDiretorio;
    // End of variables declaration//GEN-END:variables
}
