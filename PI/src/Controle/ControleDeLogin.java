package Controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Funcionario;
import Modelo.FuncionarioDAO;
import visao.Login;
import visao.MensagemView;


public class ControleDeLogin  {

	
	private Login view;
    private Funcionario f;
    public ControleDeLogin() {
        this.view = new Login(this); // Usar a instância passada como argumento
        new FuncionarioDAO();
    }
	
	public void logar(String cpf, String senha2 ) {
		
		String Login = cpf;
		String senha =senha2;
		
		try {
			f = FuncionarioDAO.autenticar(Login,senha);
			
			if(f!= null) {
			new MensagemView("Usuario pode acessar o sistema",0);
			ChamarTelas(f);
		}else {
			new MensagemView( "Usuario ou senha invalidos ",0);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	public void ChamarTelas(Funcionario f) {
	    String tipoFuncionario = f.getTipoFucionario();
	    
	    System.out.println(f.getNomeFuncionario());
//	    ControllerGerente.tipo(f);
	    
	    
	    if (tipoFuncionario != null) {
	        if (tipoFuncionario.equals("Caixa")) {
	        	ControllerGerente abrir = new ControllerGerente ();
	            abrir.AbrirTelaCaixa(f);
	        } else if (tipoFuncionario.equals("Gerente")) {
	            ControllerGerente.TelaGerente(f);
	        } else {
	        	ControllerGerente abrir = new ControllerGerente();
	            abrir.AbrirTelaEstoque(f);
	        }
	        view.dispose();
	    } else {
	      new MensagemView( "Tipo de funcionário não definido.");
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
	

