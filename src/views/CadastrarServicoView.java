package views;

import java.io.IOException;
import java.text.DecimalFormat;
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
        bVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iSalario.setToolTipText("");
        iSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iSalarioKeyPressed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tDescricao)
                            .addComponent(tCargo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tSalario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iSalario)
                            .addComponent(iCargo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(bVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCadastrarMouseClicked
        Servico servico = new Servico(iCargo.getText(), iDescricao.getText(), Float.parseFloat(iSalario.getText().replace(",",".")));
        try {
            clientetcp.cadastrarServico(servico);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarServicoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_bCadastrarMouseClicked

    private void iSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iSalarioKeyPressed

    }//GEN-LAST:event_iSalarioKeyPressed

    private void bVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_bVoltarMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarServicoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField iCargo;
    private javax.swing.JTextArea iDescricao;
    private javax.swing.JTextField iSalario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tCargo;
    private javax.swing.JLabel tDescricao;
    private javax.swing.JLabel tSalario;
    // End of variables declaration//GEN-END:variables
}
