package views;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;
import models.Cliente;
import models.ClienteTCP;

/**
 *
 * @author lacomski
 */
public class LoginCliente extends javax.swing.JFrame {

    private ClienteTCP clientetcp;
    private Cliente cliente;

    
    public LoginCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        iAddress = new javax.swing.JTextField();
        iPort = new javax.swing.JTextField();
        iName = new javax.swing.JTextField();
        bLogin = new javax.swing.JButton();
        tIpPorta = new javax.swing.JLabel();
        tUsuario = new javax.swing.JLabel();
        jbEmpregador = new javax.swing.JRadioButton();
        jbEmpregado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(60, 60, 60));

        painel.setForeground(new java.awt.Color(60, 63, 65));

        iAddress.setToolTipText("");

        bLogin.setText("Entrar");
        bLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoginMouseClicked(evt);
            }
        });
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        tIpPorta.setText("IP/Porta:");

        tUsuario.setText("Usuário:");

        jbEmpregador.setSelected(true);
        jbEmpregador.setText("Empregador");
        jbEmpregador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEmpregadorMouseClicked(evt);
            }
        });
        jbEmpregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmpregadorActionPerformed(evt);
            }
        });

        jbEmpregado.setText("Empregado");
        jbEmpregado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEmpregadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tIpPorta)
                                    .addComponent(tUsuario))
                                .addGap(18, 18, 18)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iName)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addComponent(iAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(iPort, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbEmpregador)
                                    .addComponent(jbEmpregado))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tIpPorta))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tUsuario))
                .addGap(26, 26, 26)
                .addComponent(jbEmpregador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jbEmpregado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bLogin)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed

    }//GEN-LAST:event_bLoginActionPerformed

    private void jbEmpregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmpregadorActionPerformed
    }//GEN-LAST:event_jbEmpregadorActionPerformed

    private void jbEmpregadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEmpregadoMouseClicked
        this.jbEmpregador.setSelected(false);
    }//GEN-LAST:event_jbEmpregadoMouseClicked

    private void jbEmpregadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEmpregadorMouseClicked
        this.jbEmpregado.setSelected(false);
    }//GEN-LAST:event_jbEmpregadorMouseClicked

    private void bLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoginMouseClicked
    
        this.cliente = new Cliente(this.iAddress.getText(), Integer.parseInt(this.iPort.getText()), this.iName.getText());            
        this.clientetcp = new ClienteTCP(cliente);
        boolean status = false;
        try {
            status = this.clientetcp.conectar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(status == true){
            Home home = new Home(clientetcp, cliente);
            home.setVisible(true);
            this.dispose();
        } else 
            JOptionPane.showMessageDialog(null, "Falha ao conectar");        
    }//GEN-LAST:event_bLoginMouseClicked

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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JTextField iAddress;
    private javax.swing.JTextField iName;
    private javax.swing.JTextField iPort;
    private javax.swing.JRadioButton jbEmpregado;
    private javax.swing.JRadioButton jbEmpregador;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel tIpPorta;
    private javax.swing.JLabel tUsuario;
    // End of variables declaration//GEN-END:variables
}
