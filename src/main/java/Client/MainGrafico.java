/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Shared.Settings;
import Shared.SocketUDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * @author Marco
 */
public class MainGrafico extends javax.swing.JFrame {

    int portaServer = Settings.SERVER_PORT;    //porta del server
    String ip = Settings.SERVER_IP; //172.16.102.168//localhost

    SocketUDP client = new SocketUDP();
    String StringaDelServer = "";

    FinestraComandi Fc = new FinestraComandi();

    public MainGrafico() {
        initComponents();
        Fc.setVisible(false);
        Fc.getTextArea().append("COMUNICAZIONE TRA CLIENT E SERVER:" + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitoloForm = new javax.swing.JLabel();
        jLabelStatusLed = new javax.swing.JLabel();
        jLabelStatoLedSopra = new javax.swing.JLabel();
        jButtonStatus = new javax.swing.JButton();
        jLabelAccendiLed = new javax.swing.JLabel();
        jButtonAccendi = new javax.swing.JButton();
        jLabelSpegniLed = new javax.swing.JLabel();
        jButtonSpegni = new javax.swing.JButton();
        jLabelErrore = new javax.swing.JLabel();
        jButtonCMD = new javax.swing.JButton();
        jLabelPotenziometroSopra = new javax.swing.JLabel();
        jButtonValorePotenziometro = new javax.swing.JButton();
        jLabelValorePotenziometro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabelTitoloForm.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelTitoloForm.setText("ESERCIZIO  C/S+ARDUINO");
        jLabelTitoloForm.setToolTipText("");

        jLabelStatusLed.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelStatusLed.setText("STATUS");

        jLabelStatoLedSopra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelStatoLedSopra.setText("STATO LED(ON/OFF)");

        jButtonStatus.setText("VERIFICA STATO");
        jButtonStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStatusMouseClicked(evt);
            }
        });
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });

        jLabelAccendiLed.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelAccendiLed.setText("ACCENDI LED");

        jButtonAccendi.setBackground(new java.awt.Color(51, 255, 51));
        jButtonAccendi.setText("                           ");
        jButtonAccendi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAccendiMouseClicked(evt);
            }
        });

        jLabelSpegniLed.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelSpegniLed.setText("SPEGNI LED");

        jButtonSpegni.setBackground(new java.awt.Color(255, 0, 0));
        jButtonSpegni.setText("                          ");
        jButtonSpegni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSpegniMouseClicked(evt);
            }
        });

        jLabelErrore.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelErrore.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrore.setText("WORKING...");

        jButtonCMD.setText("CMD");
        jButtonCMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCMDMouseClicked(evt);
            }
        });

        jLabelPotenziometroSopra.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelPotenziometroSopra.setText("VALORE POTENZIOMETRO");

        jButtonValorePotenziometro.setText("VERIFICA VALORE");
        jButtonValorePotenziometro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonValorePotenziometroMouseClicked(evt);
            }
        });
        jButtonValorePotenziometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValorePotenziometroActionPerformed(evt);
            }
        });

        jLabelValorePotenziometro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelValorePotenziometro.setText("VAL.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatoLedSopra)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAccendiLed)
                            .addComponent(jButtonAccendi)
                            .addComponent(jLabelSpegniLed)
                            .addComponent(jButtonSpegni, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCMD)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelStatusLed)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelPotenziometroSopra)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonValorePotenziometro)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelValorePotenziometro)
                        .addGap(85, 85, 85))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabelTitoloForm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabelErrore)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitoloForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatoLedSopra)
                    .addComponent(jLabelPotenziometroSopra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatusLed)
                    .addComponent(jButtonValorePotenziometro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAccendiLed)
                    .addComponent(jLabelValorePotenziometro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAccendi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabelSpegniLed)
                .addGap(3, 3, 3)
                .addComponent(jButtonSpegni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButtonCMD)
                .addGap(18, 18, 18)
                .addComponent(jLabelErrore)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStatusActionPerformed

    private void jButtonStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStatusMouseClicked
        // TODO add your handling code here:
        client.sendString("1", portaServer, ip);//invio il comando

        System.out.println("Mandato richiesta di ON/OFF attesa risposta...");

        StringaDelServer = client.receiveString();

        jLabelStatusLed.setText(StringaDelServer);

        System.out.println("SERVER: " + StringaDelServer);

        Fc.getTextArea().append("SERVER: " + StringaDelServer + "\n");

    }//GEN-LAST:event_jButtonStatusMouseClicked

    private void jButtonAccendiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAccendiMouseClicked
        // TODO add your handling code here:
        if (Acceso() == false) {
            client.sendString("2", portaServer, ip);//invio il comando

            System.out.println("Mandato richiesta di accensione LED");
            Fc.getTextArea().append("Mandato richiesta di accensione LED" + "\n");

            StringaDelServer = client.receiveString();
            jLabelStatusLed.setText(StringaDelServer);//modifico sempre lo stato, il button per vedere lo status serve a vedere
            jLabelErrore.setText("");

            System.out.println("SERVER: " + StringaDelServer);  //per quando un altro modifica lo stato
            Fc.getTextArea().append("SERVER: " + StringaDelServer + "\n");
        } else {
            jLabelErrore.setText("IL LED E' GIA' ACCESO");
            jLabelStatusLed.setText("Acceso");
        }
    }//GEN-LAST:event_jButtonAccendiMouseClicked

    private void jButtonSpegniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSpegniMouseClicked
        // TODO add your handling code here:
        if (Acceso()) {
            client.sendString("3", portaServer, ip);//invio il comando

            System.out.println("Mandato richiesta di spegnimento LED");
            Fc.getTextArea().append("Mandato richiesta di spegnimento LED" + "\n");

            StringaDelServer = client.receiveString();
            jLabelStatusLed.setText(StringaDelServer);
            jLabelErrore.setText("");

            System.out.println("SERVER: " + StringaDelServer);
            Fc.getTextArea().append("SERVER: " + StringaDelServer + "\n");
        } else {
            jLabelErrore.setText("IL LED E' GIA' SPENTO");
            jLabelStatusLed.setText("Spento");
        }
    }//GEN-LAST:event_jButtonSpegniMouseClicked

    private void jButtonCMDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCMDMouseClicked
        // TODO add your handling code here:
        Fc.setVisible(true);
    }//GEN-LAST:event_jButtonCMDMouseClicked

    private void jButtonValorePotenziometroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonValorePotenziometroMouseClicked
        // TODO add your handling code here:
        client.sendString("4", portaServer, ip);//invio il comando

        System.out.println("Mandato richiesta di ottenimento valore potenziometro");
        Fc.getTextArea().append("Mandato richiesta di ottenimento valore potenziometro" + "\n");

        StringaDelServer = client.receiveString();
        jLabelValorePotenziometro.setText(StringaDelServer);

        System.out.println("SERVER: " + StringaDelServer);  //per quando un altro modifica lo stato
        Fc.getTextArea().append("SERVER: " + StringaDelServer + "\n");
    }//GEN-LAST:event_jButtonValorePotenziometroMouseClicked

    private void jButtonValorePotenziometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValorePotenziometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonValorePotenziometroActionPerformed

    //VISTO CHE CI SONO PIU CLIENT OGNI VOLTA DEVO VEDERE SE E' STATO MODIFICATO DA ALTRI LO STATO
    private boolean Acceso() {
        boolean acceso = false;
        String ServerRisp = "";
        client.sendString("1", portaServer, ip);//invio il comando
        ServerRisp = client.receiveString();

        if (ServerRisp.equals("Acceso")) {
            acceso = true;
        }
        return acceso;
    }

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
            java.util.logging.Logger.getLogger(MainGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGrafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccendi;
    private javax.swing.JButton jButtonCMD;
    private javax.swing.JButton jButtonSpegni;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JButton jButtonValorePotenziometro;
    private javax.swing.JLabel jLabelAccendiLed;
    private javax.swing.JLabel jLabelErrore;
    private javax.swing.JLabel jLabelPotenziometroSopra;
    private javax.swing.JLabel jLabelSpegniLed;
    private javax.swing.JLabel jLabelStatoLedSopra;
    private javax.swing.JLabel jLabelStatusLed;
    private javax.swing.JLabel jLabelTitoloForm;
    private javax.swing.JLabel jLabelValorePotenziometro;
    // End of variables declaration//GEN-END:variables
}
