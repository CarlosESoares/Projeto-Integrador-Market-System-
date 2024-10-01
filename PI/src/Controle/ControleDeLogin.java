package Controle;

import javax.swing.JOptionPane;

import Modelo.FuncionarioDAO;
import Modelo.TextFielArredondada;
import visao.Login;

public class ControleDeLogin {

	
	private Login view;
	
	private FuncionarioDAO model;
	
	public ControleDeLogin(Login view) {
		this.view = view;
		this.model = new FuncionarioDAO();
		
			}
	

	public void logar(TextFielArredondada resCPF, TextFielArredondada ResSenha2) {
		String Login = view.resCPF.getText();
		String senha = new  String(view.ResSenha2.getText());
		String perfil = model.autenticar(Login,senha);
		
		if(perfil != null) {
			JOptionPane.showMessageDialog(null, "Usuario pode assecar o sistema");
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos ou os 2");
		}
		
	}
}
