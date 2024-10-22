package Controle;

import java.sql.SQLException;

import Modelo.CadastroFuncionarioDAO;

public class ControllerCadastro{

	public static void Controle(String login, String senha, String tipo_funcionario ) throws SQLException {
		
		System.out.println("ERRO 1");
		CadastroFuncionarioDAO.cadastroFuncionario(login, senha, tipo_funcionario);
	}
}
