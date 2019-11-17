package views;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Servico;
import models.Servidor;

public class ServidorView extends javax.swing.JFrame {

    protected Servidor server;
    protected Thread thread;
    private DefaultTableModel modelOnline;
    private DefaultTableModel modelServicos;
    private DefaultListModel modelChatGlobal;
    
    public ServidorView() {
        initComponents();
        this.modelOnline = (DefaultTableModel) this.listaOnline.getModel();
        this.listaOnline.setModel(this.modelOnline);
        this.modelServicos = (DefaultTableModel) this.listaServicos.getModel();
        this.listaServicos.setModel(this.modelServicos);
        this.modelChatGlobal = new DefaultListModel<>();
        this.listaMensagem.setModel(this.modelChatGlobal);
        this.modelChatGlobal.clear();
        this.setTitle("Servidor");
        this.setLocationRelativeTo(null);
        this.bDesliga.setEnabled(false);
    }
    
    public void preencheListaOnline(ArrayList<Cliente> clientes){
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
    
    public void preencheListaServicos(ArrayList<Servico> servicos){
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
    
    public void preencheListaChatGlobal(String mensagem){
        this.modelChatGlobal.addElement(mensagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iPorta = new javax.swing.JTextField();
        tPorta = new javax.swing.JLabel();
        bLigar = new javax.swing.JButton();
        bDesliga = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMensagem = new javax.swing.JList();
        tOnline = new javax.swing.JLabel();
        tServico = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaOnline = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaServicos = new javax.swing.JTable();

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

        bDesliga.setText("Desligar");
        bDesliga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesligaActionPerformed(evt);
            }
        });

        listaMensagem.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaMensagem);

        tOnline.setText("Lista Online");

        tServico.setText("Lista Serviços");

        jLabel1.setText("Chat Global");

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
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listaServicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tServico)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tPorta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(iPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bLigar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bDesliga, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tOnline))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jScrollPane5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tOnline)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(tServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList listaMensagem;
    private javax.swing.JTable listaOnline;
    private javax.swing.JTable listaServicos;
    private javax.swing.JLabel tOnline;
    private javax.swing.JLabel tPorta;
    private javax.swing.JLabel tServico;
    // End of variables declaration//GEN-END:variables
}
