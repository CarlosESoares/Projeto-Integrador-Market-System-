package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import Modelo.ConexaoBanco;
import visao.Login;

public class ProcessoDeLogin {
    Connection conn = ConexaoBanco.conector();
    String sql = "SELECT * FROM funcionarios WHERE cpf = ? AND senha = ?";
    ResultSet rs = null;

    		    String url = "jdbc:mysql://localhost:3306/mercado";
    String user = "root";
    String password = "Aluno";{
    
    try (Connection connection = DriverManager.getConnection(url, user, password)){
 System.out.println("Conectado!");
    }catch(SQLException e) {
    	e.printStackTrace();
    		System.out.println("falha na conexão");}}
    }


   
