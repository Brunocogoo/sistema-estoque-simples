
package tela;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class TelaProduto extends javax.swing.JFrame {
    Conexao conexao=new Conexao();
    
    public TelaProduto() {    
        initComponents();
        conexao.Conectar();
        super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent  e) {
				conexao.Desconectar();
			}
		});
        
        this.setLocationRelativeTo(null);
        jLabel3.setVisible(false);
        jLabel5.setVisible(false);
        bloquearPainel();
    }
    
    void bloquearPainel(){
        jTextFieldNome.setEnabled(false);
        jTextFieldDescricao.setEnabled(false);
        butCadastrar.setEnabled(false);
        butLimpar.setEnabled(false);
    }
    
    void desbloquearPainel(){
        jTextFieldNome.setEnabled(true);
        jTextFieldDescricao.setEnabled(true);
        butCadastrar.setEnabled(true);
        butLimpar.setEnabled(true);
    }
    void ControleCadastro(){
        if(jTextFieldNome.getText().isEmpty())jLabel3.setVisible(true);
        else jLabel3.setVisible(false);
        if(jTextFieldDescricao.getText().isEmpty())jLabel5.setVisible(true);
        else jLabel5.setVisible(false);
    }
    
    void preencherTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaProduto.getModel();
        try {
            model.setRowCount(0);
            //conexao.Desconectar();
            conexao.Conectar();
            Statement st = (Statement) conexao.getConexao().createStatement();
            ResultSet rts=st.executeQuery("SELECT * FROM Produto");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("nome"),rts.getString ("categoria")});
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    void excluirProduto(){
    String produtoTabela;
    String categoriaTabela;
    int veti[];
       
    veti = tabelaProduto.getSelectedRows();
       
       if(JOptionPane.showConfirmDialog(null, "Os dados não poderão ser recuperados, tem certeza ?", "AVISO", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
       for(int lin: veti){
           produtoTabela = tabelaProduto.getValueAt(lin, 0).toString();
           categoriaTabela = tabelaProduto.getValueAt(lin,1).toString();
           try{
               Statement st = (Statement) conexao.getConexao().createStatement();
               st.executeUpdate("DELETE FROM Produto WHERE nome='" +produtoTabela +
                       "' and categoria='" + categoriaTabela+"'");
               JOptionPane.showMessageDialog(this, "O produto foi excluido com sucesso");
           }catch(SQLException ex){
               System.out.println(ex.getMessage());
           }
           
       }
}
    
    void editarProduto(){
       String nomeEditado;
       String categoriaEditado;
       int lin;
       
       try{
           Statement statement=(Statement) conexao.getConexao().createStatement();
           lin=tabelaProduto.getSelectedRow();
           nomeEditado=tabelaProduto.getValueAt(lin, 0).toString();
           categoriaEditado=tabelaProduto.getValueAt(lin, 1).toString();
           new TelaEditarProduto(nomeEditado, categoriaEditado, statement).setVisible(true);
       }catch (Exception ex){
           JOptionPane.showMessageDialog(this, "Nenhum produto foi selecionado");
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
            ResultSet rts=st.executeQuery("SELECT * FROM Produto WHERE nome LIKE'%"+jTextBuscar.getText()+"%'");
            while(rts.next()){
                model.addRow(new Object[]{rts.getString("nome"),rts.getString ("categoria")});
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
        jPanelProduto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        butCadastrar = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        butNovo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        butExcluir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butBuscar = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();

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

        jPanelProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanelProduto.setPreferredSize(new java.awt.Dimension(556, 268));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Categoria");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Campo Obrigatório");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Campo Obrigatório");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        butCadastrar.setText("Cadastrar");
        butCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCadastrarActionPerformed(evt);
            }
        });

        butLimpar.setText("Limpar");
        butLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProdutoLayout = new javax.swing.GroupLayout(jPanelProduto);
        jPanelProduto.setLayout(jPanelProdutoLayout);
        jPanelProdutoLayout.setHorizontalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProdutoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNome)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jPanelProdutoLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(butCadastrar)
                        .addGap(35, 35, 35)
                        .addComponent(butLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanelProdutoLayout.setVerticalGroup(
            jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelProdutoLayout.createSequentialGroup()
                        .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(jPanelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCadastrar)
                    .addComponent(butLimpar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        butNovo.setText("Novo");
        butNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(butNovo)
                .addGap(18, 18, 18)
                .addComponent(jPanelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CADASTRO", jPanel1);

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição"
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
        if (tabelaProduto.getColumnModel().getColumnCount() > 0) {
            tabelaProduto.getColumnModel().getColumn(0).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(1).setResizable(false);
        }

        butExcluir.setText("Excluir");
        butExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butExcluirActionPerformed(evt);
            }
        });

        butEditar.setText("Editar");
        butEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditarActionPerformed(evt);
            }
        });

        butBuscar.setText("Buscar");
        butBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butExcluir)
                    .addComponent(butEditar)
                    .addComponent(butBuscar)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("LISTA", jPanel2);

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

    private void butNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNovoActionPerformed
        desbloquearPainel();
    }//GEN-LAST:event_butNovoActionPerformed

    private void butCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastrarActionPerformed
        Produto p=new Produto();
        p.setNome(jTextFieldNome.getText());
        p.setCategoria(jTextFieldDescricao.getText());
        if(p.getNome().length()>0 && p.getCategoria().length()>0){
            try{
               PreparedStatement pst=conexao.con.prepareStatement("INSERT INTO Produto(nome, categoria) VALUES(?,?)");
                pst.setString(1, p.getNome());
                pst.setString(2, p.getCategoria());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Erro ao adicionar produtos");
            }           
        }else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");
        ControleCadastro();
        
    }//GEN-LAST:event_butCadastrarActionPerformed

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
        jTextFieldDescricao.setText(null);
        jTextFieldNome.setText(null);
    }//GEN-LAST:event_butLimparActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        preencherTabela();     
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void butExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExcluirActionPerformed
       excluirProduto();
    }//GEN-LAST:event_butExcluirActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
       editarProduto();
    }//GEN-LAST:event_butEditarActionPerformed

    private void butBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscarActionPerformed
        carregarTabelaBuscar();
    }//GEN-LAST:event_butBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBuscar;
    private javax.swing.JButton butCadastrar;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butExcluir;
    private javax.swing.JButton butLimpar;
    private javax.swing.JButton butNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables
}
