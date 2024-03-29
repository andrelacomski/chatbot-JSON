package views;

import java.io.IOException;
import javax.swing.JOptionPane;
import models.Cliente;
import models.ClienteTCP;
public class LoginView extends javax.swing.JFrame {

    static ClienteTCP clientetcp;
    private Cliente cliente;

    public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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

        iPort.setText("22000");

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

        jbEmpregado.setText("Desempregado");
        jbEmpregado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEmpregadoMouseClicked(evt);
            }
        });
        jbEmpregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmpregadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tIpPorta)
                            .addComponent(tUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(iAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iPort, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                            .addComponent(iName)))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbEmpregador)
                        .addGap(18, 18, 18)
                        .addComponent(jbEmpregado)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEmpregador)
                    .addComponent(jbEmpregado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(bLogin)
                .addGap(20, 20, 20))
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
        this.cliente = new Cliente(this.iName.getText(), this.iAddress.getText(), Integer.parseInt(this.iPort.getText()), verificaTipo());            
        EmpregadoView empregado = null;
        EmpregadorView empregador = null;
        try {
            if(verificaTipo().equals("empregado")){
                empregado = new EmpregadoView(clientetcp); 
                LoginView.clientetcp = new ClienteTCP(cliente, empregado);
                empregado.setClienteTCP(LoginView.clientetcp);
            }
            else{
                empregador = new EmpregadorView(clientetcp);
                LoginView.clientetcp = new ClienteTCP(cliente, empregador);
                empregador.setClienteTCP(LoginView.clientetcp);
            }
        } catch (IOException ex) {
            System.out.println("ERRO AO ABRIR A THREAD.");
        }
        boolean status = false;
        try {
            status = LoginView.clientetcp.conectar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        if(verificaTipo().equals("empregado"))
            empregado.setVisible(true);
        else
            empregador.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bLoginMouseClicked

    private void jbEmpregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmpregadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEmpregadoActionPerformed

    public String verificaTipo(){
        if(jbEmpregado.isSelected())
            return "empregado";
        else
            return "empregador";
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.ButtonGroup buttonGroup1;
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
