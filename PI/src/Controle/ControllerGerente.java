package Controle;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.FuncionarioDAO;
import visao.Cadastro_Gerente;
import visao.TextFielArredondada;
import visao.telaInicial;

public class ControllerGerente {

	public void TelaInicial() {

		telaInicial tela = new telaInicial();
		
		tela.setVisible(true);
		
	}
	public void AbrirTelaFunfionario() {
		//Abrindo tela do funcionario
		Cadastro_Gerente tela = new Cadastro_Gerente();
		tela.setVisible(true);
		
	}
	public void TelaCadastro() {
		//abrindo tela do Cadastro
		Cadastro_Gerente abrir = new Cadastro_Gerente();
		abrir.setVisible(true);
	}
	public static void Cadastro(TextFielArredondada textNome, TextFielArredondada textSobrenome, TextFielArredondada textTelefone, TextFielArredondada textCpf, TextFielArredondada textSenha, int op, TextFielArredondada textSalario, TextFielArredondada textEndereço) throws SQLException {
        try {
        	
        	String NomeFuncionario = textNome.getText();
            String loginStr = textCpf.getText();
            String senha = textSenha.getText();
            String sobrenome = textSobrenome.getText();
            String telefoneStr = textTelefone.getText();
            String salarioStr = textSalario.getText();
            String endereco = textEndereço.getText();
            String tipo_funcionario = null;
            
            
        	boolean login2 = loginStr.chars().anyMatch(ch -> !Character.isDigit(ch));
            boolean telefone2 = telefoneStr.chars().anyMatch(ch -> !Character.isDigit(ch));
            boolean salario2 = salarioStr.chars().anyMatch(ch -> !Character.isDigit(ch));
            

            // Validação dos campos
            if (loginStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (loginStr.length() != 11) {
                JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (login2) {
                JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (NomeFuncionario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo senha não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (sobrenome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo sobrenome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if (telefone2) {
                JOptionPane.showMessageDialog(null, "O Telefone deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (telefoneStr.length() != 9) {
                JOptionPane.showMessageDialog(null, "O telefone deve conter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if (telefoneStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo telefone não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (endereco.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo endereço não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if (salarioStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo salario não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else if (salario2) {
                JOptionPane.showMessageDialog(null, "O Salaeio deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if(op == 1) {
            	tipo_funcionario = "Caixa";
            }else if(op == 2){
            	tipo_funcionario = "Gerente";
            }else if (op == 3) {
            	tipo_funcionario = "Estoquista";
            }else if (op == 0){
            	tipo_funcionario = null;
            	JOptionPane.showMessageDialog(null, "Precisa escolher uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            long login = Long.parseLong(loginStr);
            int telefone = Integer.parseInt(telefoneStr);
            double salario = Double.parseDouble(salarioStr);
            
            FuncionarioDAO f = new FuncionarioDAO();
    		f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
                
                }
         catch (NumberFormatException e1) {
        	e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Validar.", "Erro", JOptionPane.ERROR_MESSAGE);
         } 
	}
}
