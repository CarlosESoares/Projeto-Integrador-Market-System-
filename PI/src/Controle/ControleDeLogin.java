package Controle;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Funcionario;
import Modelo.FuncionarioDAO;
import Modelo.GenericDAO;
import visao.Login;

public class ControleDeLogin extends GenericDAO{

	
	private Login view;
	
	private FuncionarioDAO model;
	
	public ControleDeLogin(Login view) {
		this.view = view;
		this.model = new FuncionarioDAO();
		
			}
	
	public void logar(String cpf, String senha2 ) {
		
		String Login = cpf;
		String senha =senha2;
		Funcionario f;
		try {
			f = model.autenticar(Login,senha);
			
			if(f!= null) {
			JOptionPane.showMessageDialog(null, "Usuario pode assecar o sistema");
			ChamarTelas(f);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos ou os 2");
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
	}
	public void ChamarTelas(Funcionario f) {
		if(f.getTipoFucionario().equals("Caixa")){
			ControllerTelaCAIxa abrir = new ControllerTelaCAIxa();
			abrir.AbrirTelaCaixa();
		}else if(f.getTipoFucionario().equals("Gerente")){
			ControllerGerente abrir = new ControllerGerente();
			abrir.AbrirTelaGerente();
			
		}else {
			ControllerEstoquista abrir = new ControllerEstoquista();
			abrir.AbrirTelaEstoquista();
			
		}
	}
	}

