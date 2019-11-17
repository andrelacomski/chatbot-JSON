package views;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.ClienteTCP;
import models.Servico;

public class EmpregadoView extends javax.swing.JFrame {

    private ClienteTCP clientetcp;
    private DefaultTableModel modelOnline;
    private DefaultTableModel modelServicos;
    private DefaultListModel modelChat;
    private ArrayList <ChatDiretoView> chat = new ArrayList<ChatDiretoView>();
    
    public void setClienteTCP(ClienteTCP clientetcp){
        this.clientetcp = clientetcp;
    }
    
    public ClienteTCP getClienteTCP(){
        return this.clientetcp;
    }
    
    public void setChat(ChatDiretoView chat){
        this.chat.add(chat);
    }
    
    public ArrayList<ChatDiretoView> getChat (){
        return this.chat;
    }
    public EmpregadoView(ClienteTCP clientetcp) {
        initComponents();
        this.modelOnline = (DefaultTableModel) this.listaOnline.getModel();
        this.modelServicos = (DefaultTableModel) this.listaServicos.getModel();
        this.modelChat = new DefaultListModel<>();
        this.listChat.setModel(this.modelChat);
        this.modelChat.clear();
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard");
        this.clientetcp = clientetcp;
    }

    private EmpregadoView() {
    }
    
    public void preencherListaOnline(ArrayList<Cliente> clientes){
     if(this.modelOnline.getRowCount() !=0)
            for(int i = 0; i < this.modelOnline.getRowCount();)
                this.modelOnline.removeRow(i);
        
        for(Cliente cliente: clientes){
            if(cliente == null) return;
            this.modelOnline.addRow(new Object[]{cliente.getNome(),
                                                   cliente.getIp(),
                                                   cliente.getPorta()});
        }
    }
        
    public void preencherListaServicos(ArrayList<Servico> servicos){
        if(this.modelServicos.getRowCount() !=0)
            for(int i = 0; i < this.modelServicos.getRowCount();)
                this.modelServicos.removeRow(i);
        
        for(Servico servico: servicos){
            if(servico == null) return;
            this.modelServicos.addRow(new Object[]{servico.getCargo(), 
                                                   servico.getSalario(), 
                                                   servico.getDescricao(),
                                                   servico.getEmpregador().getNome(),
                                                   servico.getEmpregador().getIp(),
                                                   servico.getEmpregador().getPorta()});
        }
    }
    
    public void preencherListaChat(String mensagem){
        this.modelChat.addElement(mensagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tChat = new javax.swing.JLabel();
        tOnlines = new javax.swing.JLabel();
        listaChat = new javax.swing.JScrollPane();
        listChat = new javax.swing.JList();
        iMensagem = new javax.swing.JTextField();
        bEnviarMensagem = new javax.swing.JButton();
        bDesconectar = new javax.swing.JButton();
        bMensagemPv = new javax.swing.JButton();
        tServicos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaServicos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tChat.setText("Chat Geral");

        tOnlines.setText("Usuários Onlines");

        listChat.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaChat.setViewportView(listChat);

        bEnviarMensagem.setText("ENVIAR MENSAGEM GERAL");
        bEnviarMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarMensagemMouseClicked(evt);
            }
        });

        bDesconectar.setText("DESCONECTAR");
        bDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDesconectarMouseClicked(evt);
            }
        });

        bMensagemPv.setText("MENSAGEM DIRETA");
        bMensagemPv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMensagemPvMouseClicked(evt);
            }
        });

        tServicos.setText("Serviços Disponíveis");

        listaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaga", "Salário", "Descrição", "Nome", "IP", "Porta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(listaServicos);

        listaOnline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "IP", "Porta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(listaOnline);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tServicos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(iMensagem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tChat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listaChat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bMensagemPv, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tOnlines)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tChat)
                    .addComponent(tOnlines))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(listaChat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDesconectar)
                    .addComponent(bMensagemPv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEnviarMensagem)
                .addGap(18, 18, 18)
                .addComponent(tServicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEnviarMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarMensagemMouseClicked
        clientetcp.setMensagem(this.iMensagem.getText());
        try {
            clientetcp.enviarMensagem();
            this.iMensagem.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_bEnviarMensagemMouseClicked

    private void bDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDesconectarMouseClicked
        try {
            this.clientetcp.desconectar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao desconectar: " + ex.getMessage());
        }
        LoginView login = new LoginView();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bDesconectarMouseClicked

    private void bMensagemPvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMensagemPvMouseClicked
        int row = this.listaServicos.getSelectedRow();
        Cliente auxiliar = new Cliente(this.modelServicos.getValueAt(row, 3).toString(), this.modelServicos.getValueAt(row, 4).toString(), (int) this.modelServicos.getValueAt(row, 5));
        ChatDiretoView chatDireto = new ChatDiretoView(this.clientetcp, auxiliar);
        this.chat.add(chatDireto);
        chatDireto.setVisible(true);
    }//GEN-LAST:event_bMensagemPvMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpregadoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDesconectar;
    private javax.swing.JButton bEnviarMensagem;
    private javax.swing.JButton bMensagemPv;
    private javax.swing.JTextField iMensagem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listChat;
    private javax.swing.JScrollPane listaChat;
    private javax.swing.JTable listaOnline;
    private javax.swing.JTable listaServicos;
    private javax.swing.JLabel tChat;
    private javax.swing.JLabel tOnlines;
    private javax.swing.JLabel tServicos;
    // End of variables declaration//GEN-END:variables
}
