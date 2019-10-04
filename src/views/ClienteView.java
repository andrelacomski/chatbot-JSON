package views;

import models.ClienteTCP;
import java.awt.Color;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lacomski
 */
public class ClienteView extends javax.swing.JFrame {

    private ClienteTCP cliente;
    
    public ClienteView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cliente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        tServidor = new javax.swing.JLabel();
        tPorta = new javax.swing.JLabel();
        bConectar = new javax.swing.JButton();
        iServidor = new javax.swing.JTextField();
        iPorta = new javax.swing.JTextField();
        tStatus = new javax.swing.JLabel();
        bDesconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        iMensagem = new javax.swing.JTextArea();
        bEnviarMensagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setForeground(new java.awt.Color(60, 63, 65));

        tServidor.setText("Servidor:");

        tPorta.setText("Porta:");

        bConectar.setText("CONECTAR");
        bConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bConectarMouseClicked(evt);
            }
        });

        tStatus.setForeground(new java.awt.Color(255, 0, 0));
        tStatus.setText("DESCONECTADO");

        bDesconectar.setText("DESCONECTAR");
        bDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDesconectarMouseClicked(evt);
            }
        });

        iMensagem.setColumns(20);
        iMensagem.setRows(5);
        jScrollPane1.setViewportView(iMensagem);

        bEnviarMensagem.setText("ENVIAR MENSAGEM");
        bEnviarMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarMensagemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tPorta)
                            .addComponent(tServidor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iServidor)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(tStatus)
                                .addGap(0, 118, Short.MAX_VALUE))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tServidor)
                    .addComponent(iServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPorta)
                    .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tStatus))
                .addGap(18, 18, 18)
                .addComponent(bConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDesconectar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bEnviarMensagem)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bConectarMouseClicked
        String servidor = this.iServidor.getText();
        int porta = Integer.parseInt(this.iPorta.getText());
        this.cliente = new ClienteTCP(servidor, porta);
        boolean status = false;
        try {
            status = this.cliente.conectar();
        } catch (IOException ex) {
            this.tStatus.setText("FALHA AO CONECTAR: " + ex);
            this.tStatus.setForeground(Color.red);
        }
        if(status == true){
            this.tStatus.setText("CONECTADO");
            this.tStatus.setForeground(Color.green);
        } else {
            this.tStatus.setText("FALHA AO CONECTAR");
            this.tStatus.setForeground(Color.red);
        }        
    }//GEN-LAST:event_bConectarMouseClicked

    private void bDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDesconectarMouseClicked
        try {
            this.cliente.desconectar();
        } catch (IOException ex) {
            this.tStatus.setText("FALHA AO DESCONECTAR: " + ex);
            this.tStatus.setForeground(Color.red);
        }
        this.tStatus.setText("DESCONECTADO");
        this.tStatus.setForeground(Color.red);
    }//GEN-LAST:event_bDesconectarMouseClicked

    private void bEnviarMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarMensagemMouseClicked
        cliente.setMensagem(this.iMensagem.getText());
        boolean retorno = false;
        try {
            retorno = cliente.enviarMensagem();
        } catch (IOException ex) {
            this.iMensagem.setText("ERRO: " + ex);
        }
        if(retorno)
            this.iMensagem.setText(this.cliente.getMensagem());
        
    }//GEN-LAST:event_bEnviarMensagemMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConectar;
    private javax.swing.JButton bDesconectar;
    private javax.swing.JButton bEnviarMensagem;
    private javax.swing.JTextArea iMensagem;
    private javax.swing.JTextField iPorta;
    private javax.swing.JTextField iServidor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel tPorta;
    private javax.swing.JLabel tServidor;
    private javax.swing.JLabel tStatus;
    // End of variables declaration//GEN-END:variables
}
