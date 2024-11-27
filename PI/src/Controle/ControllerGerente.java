package Controle;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.ClienteDAO;
import Modelo.Funcionario;
import Modelo.FuncionarioDAO;
import Modelo.VendaDAO;
import visao.Cadastro_Gerente;
import visao.RelatorioVenda;
import visao.TelaCadastroCliente;
import visao.TelaDoCaixa;
import visao.TelaEstoque;
import visao.TelaGerente;
import visao.TelaVendas;
import visao.TextFielArredondada;
import visao.telaInicial;

public class ControllerGerente {
	public   boolean telefone2;
	public boolean salario2;

	
	public void TelaInicial() {

		telaInicial tela = new telaInicial(null);
		
		tela.setVisible(true);
		
	}
	public static void TelaCadastro(Funcionario f) {
		Cadastro_Gerente tela = new Cadastro_Gerente(f);
		tela.setVisible(true);
	}
	
	public void AbrirTelaEstoque(Funcionario f) {
		TelaEstoque tela2 = new TelaEstoque();
		tela2.setLocationRelativeTo(null);
		tela2.setVisible(true);
		
	}
	public static void TelaGerente(Funcionario f) {
		
		visao.TelaGerente abrir = new TelaGerente(f);
		abrir.setVisible(true);
		
		
	}
	public static void AbrirTelaInicial(Funcionario f) {
		telaInicial Tela = new telaInicial(f);
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
	
	public void AbrirTelaCaixa(Funcionario f){

		TelaDoCaixa tela = new TelaDoCaixa(f);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	
	}
	
	public void AbrirTelaCliente(){
		TelaCadastroCliente Tela = new TelaCadastroCliente(null);
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
	}

	public void AbrirTelaEstoque() {
		TelaEstoque Tela = new TelaEstoque();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial(null);
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
	
VendaDAO dao = new VendaDAO();
	
	public void AbrirTelaVendas(){

		TelaVendas tela = new TelaVendas(null);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	
		
	}
	public void Relatorio(){
		RelatorioVenda abrir = new RelatorioVenda();
		abrir.setLocationRelativeTo(null);
		abrir.setVisible(true);
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
			String tipo_funcionario ="" ;

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
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Erro", JOptionPane.ERROR_MESSAGE);
			
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
			BuscarF();
		}
	
	public static void BuscarF() {
		try {
			FuncionarioDAO.buscarFuncionario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		try {
			FuncionarioDAO.excluirFuncionario(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BuscarF();
	}
	
	public static void editar(int id,String NomeFuncionario,String sobrenome, double salario, int telefone, String endereco) {
		FuncionarioDAO.atualizarFuncionario(id, NomeFuncionario, sobrenome, salario, telefone, endereco);
	}
	
	
	
	public static  void tipo(Funcionario f) {
		System.out.println(f.tipoFucionario);
		
		if (f.tipoFucionario.equals("Gerente")) {
			TelaGerente(f);		}else {
				AbrirTelaInicial(f);
			}
				
		
		
	}
	

    public void excluirCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow != -1) {
            int idcliente = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    boolean sucesso = ClienteDAO.excluircliente(idcliente);
                    if (sucesso) {
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                        limparCampos(TextNome, TextSobrenome, TextCPF);
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao excluir o cliente.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
        }
    }

    public void editarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow != -1) {
            int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            String nome = TextNome.getText();
            String sobrenome = TextSobrenome.getText();
            String CPF = TextCPF.getText();

            boolean success = ClienteDAO.atualizarcliente(id, nome, sobrenome, CPF);

            if (success) {
                table.setValueAt(nome, selectedRow, 1);
                table.setValueAt(sobrenome, selectedRow, 2);
                table.setValueAt(CPF, selectedRow, 3);
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                buscarClientes(table);  
                limparCampos(TextNome, TextSobrenome, TextCPF);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
        }
    }



    
    public void cadastrarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        String nome = TextNome.getText();
        String sobrenome = TextSobrenome.getText();
        String CPF = TextCPF.getText();
        String CPF1 = CPF;
        boolean hasLetter = CPF1.chars().anyMatch(ch -> !Character.isDigit(ch));
        
        if (nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sobrenome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Sobrenome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (CPF.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CPF", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (CPF1.length() != 11) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hasLetter) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        try {
            ClienteDAO.cadastrarCliente(nome, sobrenome, CPF);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            

            limparCampos(TextNome, TextSobrenome, TextCPF);
            buscarClientes(table);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente.");
            ex.printStackTrace();
        }
    }

    public void buscarClientes(JTable table) {
        try {
            List<Object[]> clientes = ClienteDAO.buscarTodosClientes();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  
            for (Object[] cliente : clientes) {
                model.addRow(cliente); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes.");
            e.printStackTrace();
        }
    }
    public void limparCampos(JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        TextNome.setText("");
        TextSobrenome.setText("");
        TextCPF.setText("");
    }
    
}
