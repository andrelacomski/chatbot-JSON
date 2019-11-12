package views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;
import models.ClienteTCP;
import models.Servico;

public class CadastrarServicoView extends javax.swing.JFrame {

    protected ClienteTCP clientetcp;
    protected Cliente cliente;
    
    public CadastrarServicoView() {
        initComponents();
        this.setTitle("Cadastrar Serviço");
        this.setLocationRelativeTo(null);
    }

    public CadastrarServicoView(ClienteTCP clientetcp){
        initComponents();
        this.setTitle("Cadastrar Serviço");
        this.setLocationRelativeTo(null);
        this.clientetcp = clientetcp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iCargo = new javax.swing.JTextField();
        iSalario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        iDescricao = new javax.swing.JTextArea();
        bCadastrar = new javax.swing.JButton();
        tCargo = new javax.swing.JLabel();
        tSalario = new javax.swing.JLabel();
        tDescricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iDescricao.setColumns(20);
        iDescricao.setRows(5);
        jScrollPane1.setViewportView(iDescricao);

        bCadastrar.setText("CADASTRAR SERVIÇO");
        bCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCadastrarMouseClicked(evt);
            }
        });

        tCargo.setText("Cargo:");

        tSalario.setText("Salário:");

        tDescricao.setText("Descrição:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tDescricao)
                            .addComponent(tCargo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tSalario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iSalario)
                            .addComponent(iCargo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))
                    .addComponent(bCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCargo))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDescricao))
                .addGap(29, 29, 29)
                .addComponent(bCadastrar)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCadastrarMouseClicked
        Servico servico = new Servico(iCargo.getText(), iDescricao.getText(), Float.parseFloat(iSalario.getText()));
        try {
            clientetcp.cadastrarServico(servico);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarServicoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_bCadastrarMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarServicoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JTextField iCargo;
    private javax.swing.JTextArea iDescricao;
    private javax.swing.JTextField iSalario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tCargo;
    private javax.swing.JLabel tDescricao;
    private javax.swing.JLabel tSalario;
    // End of variables declaration//GEN-END:variables
}
