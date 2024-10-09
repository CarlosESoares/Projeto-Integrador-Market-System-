package Controle;

import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	
	public String logar(String cpf, String senha2 ) {
		
		String Login = cpf;
		String senha =senha2;
		String perfil;
		try {
			perfil = model.autenticar(Login,senha);
			
			if(perfil != null) {
			JOptionPane.showMessageDialog(null, "Usuario pode assecar o sistema");
			return perfil;
		}else {
			JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos ou os 2");
			return perfil = null;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	public String ChamarTelas(String perfil) {
		if(perfil.equals("Caixa")){
			ControllerTelaCAIxa abrir = new ControllerTelaCAIxa();
			abrir.AbrirTelaCaixa();
		}else if(perfil.equals("Gerente")){
			ControllerGerente abrir = new ControllerGerente();
			abrir.AbrirTelaGerente();
			
		}else {
			ControllerEstoquista abrir = new ControllerEstoquista();
			abrir.AbrirTelaEstoquista;
			
		}
	}
	}

