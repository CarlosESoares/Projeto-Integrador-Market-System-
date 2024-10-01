package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessoDeLogin {
    Connection conn = ConexaoBanco.getConexaoMySQL();
    String sql = "SELECT * FROM funcionarios WHERE cpf = ? AND senha = ?";
    ResultSet rs = null;

    		    String url = "jdbc:mysql://localhost:3306/mercado";
    String user = "root";
    String password = "aluno";{
    
    try (Connection connection = DriverManager.getConnection(url, user, password)){
 System.out.println("Conectado!");
    }catch(SQLException e) {
    	e.printStackTrace();
    		System.out.println("falha na conexão");}}
    }


   
