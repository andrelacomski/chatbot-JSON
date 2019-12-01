package views;

import models.ClienteTCP;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Protocolo;
import models.Servico;

public class EmpregadorView extends javax.swing.JFrame {

    private ClienteTCP clientetcp;
    private ArrayList<Servico> servicos;
    private DefaultTableModel modelOnline;
    private DefaultTableModel modelServicos;
    private DefaultTableModel modelInteressados;
    private DefaultListModel modelChat;
    private ArrayList<ChatDiretoView> chat = new ArrayList<ChatDiretoView>();

    public void setServico(Servico servico){
        this.servicos.add(servico);
    }
    
    public void setClienteTCP(ClienteTCP clientetcp) {
        this.clientetcp = clientetcp;
    }

    public ClienteTCP getClienteTCP() {
        return this.clientetcp;
    }

    public void setChat(ChatDiretoView chat) {
        this.chat.add(chat);
    }

    public ArrayList<ChatDiretoView> getChat() {
        return this.chat;
    }

    public EmpregadorView(ClienteTCP clientetcp) {
        initComponents();
        this.modelOnline = (DefaultTableModel) this.listaOnline.getModel();
        this.listaOnline.setModel(this.modelOnline);
        this.modelServicos = (DefaultTableModel) this.listaServicos.getModel();
        this.modelInteressados = (DefaultTableModel) this.listaInteressados.getModel();
        this.modelChat = new DefaultListModel<>();
        this.listaChat.setModel(this.modelChat);
        this.modelChat.clear();
        this.servicos = new ArrayList();
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard");
        this.clientetcp = clientetcp;
    }

    private EmpregadorView() {

    }

    public void preencherListaOnline(ArrayList<Cliente> clientes) {
        if (this.modelOnline.getRowCount() != 0) {
            for (int i = 0; i < this.modelOnline.getRowCount();) {
                this.modelOnline.removeRow(i);
            }
        }

        for (Cliente cliente : clientes) {
            if (cliente == null) {
                return;
            }
            this.modelOnline.addRow(new Object[]{cliente.getNome(),
                cliente.getIp(),
                cliente.getPorta()});
        }
    }

    public void preencherListaServicos(ArrayList<Servico> servicos) {
        if (this.modelServicos.getRowCount() != 0) {
            for (int i = 0; i < this.modelServicos.getRowCount();) {
                this.modelServicos.removeRow(i);
            }
        }

        for (Servico servico : servicos) {
            if (servico == null) {
                return;
            }
            if (servico.getEmpregador().getNome().equals(this.clientetcp.getCliente().getNome())) {
                this.modelServicos.addRow(new Object[]{servico.getCargo(),
                    servico.getSalario(),
                    servico.getDescricao()});
            }
        }
    }

    public void preencherListaInteressados(ArrayList<Protocolo> interessados) {
        if (this.modelInteressados.getRowCount() != 0) {
            for (int i = 0; i < this.modelInteressados.getRowCount();) {
                this.modelInteressados.removeRow(i);
            }
        }

        for (Protocolo interessado : interessados) {
            this.setServico(interessado.getServico());
            if (interessados == null) {
                return;
            }
            for (Cliente desempregado : interessado.getInteressados()) {
                this.modelInteressados.addRow(new Object[]{desempregado.getNome(),
                    desempregado.getIp(),
                    desempregado.getPorta(),
                    interessado.getServico().getCargo()});
            }
        }
    }

    public void preencherListaChat(String mensagem) {
        this.modelChat.addElement(mensagem);
    }

    public void servidorClose() {
        JOptionPane.showMessageDialog(null, "Servidor fechado! Tente mais tarde");
        LoginView login = new LoginView();
        login.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        painel = new javax.swing.JPanel();
        bDesconectar = new javax.swing.JButton();
        bEnviarMensagem = new javax.swing.JButton();
        tOnline = new javax.swing.JLabel();
        tServicos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        iMensagem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaChat = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaServicos = new javax.swing.JTable();
        bMensagemPv = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaInteressados = new javax.swing.JTable();
        bContratar = new javax.swing.JButton();
        tInteressados = new javax.swing.JLabel();

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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setForeground(new java.awt.Color(60, 63, 65));

        bDesconectar.setText("DESCONECTAR");
        bDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDesconectarMouseClicked(evt);
            }
        });

        bEnviarMensagem.setText("ENVIAR MENSAGEM GERAL");
        bEnviarMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarMensagemMouseClicked(evt);
            }
        });

        tOnline.setText("Usuários Onlines");

        tServicos.setText("Meus serviços");

        jLabel3.setText("Chat Geral");

        bCadastrar.setText("CADASTRAR SERVIÇO");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        listaChat.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaChat);

        listaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaga", "Salário", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listaServicos);

        bMensagemPv.setText("MENSAGEM DIRETA");
        bMensagemPv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMensagemPvMouseClicked(evt);
            }
        });

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
        jScrollPane2.setViewportView(listaOnline);

        listaInteressados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "IP", "Porta", "Vaga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(listaInteressados);

        bContratar.setText("CONTRATAR");
        bContratar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bContratarMouseClicked(evt);
            }
        });

        tInteressados.setText("Lista de Interessados");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(iMensagem)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tOnline)
                            .addComponent(bMensagemPv, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tServicos)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tInteressados)
                                .addGap(161, 161, 161)
                                .addComponent(bContratar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tOnline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMensagemPv))
                .addGap(13, 13, 13)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEnviarMensagem)
                    .addComponent(bCadastrar)
                    .addComponent(bDesconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tServicos)
                    .addComponent(bContratar)
                    .addComponent(tInteressados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        CadastrarServicoView cadastrarView = new CadastrarServicoView(clientetcp);
        cadastrarView.setVisible(true);
    }//GEN-LAST:event_bCadastrarActionPerformed

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
        int row = this.listaOnline.getSelectedRow();
        Cliente auxiliar = new Cliente(this.modelOnline.getValueAt(row, 0).toString(), this.modelOnline.getValueAt(row, 1).toString(), (int) this.modelOnline.getValueAt(row, 2));
        ChatDiretoView chatDireto = new ChatDiretoView(this.clientetcp, auxiliar);
        this.chat.add(chatDireto);
        chatDireto.setVisible(true);
    }//GEN-LAST:event_bMensagemPvMouseClicked

    private void bContratarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bContratarMouseClicked
        int row = this.listaInteressados.getSelectedRow();;
        Cliente contratado = new Cliente(this.modelInteressados.getValueAt(row, 0).toString(), this.modelInteressados.getValueAt(row, 1).toString(), (int) this.modelInteressados.getValueAt(row, 2));
        Servico s = new Servico();
        for(Servico servico: this.servicos){
            if(servico.getCargo().equals(this.modelInteressados.getValueAt(row, 3).toString())){
                s = servico;
            }
        }
        clientetcp.contratacao(s, contratado);
    }//GEN-LAST:event_bContratarMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpregadorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bContratar;
    private javax.swing.JButton bDesconectar;
    private javax.swing.JButton bEnviarMensagem;
    private javax.swing.JButton bMensagemPv;
    private javax.swing.JTextField iMensagem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listaChat;
    private javax.swing.JTable listaInteressados;
    private javax.swing.JTable listaOnline;
    private javax.swing.JTable listaServicos;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel tInteressados;
    private javax.swing.JLabel tOnline;
    private javax.swing.JLabel tServicos;
    // End of variables declaration//GEN-END:variables
}
