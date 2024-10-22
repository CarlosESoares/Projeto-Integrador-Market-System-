package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Funcionario;
import Modelo.FuncionarioDAO;
import Modelo.GenericDAO;
import visao.Login;


public class ControleDeLogin extends GenericDAO{

	
	private Login view;
    private FuncionarioDAO model;

    public ControleDeLogin() {
        this.view = new Login(this); // Usar a instância passada como argumento
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
	    String tipoFuncionario = f.getTipoFucionario();
	    if (tipoFuncionario != null) {
	        if (tipoFuncionario.equals("Caixa")) {
	            ControllerTelaCAIxa abrir = new ControllerTelaCAIxa();
	            abrir.AbrirTelaCaixa();
	        } else if (tipoFuncionario.equals("Gerente")) {
	            ControllerGerente abrir = new ControllerGerente();
	            abrir.AbrirTelaGerente();
	        } else {
	            ControllerEstoquista abrir = new ControllerEstoquista();
	            abrir.AbrirTelaEstoquista();
	        }
	        view.dispose();
	    } else {
	        JOptionPane.showMessageDialog(null, "Tipo de funcionário não definido.");
	    }
	
	}

	public void iniciar() {
		this.view.setVisible(true);
		
	}

	public ActionListener logar() {
		ActionListener ac = new ActionListener() {
			public void actionPerformed(ActionEvent e) {       
		        String cpf1 = view.ResCPF.getText(); 
		        String senha1 = new String(view.ResSenha2.getText());
		       
		        logar(cpf1, senha1 );
		}};
		return ac;
	}}
	

