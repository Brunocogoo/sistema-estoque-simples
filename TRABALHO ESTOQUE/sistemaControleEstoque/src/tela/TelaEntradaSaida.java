
package tela;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import persistencia.Conexao;



public class TelaEntradaSaida extends javax.swing.JFrame {
    Conexao conexao=new Conexao();

    public TelaEntradaSaida() {
        initComponents();
        conexao.Conectar();
        //Para que a conexao seja fechada quando o JFrame quando apertar o x
        super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent  e) {
				conexao.Desconectar();
			}
		});
        this.setLocationRelativeTo(null);
        bloquear();
    }
    
    void bloquear(){
        jLabelDanfeEntrada15.setVisible(false);
        jLabelFornecedorEntrada.setVisible(false);
        jLabelProdutoEntrada14.setVisible(false);
        jLabelQuanTotalEntrada.setVisible(false);
        jLabelValorTotalEntrada.setVisible(false);
        jLabelValorUnitEntrada.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
    }
    
    
    void controleCadastroEntrada(){
        /*if(jTextProdutoEntrada.getText().length()>0 && jFormattedTextDanfeEntrada.getText().trim().length()==54
                && jTextFornecedorEntrada.getText().length()>0 && jTextQuanTotal.getText().length()>0 &&
                jTextValTotal.getText().length()>0 && jTextValorUnit.getText().length()>0){
            JOptionPane.showMessageDialog(this,"Cadastro efetuado com sucesso!");
        }else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");*/
        if(jTextProdutoEntrada.getText().isEmpty())jLabelProdutoEntrada14.setVisible(true);
        else jLabelProdutoEntrada14.setVisible(false);
        if(jFormattedTextDanfeEntrada.getText().isEmpty())jLabelDanfeEntrada15.setVisible(true);
        else jLabelDanfeEntrada15.setVisible(false);
        if(jTextFornecedorEntrada.getText().isEmpty()) jLabelFornecedorEntrada.setVisible(true);
        else jLabelFornecedorEntrada.setVisible(false);
        if(jTextQuanTotal.getText().isEmpty()) jLabelQuanTotalEntrada.setVisible(true);
        else jLabelQuanTotalEntrada.setVisible(false);
        if(jTextValTotal.getText().isEmpty()) jLabelValorTotalEntrada.setVisible(true);
        else jLabelValorTotalEntrada.setVisible(false);
        if(jTextValorUnit.getText().isEmpty()) jLabelValorUnitEntrada.setVisible(true);
        else jLabelValorUnitEntrada.setVisible(false);
            
    }
    
    void controleCadastroSaida(){
        //if(jTextField1.getText().length()>0 && jTextField2.getText().length()>0){
          //  JOptionPane.showMessageDialog(this,"Cadastro efetuado com sucesso!");
        //}else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");
        if(jTextField1.getText().isEmpty()) jLabel5.setVisible(true);
        else jLabel5.setVisible(false);
        if(jTextField2.getText().isEmpty()) jLabel6.setVisible(true);
        else jLabel6.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel169 = new javax.swing.JLabel();
        jTextProdutoEntrada = new javax.swing.JTextField();
        jLabelProdutoEntrada14 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jFormattedTextDanfeEntrada = new javax.swing.JFormattedTextField();
        jLabelDanfeEntrada15 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jTextFornecedorEntrada = new javax.swing.JTextField();
        jLabelFornecedorEntrada = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jTextQuanTotal = new javax.swing.JTextField();
        jLabelQuanTotalEntrada = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jTextValTotal = new javax.swing.JTextField();
        jLabelValorTotalEntrada = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        butCalcular = new javax.swing.JButton();
        jTextValorUnit = new javax.swing.JTextField();
        jLabelValorUnitEntrada = new javax.swing.JLabel();
        butCadastrar = new javax.swing.JButton();
        butLimpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        CadastroSaida = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Entrada"));
        jPanel5.setMinimumSize(new java.awt.Dimension(547, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(548, 367));

        jLabel169.setText("Produto");

        jLabelProdutoEntrada14.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelProdutoEntrada14.setForeground(new java.awt.Color(255, 0, 0));
        jLabelProdutoEntrada14.setText("Campo Obrigatório");

        jLabel170.setText("Nº da Danfe");

        jLabel172.setForeground(new java.awt.Color(255, 0, 0));
        jLabel172.setText("*");

        jLabel171.setForeground(new java.awt.Color(255, 0, 0));
        jLabel171.setText("*");

        jFormattedTextDanfeEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextDanfeEntradaActionPerformed(evt);
            }
        });

        jLabelDanfeEntrada15.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelDanfeEntrada15.setForeground(new java.awt.Color(255, 0, 0));
        jLabelDanfeEntrada15.setText("Campo Obrigatório");

        jLabel173.setText("Fornecedor");

        jLabel174.setForeground(new java.awt.Color(255, 0, 0));
        jLabel174.setText("*");

        jLabelFornecedorEntrada.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelFornecedorEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelFornecedorEntrada.setText("Campo Obrigatório");

        jLabel175.setText("Quantidade Total");

        jLabel176.setForeground(new java.awt.Color(255, 0, 0));
        jLabel176.setText("*");

        jLabelQuanTotalEntrada.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelQuanTotalEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelQuanTotalEntrada.setText("Campo Obrigatório");

        jLabel177.setText("Valor Total");

        jLabel178.setForeground(new java.awt.Color(255, 0, 0));
        jLabel178.setText("*");

        jLabelValorTotalEntrada.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelValorTotalEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelValorTotalEntrada.setText("Campo Obrigatório");

        jLabel179.setText("Valor Unit.");

        jLabel180.setForeground(new java.awt.Color(255, 0, 0));
        jLabel180.setText("*");

        butCalcular.setText("Calcular");
        butCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCalcularActionPerformed(evt);
            }
        });

        jLabelValorUnitEntrada.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jLabelValorUnitEntrada.setForeground(new java.awt.Color(255, 0, 0));
        jLabelValorUnitEntrada.setText("Campo Obrigatório");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel175)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel177)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextQuanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQuanTotalEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextValTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorTotalEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel179)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(butCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorUnitEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel173)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextProdutoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProdutoEntrada14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel170)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel169)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFornecedorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFornecedorEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(butCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(butLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFormattedTextDanfeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDanfeEntrada15)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel169)
                    .addComponent(jLabel171))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextProdutoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProdutoEntrada14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel172)
                    .addComponent(jLabel170, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextDanfeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDanfeEntrada15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel173)
                    .addComponent(jLabel174))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFornecedorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedorEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel175)
                    .addComponent(jLabel176))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextQuanTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuanTotalEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(jLabel178))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextValTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorTotalEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179)
                    .addComponent(jLabel180))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValorUnitEntrada)
                    .addComponent(butCalcular))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butLimpar)
                    .addComponent(butCadastrar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ENTRADA", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Saída"));

        jLabel1.setText("Produto");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        jLabel3.setText("Quantidade");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        CadastroSaida.setText("Cadastrar");
        CadastroSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroSaidaActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Campo Obrigatório");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Campo Obrigatório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(CadastroSaida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadastroSaida)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("SAIDA", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastrarActionPerformed
        if(jTextProdutoEntrada.getText().length()>0 && jFormattedTextDanfeEntrada.getText().length()>0
                && jTextFornecedorEntrada.getText().length()>0 && jTextQuanTotal.getText().length()>0 &&
                jTextValTotal.getText().length()>0 && jTextValorUnit.getText().length()>0){
            try{
               PreparedStatement pst=conexao.con.prepareStatement("INSERT INTO Entrada(produto, ndanfe, fornecedor, quantidadetotal, valortotal, valorunidade) values (?, ?, ?, ?, ?, ?)");
                pst.setString(1, jTextProdutoEntrada.getText());
                pst.setString(2, jFormattedTextDanfeEntrada.getText());
                pst.setString(3, jTextFornecedorEntrada.getText());
                pst.setString(4, jTextQuanTotal.getText());
                pst.setString(5, jTextValTotal.getText());
                pst.setString(6, jTextValorUnit.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
            }catch (SQLException ex){
                System.out.println("Erro ao inserir dados");
            }
        }else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");
        controleCadastroEntrada();
    }//GEN-LAST:event_butCadastrarActionPerformed

    private void CadastroSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroSaidaActionPerformed
        if(jTextField1.getText().length()>0 && jTextField2.getText().length()>0){
            try{
               PreparedStatement pst=conexao.con.prepareStatement("INSERT INTO Saida(produto, quantidade) VALUES(?,?)");
                pst.setString(1, jTextField1.getText());
                pst.setString(2, jTextField2.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
            }catch (SQLException ex){
                System.out.println("Erro ao inserir dados");            }
        }else JOptionPane.showMessageDialog(this, "Algum campo esta faltando!");
        controleCadastroSaida();
    }//GEN-LAST:event_CadastroSaidaActionPerformed

    private void butLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLimparActionPerformed
        jTextProdutoEntrada.setText(null);
        jFormattedTextDanfeEntrada.setText(null);
        jTextFornecedorEntrada.setText(null);
        jTextQuanTotal.setText(null);
        jTextValTotal.setText(null);
        jTextValorUnit.setText(null);
    }//GEN-LAST:event_butLimparActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jTextField1.setText(null);
       jTextField2.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void butCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCalcularActionPerformed
       float quantidade;
       float precototal;
       float precounit;
       precototal= Float.parseFloat(jTextValTotal.getText());
       quantidade= Float.parseFloat(jTextQuanTotal.getText());
       precounit=precototal/quantidade;
       jTextValorUnit.setText(String.valueOf(precounit));
    }//GEN-LAST:event_butCalcularActionPerformed

    private void jFormattedTextDanfeEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDanfeEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDanfeEntradaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEntradaSaida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastroSaida;
    private javax.swing.JButton butCadastrar;
    private javax.swing.JButton butCalcular;
    private javax.swing.JButton butLimpar;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextDanfeEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDanfeEntrada15;
    private javax.swing.JLabel jLabelFornecedorEntrada;
    private javax.swing.JLabel jLabelProdutoEntrada14;
    private javax.swing.JLabel jLabelQuanTotalEntrada;
    private javax.swing.JLabel jLabelValorTotalEntrada;
    private javax.swing.JLabel jLabelValorUnitEntrada;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFornecedorEntrada;
    private javax.swing.JTextField jTextProdutoEntrada;
    private javax.swing.JTextField jTextQuanTotal;
    private javax.swing.JTextField jTextValTotal;
    private javax.swing.JTextField jTextValorUnit;
    // End of variables declaration//GEN-END:variables
}
