package Controle;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.FuncionarioDAO;
import visao.Cadastro_Gerente;
import visao.TelaGerente;
import visao.TelaVendas;
import visao.TextFielArredondada;
import visao.telaInicial;

public class ControllerGerente {
	public   boolean telefone2;
	public boolean salario2;

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
	public void TelaGerente() {
		
		visao.TelaGerente abrir = new TelaGerente();
		abrir.setVisible(true);
		TelaVendas fechar = new TelaVendas();
		fechar.dispose();
	}

	
	public static void Cadastro(TextFielArredondada textNome, TextFielArredondada textSobrenome, 
            TextFielArredondada textTelefone, TextFielArredondada textCpf, 
            TextFielArredondada textSenha, int op, 
            TextFielArredondada textSalario, TextFielArredondada textEndereço) throws SQLException {
		try {
			// Coletando os dados dos campos
			String NomeFuncionario = textNome.getText();
			String loginStr = textCpf.getText();
			String senha = textSenha.getText();
			String sobrenome = textSobrenome.getText();
			String telefoneStr = textTelefone.getText();
			String salarioStr = textSalario.getText();
			String endereco = textEndereço.getText();
			String tipo_funcionario = null;

			// Declaração das variáveis de validação
			boolean login2 = loginStr.chars().anyMatch(ch -> !Character.isDigit(ch));
			boolean telefone2 = telefoneStr.chars().anyMatch(ch -> !Character.isDigit(ch));
			boolean salario2 = salarioStr.chars().anyMatch(ch -> !Character.isDigit(ch));
			
			// Validação dos campos
			if (loginStr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (loginStr.length() != 11) {
				JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (login2) {
				JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (NomeFuncionario.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (senha.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo senha não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (sobrenome.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo sobrenome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (telefoneStr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo telefone não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (telefoneStr.length() != 9) {
				JOptionPane.showMessageDialog(null, "O telefone deve conter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (telefone2) {
				JOptionPane.showMessageDialog(null, "O Telefone deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (endereco.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo endereço não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (salarioStr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo salário não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (salario2) {
				JOptionPane.showMessageDialog(null, "O Salário deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Definir o tipo de funcionário com base na opção 'op'
			if (op == 1) {
				tipo_funcionario = "Caixa";
			} else if (op == 2) {
				tipo_funcionario = "Gerente";
			} else if (op == 3) {
				tipo_funcionario = "Estoquista";
			} else if (op == 0) {
				JOptionPane.showMessageDialog(null, "Precisa escolher uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Conversão dos campos para tipos adequados
			long login = Long.parseLong(loginStr);
			int telefone = Integer.parseInt(telefoneStr);
			double salario = Double.parseDouble(salarioStr);
			
			// Cadastro no banco de dados
			FuncionarioDAO f = new FuncionarioDAO();
			f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario, sobrenome, salario, telefone, endereco);
			
			} catch (NumberFormatException e1) {
				// Captura de exceções de conversão numérica
				JOptionPane.showMessageDialog(null, "Erro ao validar os dados numéricos. Verifique os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (SQLException e2) {
				// Captura de exceções de banco de dados
				JOptionPane.showMessageDialog(null, "Erro ao enviar as informações para o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			} catch (Exception e3) {
				// Captura de exceções gerais
				JOptionPane.showMessageDialog(null, "Erro inesperado: " + e3.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				e3.printStackTrace();
			}
		}
	
	public static void BuscarF() {
		try {
            List<Object[]> Funcionario = FuncionarioDAO.buscarFuncionario();
            DefaultTableModel model = (DefaultTableModel) Cadastro_Gerente.table.getModel();
            model.setRowCount(0);  
            for (Object[] Funcionarios : Funcionario) {
                model.addRow(Funcionarios); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Funcionaio.");
            e.printStackTrace();
        }
		
		
    }
	
	
	public static void excluir(int id) {
		
		BuscarF();
		
		try {
			FuncionarioDAO.excluirFuncionario(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Tabela(int id, String nomeFuncionario, String sobrenome, int telefone, double salario,
			String endereco) {
		
		BuscarF();
		int NomeFuncionario = Integer.parseInt(nomeFuncionario);
		int Sobrenome = Integer.parseInt(sobrenome);
		int Endereco = Integer.parseInt(endereco);
		
		
		id = Integer.parseInt(Cadastro_Gerente.table.getValueAt(id,1).toString());
    	NomeFuncionario = Integer.parseInt(Cadastro_Gerente.table.getValueAt(NomeFuncionario, 2).toString());
        Sobrenome = Integer.parseInt(Cadastro_Gerente.table.getValueAt(Sobrenome, 3).toString());
        telefone = Integer.parseInt(Cadastro_Gerente.table.getValueAt(telefone, 4).toString());
        salario = Integer.parseInt(Cadastro_Gerente.table.getValueAt((int) salario, 5).toString());
        Endereco = Integer.parseInt(Cadastro_Gerente.table.getValueAt(Endereco, 6).toString());
		
	}
	
	public void editar(int id,String NomeFuncionario, long login, String senha, String tipo_funcionario,String sobrenome, double salario,int telefone,String endereco) {
		FuncionarioDAO.atualizarFuncionario(id, NomeFuncionario, login, senha, tipo_funcionario, sobrenome, salario, telefone, endereco);
	}
}
