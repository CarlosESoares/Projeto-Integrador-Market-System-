package Controle;

import javax.swing.JOptionPane;

import Modelo.FuncionarioDAO;
import visao.Login;

public class ControleDeLogin {

	
	private Login view;
	
	private FuncionarioDAO model;
	
	public ControleDeLogin(Login view) {
		this.view = view;
		this.model = new FuncionarioDAO();
		
			}
	

	public String logar(String cpf, String senha ) {
		String Login = cpf;
		String senha2 = senha;
		String perfil = model.autenticar(Login,senha);
		
		if(perfil != null) {
			JOptionPane.showMessageDialog(null, "Usuario pode assecar o sistema");
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos ou os 2");
		}
		return perfil;
		
		
	}
}
