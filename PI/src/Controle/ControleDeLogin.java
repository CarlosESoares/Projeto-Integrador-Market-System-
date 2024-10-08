package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.GenericDAO;

public class ControleDeLogin extends GenericDAO{
	
	//Método para verificar se o banco esta online
	public Boolean bancoOnline()  {
		Connection valor = conectarDAO();
		if (valor != null){
			try {
				conectarDAO().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		} else
			return false;
	}
	
	
	// Método para autenticar usuários
	public Funcionario autenticar(String login, String senha2) throws SQLException {
		String Login = login;
		String senha = senha2;
		String sql = "SELECT * FROM USUARIOS WHERE login=? AND senha=?";
		Funcionario funcionario = null;
		PreparedStatement stmt = conectarDAO().prepareStatement(sql);

		stmt.setString(1, Login);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			funcionario = new Funcionario();
			funcionario.setIdFuncionario(rs.getInt("id"));
			funcionario.setNomeFuncionario(rs.getString("nome"));
			funcionario.setSobrenomeFuncionario(rs.getString("sobrenome"));
			funcionario.setSenhaFuncionario(rs.getString("senha"));
			funcionario.setTelefoneFuncionario(rs.getInt("telefone"));
			funcionario.setAreaTrabalho(rs.getString("area_trabalho"));
			funcionario.setEndereco(rs.getString("endereco"));
			funcionario.setSalario(rs.getDouble("salario"));}
		

		rs.close();
		stmt.close();
		conectarDAO().close();

		return funcionario;
	}
}
