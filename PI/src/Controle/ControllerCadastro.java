package Controle;

import java.sql.SQLException;

import Modelo.FuncionarioDAO;

public class ControllerCadastro{

	public static void Controle(String NomeFuncionario, int login, String senha, String tipo_funcionario,String sobrenome, double salario,int telefone,String endereco ) throws SQLException {
		
		FuncionarioDAO f = new FuncionarioDAO();
		
		f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
	}
}
