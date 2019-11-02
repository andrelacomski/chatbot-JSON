package views;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Servidor;

public class ServidorView extends javax.swing.JFrame {

    protected Servidor server;
    protected Thread thread;
    private DefaultListModel modelOnline;
    private DefaultListModel modelServicos;
    private DefaultListModel modelChatGlobal;
    
    public ServidorView() {
        initComponents();
        this.modelOnline = new DefaultListModel<>();
        this.listaOnline.setModel(this.modelOnline);
        this.modelServicos = new DefaultListModel<>();
        this.listaServicos.setModel(this.modelServicos);
        this.modelChatGlobal = new DefaultListModel<>();
        this.listaMensagem.setModel(this.modelChatGlobal);
        this.setTitle("Servidor");
        this.setLocationRelativeTo(null);
        this.bDesliga.setEnabled(false);
    }
    
    public void preencheListaOnline(ArrayList<Cliente> clientes){
        this.modelOnline.clear();
        for(Cliente cliente: clientes){
            System.out.println(cliente.getNome());
            this.modelOnline.addElement(cliente.getNome());
        }
    }
    
    public void preencheListaServicos(ArrayList<Cliente> clientes){
        this.modelServicos.clear();
        for(Cliente cliente: clientes){
            System.out.println(cliente.getNome());
            this.modelServicos.addElement(cliente.getNome());
        }
    }
    
    public void preencheListaChatGlobal(ArrayList<Cliente> clientes){
        this.modelChatGlobal.clear();
        for(Cliente cliente: clientes){
            System.out.println(cliente.getNome());
            this.modelChatGlobal.addElement(cliente.getNome());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iPorta = new javax.swing.JTextField();
        tPorta = new javax.swing.JLabel();
        bLigar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JList();
        bDesliga = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaServicos = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMensagem = new javax.swing.JList();
        tOnline = new javax.swing.JLabel();
        tServico = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        listaOnline.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaOnline);

        bDesliga.setText("Desligar");
        bDesliga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesligaActionPerformed(evt);
            }
        });

        listaServicos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaServicos);

        listaMensagem.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaMensagem);

        tOnline.setText("Lista Online");

        tServico.setText("Lista Serviços");

        jLabel1.setText("Chat Global");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tPorta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bLigar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDesliga, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tOnline)
                                .addGap(127, 127, 127)
                                .addComponent(tServico)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tOnline)
                    .addComponent(tServico)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaMensagem;
    private javax.swing.JList listaOnline;
    private javax.swing.JList listaServicos;
    private javax.swing.JLabel tOnline;
    private javax.swing.JLabel tPorta;
    private javax.swing.JLabel tServico;
    // End of variables declaration//GEN-END:variables
}
