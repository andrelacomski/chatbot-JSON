package views;

import com.google.gson.Gson;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import models.Cliente;
import models.ClienteTCP;
import models.Protocolo;

public class ChatDiretoView extends javax.swing.JFrame {

    private ClienteTCP clientetcp;
    private Cliente cliente;
    private DefaultListModel modelMensagem;
    
    public ChatDiretoView() {
    
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public ChatDiretoView(ClienteTCP clientetcp, Cliente cliente){
        initComponents();
        this.setTitle("Chat");
        this.setLocationRelativeTo(null);
        this.clientetcp = clientetcp;
        this.cliente = cliente;
        this.modelMensagem = new DefaultListModel<>();
        this.listarMensagens.setModel(this.modelMensagem);
        modelMensagem.clear();
    }
    
    public void preencheMensagem(String mensagem){
        this.modelMensagem.addElement(mensagem);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listarMensagens = new javax.swing.JList();
        iMensagem = new javax.swing.JTextField();
        bVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bEnviar.setText("ENVIAR");
        bEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarMouseClicked(evt);
            }
        });

        listarMensagens.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listarMensagens);

        bVoltar.setText("VOLTAR");
        bVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(iMensagem)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEnviar)
                    .addComponent(bVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarMouseClicked
        Protocolo protocolo = new Protocolo("mensagemDireta");
        Gson gson = new Gson();
        String mensagem = "[EU]: " + iMensagem.getText();
        protocolo.setMensagem(iMensagem.getText());
        this.modelMensagem.addElement(mensagem);
        protocolo.setDestinatario(this.cliente);
        try {
            this.clientetcp.setChat(this);
            this.clientetcp.mensagemDireta(protocolo);
            this.iMensagem.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao enviar mensagem: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_bEnviarMouseClicked

    private void bVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVoltarMouseClicked
        int confirma = JOptionPane.showConfirmDialog(null, "Você perderá as mensagem, deseja continuar?");
        if (confirma == 0)
            this.dispose();
    }//GEN-LAST:event_bVoltarMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatDiretoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEnviar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField iMensagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listarMensagens;
    // End of variables declaration//GEN-END:variables
}
