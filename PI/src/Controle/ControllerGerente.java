package Controle;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.FuncionarioDAO;
import visao.Cadastro_Gerente;
import visao.TelaGerente;
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
	public void TelaGerent() {
		//Abrindo tela do gerente
		TelaGerente abrir = new TelaGerente();
		abrir.setVisible(true);
		Cadastro_Gerente fechar = new Cadastro_Gerente();
		fechar.setVisible(false);
	}
	

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
            	try {
            		long login = Long.parseLong(loginStr);
                    int telefone = Integer.parseInt(telefoneStr);
                    double salario = Double.parseDouble(salarioStr);
                    
                    FuncionarioDAO f = new FuncionarioDAO();
            		f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao enviar as informações cadastradas.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
                
                
        }
         catch (NumberFormatException e1) {
        	e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Validar.", "Erro", JOptionPane.ERROR_MESSAGE);
         } 
	}
	public static void BuscarF() {
		 try {
				FuncionarioDAO.buscarFuncionario();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
