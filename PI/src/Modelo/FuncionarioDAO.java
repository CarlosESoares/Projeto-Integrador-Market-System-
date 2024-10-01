package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import Controle.Funcionario;

public class FuncionarioDAO {
	
	public Funcionario buscarFuncionario(String login, String senha) {
		Statement stml = null;
		Connection conn = ConexaoBanco.getConexaoMySQL();
		Funcionario f = null;
		try {
			stml = (Statement) conn.createStatement();
			ResultSet resl = null;
			resl = ((java.sql.Statement) stml).executeQuery("SELECT * FROM Funcionarios where login = '"+login+"' and senha = '"+senha+"'");
			while(resl.next())
			{
				f = new Funcionario();
				f.setIdFuncionario(resl.getInt("id_funcionario"));
				f.setSenhaFuncionario(resl.getString("senha"));
				
			}
			resl.close();
			((Connection) stml).close();
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("N foi");
        
        
        
    }
		return f;
	}

}
