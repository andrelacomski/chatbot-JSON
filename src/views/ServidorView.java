package views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Servidor;
import models.ServidorTCP;

public class ServidorView extends javax.swing.JFrame {

    protected Servidor server;
    protected Thread thread;
    
    public ServidorView() {
        initComponents();
        this.setTitle("Servidor");
        this.setLocationRelativeTo(null);
        this.bDesliga.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iPorta = new javax.swing.JTextField();
        tPorta = new javax.swing.JLabel();
        bLigar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        bDesliga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iPorta.setText("22000");

        tPorta.setText("Porta:");

        bLigar.setText("Ligar");
        bLigar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLigarMouseClicked(evt);
            }
        });
        bLigar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLigarActionPerformed(evt);
            }
        });

        lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

        bDesliga.setText("Desligar");
        bDesliga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesligaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bLigar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDesliga, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPorta)
                    .addComponent(bLigar)
                    .addComponent(bDesliga))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLigarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLigarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLigarActionPerformed

    private void bLigarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLigarMouseClicked
        this.bLigar.setEnabled(false);
        this.bDesliga.setEnabled(true);
        server = new Servidor(Integer.parseInt(iPorta.getText()), this);
        thread = new Thread(server);
        thread.start();
    }//GEN-LAST:event_bLigarMouseClicked

    private void bDesligaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesligaActionPerformed
        try {
            int confirma = JOptionPane.showConfirmDialog(null, "DESLIGAR SERVIDOR?");
            if (confirma == 0)
                server.stop();
        } catch (Exception e) {
            System.out.println("SOCKET CLOSED");
        }
    }//GEN-LAST:event_bDesligaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDesliga;
    private javax.swing.JButton bLigar;
    private javax.swing.JTextField iPorta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JLabel tPorta;
    // End of variables declaration//GEN-END:variables
}
