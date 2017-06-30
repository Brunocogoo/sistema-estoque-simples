
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexao {
    public ResultSet rtm;
    public Connection con=null;
    //abre conexao
    public void Conectar() {
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/controleEstoque", "root", "");
        System.out.println("Conectado ao banco");
    }catch(ClassNotFoundException e){
        System.out.println("Não foi possivel encontrar a classe");
    }catch(SQLException ex){
        System.out.println("Não foi possivel conectar ao banco");
    }
}
    
    public Connection getConexao(){
        return con;
    }
    //fecha conexao
    public void Desconectar(){
        try{
            con.close();
            System.out.println("Conexao fechada");
            }catch(SQLException ex){
                System.out.println("Erro ao fechar a conexao.");
            }
    }
}

   


