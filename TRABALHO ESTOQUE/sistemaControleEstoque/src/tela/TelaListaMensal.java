
package tela;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Conexao;
import sistemacontroleestoque.Produto;

public class TelaListaMensal extends javax.swing.JFrame {
    Conexao conexao=new Conexao();
     public TelaListaMensal() {  
         
        initComponents();
        conexao.Conectar();
        preencherTabela1();
        super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent  e) {
				conexao.Desconectar();
			}
		});
            this.setLocationRelativeTo(null);
    }
    
   
    
    
    
   

    
    final void preencherTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
        try {
            model.setRowCount(0);
            //conexao.Desconectar();
            conexao.Conectar();
            Statement st = (Statement) conexao.getConexao().createStatement();
            ResultSet rts=st.executeQuery("SELECT * FROM saida");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("produto"),rts.getString ("quantidade")});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    final void preencherTabela1(){
        DefaultTableModel model = (DefaultTableModel) tabelaProduto1.getModel();
        try {
            model.setRowCount(0);
            //conexao.Desconectar();
            conexao.Conectar();
            Statement st = (Statement) conexao.getConexao().createStatement();
            ResultSet rts=st.executeQuery("SELECT * FROM entrada");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("produto"),rts.getString ("ndanfe"),rts.getString ("fornecedor"),rts.getString ("quantidadetotal"),rts.getString ("valortotal"),rts.getString ("valorunidade")});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
   
    
    void carregarTabelaBuscar(){
      DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
        try {
            model.setRowCount(0);
            //conexao.Desconectar();
            conexao.Conectar();
            Statement st = (Statement) conexao.getConexao().createStatement();
            ResultSet rts=st.executeQuery("SELECT * FROM saida WHERE produto LIKE'%"+jTextBuscar.getText()+"%'");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("produto"),rts.getString ("quantidade")});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    void carregarTabelaBuscar1(){
      DefaultTableModel model = (DefaultTableModel) tabelaProduto1.getModel();
        try {
            model.setRowCount(0);
            //conexao.Desconectar();
            conexao.Conectar();
            Statement st = (Statement) conexao.getConexao().createStatement();
            ResultSet rts=st.executeQuery("SELECT * FROM entrada WHERE produto LIKE'%"+jTextBuscar1.getText()+"%'");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("produto"),rts.getString ("ndanfe"),rts.getString ("fornecedor"),rts.getString ("quantidadetotal"),rts.getString ("valortotal"),rts.getString ("valorunidade")});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto1 = new javax.swing.JTable();
        butBuscar1 = new javax.swing.JButton();
        jTextBuscar1 = new javax.swing.JTextField();
        Imprimirentrada = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        butBuscar = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();
        imprimirsaida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        tabelaProduto1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Danfe", "fornecedor", "Quantidade Total", "Valor Total", "Valor Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaProduto1);

        butBuscar1.setText("Buscar");
        butBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuscar1ActionPerformed(evt);
            }
        });

        Imprimirentrada.setText("Imprimir");
        Imprimirentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirentradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(butBuscar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Imprimirentrada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butBuscar1)
                    .addComponent(jTextBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Imprimirentrada)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("ENTRADA", jPanel1);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        butBuscar.setText("Buscar");
        butBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuscarActionPerformed(evt);
            }
        });

        imprimirsaida.setText("Imprimir");
        imprimirsaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirsaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(butBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imprimirsaida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butBuscar)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imprimirsaida)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("SAIDA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscarActionPerformed
        carregarTabelaBuscar();
    }//GEN-LAST:event_butBuscarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        preencherTabela();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void butBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscar1ActionPerformed
      carregarTabelaBuscar1();
      
        
    }//GEN-LAST:event_butBuscar1ActionPerformed

    private void ImprimirentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirentradaActionPerformed
        try {
            tabelaProduto1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(TelaListaMensal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImprimirentradaActionPerformed

    private void imprimirsaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirsaidaActionPerformed
        try {
            tabelaProduto.print();
        } catch (PrinterException ex) {
            Logger.getLogger(TelaListaMensal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imprimirsaidaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaListaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListaMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaMensal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimirentrada;
    private javax.swing.JButton butBuscar;
    private javax.swing.JButton butBuscar1;
    private javax.swing.JButton imprimirsaida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextBuscar1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTable tabelaProduto1;
    // End of variables declaration//GEN-END:variables
}
