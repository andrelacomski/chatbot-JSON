package views;

import models.ClienteTCP;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import models.Cliente;
import models.Servico;

public class HomeView extends javax.swing.JFrame {

    private ClienteTCP clientetcp;
    private DefaultListModel modelOnline;
    private DefaultTableModel modelServicos;
    private DefaultListModel modelChat;
    
    public void setClienteTCP(ClienteTCP clientetcp){
        this.clientetcp = clientetcp;
    }
    
    public HomeView(ClienteTCP clientetcp) {
        initComponents();
        this.modelOnline = new DefaultListModel<>();
        this.listaOnline.setModel(this.modelOnline);
        this.listaServicos = new JTable(modelServicos);
        this.modelChat = new DefaultListModel<>();
        this.listaChat.setModel(this.modelChat);
        this.modelChat.clear();
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard");
        this.clientetcp = clientetcp;
    }

    private HomeView() {

    }
    
    public void preencherListaOnline(ArrayList<Cliente> clientes){
        this.modelOnline.clear();
        for(Cliente cliente: clientes){
            this.modelOnline.addElement(cliente.getNome());
        }
    }

    public void preencherListaServicos(ArrayList<Servico> servicos){
        for(Servico servico: servicos){
            this.modelServicos.addRow(new Object[]{servico.getCargo(), servico.getSalario(), servico.getEmpregador().getNome(), servico.getDescricao()});
        }
    }
    
    public void preencherListaChat(String mensagem){
        this.modelChat.addElement(mensagem);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        painel = new javax.swing.JPanel();
        bDesconectar = new javax.swing.JButton();
        bEnviarMensagem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JList<String>();
        tOnline = new javax.swing.JLabel();
        tServicos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bCadastrar = new javax.swing.JButton();
        iMensagem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaChat = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaServicos = new javax.swing.JTable();

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

        bEnviarMensagem.setText("ENVIAR MENSAGEM");
        bEnviarMensagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEnviarMensagemMouseClicked(evt);
            }
        });

        listaOnline.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaOnline);

        tOnline.setText("Usuários Onlines");

        tServicos.setText("Serviços disponíveis");

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaga", "Salário", "Empregador", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listaServicos);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(tServicos)
                                .addGap(313, 313, 313))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iMensagem, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(painelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(bEnviarMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tOnline)
                                .addComponent(jScrollPane3)
                                .addComponent(bDesconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tOnline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDesconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEnviarMensagem)
                    .addComponent(bCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(tServicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        CadastrarServicoView cadastrarView= new  CadastrarServicoView(clientetcp);
        cadastrarView.setVisible(true);
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bEnviarMensagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEnviarMensagemMouseClicked
        clientetcp.setMensagem(this.iMensagem.getText());
        try {
            clientetcp.enviarMensagem();
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bDesconectar;
    private javax.swing.JButton bEnviarMensagem;
    private javax.swing.JTextField iMensagem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listaChat;
    private javax.swing.JList<String> listaOnline;
    private javax.swing.JTable listaServicos;
    private javax.swing.JPanel painel;
    private javax.swing.JLabel tOnline;
    private javax.swing.JLabel tServicos;
    // End of variables declaration//GEN-END:variables
}
