
package tela;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemacontroleestoque.Fornecedor;

public class TelaFornecedor extends javax.swing.JFrame {
    Conexao conexao=new Conexao();
    
    public TelaFornecedor() {
        initComponents();
        conexao.Conectar();
          
        
        super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent  e) {
				conexao.Desconectar();
			}
		});
        
        this.setLocationRelativeTo(null);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        bloquearPainel();
    }

    void bloquearPainel(){
        butCadastro.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldEndereco.setEnabled(false);
        jFormattedTextFieldTelefone.setEnabled(false);
        jFormattedTextFieldCnpj.setEnabled(false);
        jPanelCadastro.setEnabled(false);
        butLimpar.setEnabled(false);
    }
    void desbloquearPainel(){
        butCadastro.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jTextFieldEndereco.setEnabled(true);
        jFormattedTextFieldTelefone.setEnabled(true);
        jFormattedTextFieldCnpj.setEnabled(true);
        jLabelNome.setEnabled(true);
        jLabelEndereco.setEnabled(true);
        jLabelTelefone.setEnabled(true);
        jLabelCnpj.setEnabled(true);
        jPanelCadastro.setEnabled(true);
        butLimpar.setEnabled(true);
    }
    
    void preencherTabela (){
        DefaultTableModel model = (DefaultTableModel) tabelaFornecedor.getModel();
        try{
           model.setRowCount(0);
           conexao.Conectar();
           Statement st=(Statement) conexao.getConexao().createStatement();
           ResultSet rs=st.executeQuery("SELECT * FROM fornecedor");
           while(rs.next()){
               model.addRow(new Object[]{rs.getString("nome"), rs.getString("endereco"), rs.getString("cnpj"),
                                                                                   rs.getString("telefone")});
           }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    void excluirFornecedor(){
        String nomeRemover;
       String enderecoRemover;
       String cnpjRemover;
       String telefoneRemover;
       int veti[];
       veti = tabelaFornecedor.getSelectedRows(); 
       if(JOptionPane.showConfirmDialog(null, "Os dados não poderão ser recuperados, tem certeza ?", "AVISO", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
               
           for(int lin: veti){
           nomeRemover = tabelaFornecedor.getValueAt(lin, 0).toString();
           enderecoRemover = tabelaFornecedor.getValueAt(lin,1).toString();
           cnpjRemover = tabelaFornecedor.getValueAt(lin, 2).toString();
           telefoneRemover = tabelaFornecedor.getValueAt(lin, 3).toString();
           
           try{
               Statement st = (Statement) conexao.getConexao().createStatement();
               st.executeUpdate("DELETE FROM Fornecedor WHERE nome='" +nomeRemover +
                       "' and endereco='" + enderecoRemover+"' and cnpj='" + cnpjRemover+"' and telefone='"+telefoneRemover+"'");
               JOptionPane.showMessageDialog(this, "O fornecedor foi excluido com sucesso");
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(this, "Nenhum fornecedor foi selecionado");
               System.out.println(ex.getMessage());
           }
           
       }
    }
    
   void EditarFornecedor(){
      String nomeEditar;
      String enderecoEditar ;
      String cnpjEditar ;
      String telefoneEditar ;
      int lin;
      
      try{
      Statement st = (Statement) conexao.getConexao().createStatement();;
      lin=tabelaFornecedor.getSelectedRow();
      nomeEditar=tabelaFornecedor.getValueAt(lin, 0).toString();
      enderecoEditar=tabelaFornecedor.getValueAt(lin, 1).toString();
      cnpjEditar=tabelaFornecedor.getValueAt(lin, 2).toString();
      telefoneEditar=tabelaFornecedor.getValueAt(lin, 3).toString();
      new TelaEditarFornecedor(nomeEditar,enderecoEditar,cnpjEditar,telefoneEditar,st).setVisible(true);
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Nenhum fornecedor foi selecionado");
      }
   }
    
    void ControleCampoObrigatorio(){
        if(jTextFieldNome.getText().isEmpty())jLabel9.setVisible(true);
            else jLabel9.setVisible(false);
                if(jTextFieldEndereco.getText().isEmpty())jLabel10.setVisible(true);
                else jLabel10.setVisible(false);
                    if(jFormattedTextFieldCnpj.getText().trim().length()<18) jLabel12.setVisible(true);
                    else jLabel12.setVisible(false);
                        if(jFormattedTextFieldTelefone.getText().trim().length()<13)jLabel11.setVisible(true);
                        else jLabel11.setVisible(false);
    }
    
    void carregaTabelaBuscar(){
    DefaultTableModel model = (DefaultTableModel) tabelaFornecedor.getModel();
        try{
           model.setRowCount(0);
           conexao.Conectar();
           Statement st=(Statement) conexao.getConexao().createStatement();
           ResultSet rs=st.executeQuery("SELECT * FROM Fornecedor WHERE nome LIKE '%"+jTextBuscar.getText()+"%'");
           while(rs.next()){
               model.addRow(new Object[]{rs.getString("nome"), rs.getString("endereco"), rs.getString("cnpj"),
                                                                                   rs.getString("telefone")});
           }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabelaFornecedor = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelCadastro = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabelCnpj = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldCnpj = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        butCadastro = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        jTextFieldEndereco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFornecedor = new javax.swing.JTable();
        butExcluir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butBuscar = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TabelaFornecedor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabelaFornecedorStateChanged(evt);
            }
        });

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanelCadastro.setPreferredSize(new java.awt.Dimension(510, 330));

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNome.setText("Nome");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelEndereco.setText("Endereço");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTelefone.setText("Telefone");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCnpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCnpj.setText("CNPJ");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        try {
            jFormattedTextFieldCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Campo Obrigatório");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Campo Obrigatório");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Campo Obrigatório");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Campo Obrigatório");

        butCadastro.setText("Cadastrar");
        butCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCadastroActionPerformed(evt);
            }
        });

        butLimpar.setText("Limpar");
        butLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabelCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jLabelEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNome)
                            .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelCadastroLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(butCadastro)
                            .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(butLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCnpj)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(40, 40, 40)
                .addGroup(jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butCadastro)
                    .addComponent(butLimpar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jPanelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        TabelaFornecedor.addTab("CADASTRO", jPanel1);

        tabelaFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço", "CNPJ", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaFornecedor);
        if (tabelaFornecedor.getColumnModel().getColumnCount() > 0) {
            tabelaFornecedor.getColumnModel().getColumn(0).setResizable(false);
            tabelaFornecedor.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabelaFornecedor.getColumnModel().getColumn(1).setResizable(false);
            tabelaFornecedor.getColumnModel().getColumn(2).setResizable(false);
            tabelaFornecedor.getColumnModel().getColumn(2).setPreferredWidth(5);
            tabelaFornecedor.getColumnModel().getColumn(3).setResizable(false);
            tabelaFornecedor.getColumnModel().getColumn(3).setPreferredWidth(2);
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butExcluir)
                    .addComponent(butEditar)
                    .addComponent(butBuscar)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        TabelaFornecedor.addTab("LISTA", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabelaFornecedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabelaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    desbloquearPainel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastroActionPerformed
        Fornecedor f = new Fornecedor();
        f.setNome(jTextFieldNome.getText());
        f.setCnpj(jFormattedTextFieldCnpj.getText());        
        f.setTelefone(jFormattedTextFieldTelefone.getText());
        f.setEndereco(jTextFieldEndereco.getText());
        if(f.getNome().length()>0 && f.getEndereco().length()>0
        && f.getCnpj().trim().length()==18 && f.getTelefone().trim().length()==13){
        try {
            PreparedStatement pst=conexao.con.prepareStatement("INSERT INTO Fornecedor(nome, cnpj, telefone, endereco) values (?,?,?,?)");
            pst.setString(1, f.getNome());
            pst.setString(2, f.getCnpj());
            pst.setString(3, f.getTelefone());
            pst.setString(4, f.getEndereco());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir fornecedor");
            System.out.println(ex.getMessage());
        }
        }else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");
        ControleCampoObrigatorio();
    }//GEN-LAST:event_butCadastroActionPerformed

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
        jTextFieldNome.setText(null);
        jTextFieldEndereco.setText(null);
        jFormattedTextFieldCnpj.setText(null);
        jFormattedTextFieldTelefone.setText(null);
    }//GEN-LAST:event_butLimparActionPerformed

    private void TabelaFornecedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabelaFornecedorStateChanged
        preencherTabela();
    }//GEN-LAST:event_TabelaFornecedorStateChanged

    private void butExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butExcluirActionPerformed
       excluirFornecedor();
    }//GEN-LAST:event_butExcluirActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
      EditarFornecedor();
      
      
              
    }//GEN-LAST:event_butEditarActionPerformed

    private void butBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuscarActionPerformed
      carregaTabelaBuscar();
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
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabelaFornecedor;
    private javax.swing.JButton butBuscar;
    private javax.swing.JButton butCadastro;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butExcluir;
    private javax.swing.JButton butLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCnpj;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCnpj;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTable tabelaFornecedor;
    // End of variables declaration//GEN-END:variables
}
