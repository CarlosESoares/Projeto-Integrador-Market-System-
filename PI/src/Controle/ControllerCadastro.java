package Controle;

import java.sql.SQLException;

import Modelo.CadastroFuncionarioDAO;

public class ControllerCadastro{

	public static void Controle(String NomeFuncionario, String login, String senha, String tipo_funcionario,String sobrenome, String salario,String telefone,String endereco ) throws SQLException {
		
		CadastroFuncionarioDAO f = new CadastroFuncionarioDAO();
		
		f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
	}
}
