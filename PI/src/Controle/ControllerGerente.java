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
import Modelo.ProdutoDAO;
import Modelo.VendaDAO;
import visao.Cadastro_Gerente;
import visao.MensagemView;
import visao.RelatorioVenda;
import visao.TelaCadastroCliente;
import visao.TelaDoCaixa;
import visao.TelaEstoque;
import visao.TelaGerente;
import visao.TelaResumo;
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
		tela.setLocationRelativeTo(null);

		tela.setVisible(true);
	}
	
	public void AbrirTelaEstoque(Funcionario f) {
		TelaEstoque tela2 = new TelaEstoque(f);
		tela2.setLocationRelativeTo(null);
		tela2.setVisible(true);
		
	}
	public static void TelaGerente(Funcionario f) {
		
		visao.TelaGerente abrir = new TelaGerente(f);
		abrir.setLocationRelativeTo(null);
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
	
	public void AbrirTelaCliente(Funcionario f){
		TelaCadastroCliente Tela = new TelaCadastroCliente(f);
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
				new MensagemView("O campo CPF não pode estar vazio.",1);
			} else if (loginStr.length() != 11) {
				new MensagemView("O CPF deve conter 11 dígitos.",1);
				return;
			} else if (login2) {
				new MensagemView("O CPF deve conter apenas números.",1);
				return;
			}
			
			if (NomeFuncionario.isEmpty()) {
				new MensagemView("O campo Nome não pode estar vazio.",1);
				return;
			}
			
			if (senha.isEmpty()) {
				new MensagemView("O campo senha não pode estar vazio.",1);
				return;
			}
			
			if (sobrenome.isEmpty()) {
				new MensagemView("O campo sobrenome não pode estar vazio.",1);
				return;
			}
			
			if (telefoneStr.isEmpty()) {
				new MensagemView("O campo telefone não pode estar vazio.",1);
				return;
			} else if (telefoneStr.length() != 9) {
				new MensagemView("O telefone deve conter 9 dígitos.",1);
				return;
			} else if (telefone2) {
				new MensagemView("O Telefone deve conter apenas números.",1);
				return;
			}
			
			if (endereco.isEmpty()) {
				new MensagemView("O campo endereço não pode estar vazio.",1);
				return;
			}
			
			if (salarioStr.isEmpty()) {
				new MensagemView("O campo salário não pode estar vazio.",1);
				return;
			} else if (salario2) {
				new MensagemView("O Salário deve conter apenas números.",1);
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
				new MensagemView("Precisa escolher uma das opções",1);
				return;
			}

			// Conversão dos campos para tipos adequados
			long login = Long.parseLong(loginStr);
			int telefone = Integer.parseInt(telefoneStr);
			double salario = Double.parseDouble(salarioStr);
			
			// Cadastro no banco de dados
			FuncionarioDAO f = new FuncionarioDAO();
			f.cadastroFuncionario(NomeFuncionario, login, senha, tipo_funcionario, sobrenome, salario, telefone, endereco);
			
			new MensagemView("Cadastrado com sucesso", 1);
			
			} catch (NumberFormatException e1) {
				// Captura de exceções de conversão numérica
				new MensagemView("Erro ao validar os dados numéricos. Verifique os campos.",1);
				e1.printStackTrace();
			} catch (SQLException e2) {
				// Captura de exceções de banco de dados
				new MensagemView("Erro ao enviar as informações para o banco de dados.",1);
				e2.printStackTrace();
			} catch (Exception e3) {
				// Captura de exceções gerais
				new MensagemView("Erro inesperado: " + e3.getMessage());
				e3.printStackTrace();
			}
			BuscarF(Cadastro_Gerente.table);
			
		}
	
	public static void BuscarF(JTable table) {
		try {
            List<Object[]> Funcionario = FuncionarioDAO.buscarFuncionario();
            DefaultTableModel model = (DefaultTableModel) Cadastro_Gerente.table.getModel();
            model.setRowCount(0);  
            for (Object[] Funcionarios : Funcionario) {
                model.addRow(Funcionarios); 
            }
        } catch (SQLException e) {
        	new MensagemView("Erro ao buscar Funcionario.", 1);
            e.printStackTrace();
        }
	}
	
	public static void BuscarFR(JTable table) {
		try {
            List<Object[]> Funcionario = FuncionarioDAO.buscarFuncionarioR();
            DefaultTableModel model = (DefaultTableModel) TelaResumo.tableFuncionario.getModel();
            model.setRowCount(0);  
            for (Object[] Funcionarios : Funcionario) {
                model.addRow(Funcionarios); 
            }
        } catch (SQLException e) {
        	new MensagemView("Erro ao buscar Funcionario.", 1);

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
		BuscarF(Cadastro_Gerente.table);
	}
	
	 public static void editar(JTable table, int id, JTextField tfNome, JTextField tfSobrenome, JTextField tfSalario, JTextField tfTelefone, JTextField tfEndereco) {
	        int selectedRow = table.getSelectedRow();
	        
	        if (selectedRow != -1) {
	            id = Integer.parseInt(Cadastro_Gerente.table.getValueAt(selectedRow, 0).toString());
	            String nome = tfNome.getText();
        	    String sobrenome = tfSobrenome.getText();
        	    double salario = Double.parseDouble(tfSalario.getText());
        	    int telefone = Integer.parseInt(tfTelefone.getText());
        	    String endereco = tfEndereco.getText();
	            boolean success = FuncionarioDAO.atualizarFuncionario(id, nome, sobrenome, salario, telefone, endereco);
	          
	            if (success) {
	            	Cadastro_Gerente.table.setValueAt(nome, selectedRow, 1);
	            	Cadastro_Gerente.table.setValueAt(sobrenome, selectedRow, 2);
	            	Cadastro_Gerente.table.setValueAt(salario, selectedRow, 3);
	            	Cadastro_Gerente.table.setValueAt(telefone, selectedRow, 4);
	            	Cadastro_Gerente.table.setValueAt(endereco, selectedRow, 5);
	            	new MensagemView("Funcionario atualizado com sucesso!", 1);
	                
	                
	                BuscarF(Cadastro_Gerente.table);  
	                limparCamposFuncionario(tfNome, tfSobrenome, tfSalario, tfTelefone, tfEndereco);
	            } else {
	            	new MensagemView("Erro ao atualizar o Funcionario.", 1);
	               
	            }
	        }
	      
	    }
	 
	 public static void limparCamposFuncionario( JTextField Nome, JTextField tfSobrenome, JTextField tfSalario, JTextField tfTelefone, JTextField tfEndereco) {
		    // Limpa os campos de texto
		    Nome.setText("");
		    tfSobrenome.setText("");
		    tfSalario.setText("");
		    tfTelefone.setText("");
		    tfEndereco.setText("");
		}
	
	
	public static  void tipo(Funcionario f) {
		System.out.println(f.tipoFucionario);
		
		if (f.tipoFucionario.equals("Gerente")) {
			TelaGerente(f);		}else {
				AbrirTelaInicial(f);
			}
				
		
		
	}
	

    public void excluirCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF, JTextField textLimite) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow != -1) {
            int idcliente = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            
            MensagemView mv = new MensagemView("Tem certeza que deseja excluir o cliente selecionado?");
    		int confirmacao = mv.getResposta();
           
    		if (confirmacao == 1) {
  
                try {
                    boolean sucesso = ClienteDAO.excluircliente(idcliente);
                    if (sucesso) {
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        new MensagemView("Cliente excluído com sucesso!", 1);
                        
                        limparCampos(TextNome, TextSobrenome, TextCPF, textLimite);
                    } else {
                    	new MensagemView("Falha ao excluir o cliente.", 1);
                        
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    new MensagemView("Erro ao excluir o cliente."+ ex.getMessage(), 1);
           
                }
            }
        } else {
        	new MensagemView("Selecione um cliente para excluir.", 1);
     
        }
    }

    public void editarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF, JTextField textLimite) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow != -1) {
            int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            String nome = TextNome.getText();
            String sobrenome = TextSobrenome.getText();
            String CPF = TextCPF.getText();
            String Limite = textLimite.getText();

            boolean success = ClienteDAO.atualizarcliente(id, nome, sobrenome, CPF, Limite);

            if (success) {
                table.setValueAt(nome, selectedRow, 1);
                table.setValueAt(sobrenome, selectedRow, 2);
                table.setValueAt(CPF, selectedRow, 3);
                table.setValueAt(Limite, selectedRow, 4);
        
                new MensagemView("Cliente atualizado com sucesso!", 1);
                buscarClientes(table);  
                limparCampos(TextNome, TextSobrenome, TextCPF, textLimite);
            } else {
            	new MensagemView("Erro ao atualizar o cliente.", 1);

            }
        } else {
        	new MensagemView("Selecione uma linha para editar.", 1);

        }
    }



    
    public void cadastrarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF, JTextField textLimite) {
        String nome = TextNome.getText();
        String sobrenome = TextSobrenome.getText();
        String CPF = TextCPF.getText();
        String CPF1 = CPF;
        String Limite = textLimite.getText();
        boolean hasLetter = CPF1.chars().anyMatch(ch -> !Character.isDigit(ch));
        
        if (nome.trim().isEmpty()) {
            new MensagemView("Preencha o campo Nome", 1);
            return;
        }
        if (sobrenome.trim().isEmpty()) {
            new MensagemView("Preencha o campo Sobrenome", 0);
            return;
        }
        if (CPF.trim().isEmpty()) {
            new MensagemView("Preencha o campo CPF", 1);
            return;
        }
        if (CPF1.length() != 11) {
            new MensagemView("O CPF deve conter 11 dígitos.", 1);
            return;
        }
        if (hasLetter) {
            new MensagemView("O CPF deve conter apenas números.", 1);
            return;
        }


        try {
            ClienteDAO.cadastrarCliente(nome, sobrenome, CPF, Limite);
            new MensagemView("Cliente cadastrado com sucesso!", 1);
            

            limparCampos(TextNome, TextSobrenome, TextCPF, textLimite );
            buscarClientes(table);
        } catch (SQLException ex) {
        	new MensagemView("Erro ao cadastrar o cliente.", 1);

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
        	new MensagemView("Erro ao buscar clientes.", 1);

            e.printStackTrace();
        }
    }
    public void limparCampos(JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF,JTextField TextLimite ) {
        TextNome.setText("");
        TextSobrenome.setText("");
        TextCPF.setText("");
        TextLimite.setText("");
    }
    public static void excluirProduto(JTable table, ProdutoDAO produtoDAO) {
        if (produtoDAO == null) {
        	new MensagemView("Não foi possível encontrar o DAO do produto.", 1);
     
            return;
        }

        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int idProduto = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            MensagemView mv = new MensagemView("Tem certeza que deseja excluir o produto?");
    		int confirmacao = mv.getResposta();
           
    		if (confirmacao == 1) {
                try {
                    boolean sucesso = produtoDAO.excluirProduto(idProduto);
                    if (sucesso) {
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        new MensagemView("Produto excluído com sucesso!", 1);
                        
                    } else {
                    	new MensagemView("Falha ao excluir o produto.", 1);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    new MensagemView("Falha ao excluir o produto." + ex.getMessage(), 1);
                }
            }
        } else {
        	new MensagemView("Selecione um produto para excluir", 1);
        }
    }
    public static void editarProduto(JTable table, ProdutoDAO produtoDAO, JTextField TextNome, JTextField TextTipo, JTextField TextChegada, JTextField TextValidade, JTextField TextPreco, JTextField TextQntd) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            String nome = TextNome.getText();
            String tipo = TextTipo.getText();
            String chegada = TextChegada.getText();
            String validade = TextValidade.getText();
            double preco = Double.parseDouble(TextPreco.getText());
            int quantidade = Integer.parseInt(TextQntd.getText());

            boolean success = produtoDAO.atualizarProduto(id, nome, tipo, chegada, validade, preco, quantidade);

            if (success) {
            	new MensagemView("Produto atualizado com sucesso!", 1);
       
                buscarProdutos(table);

                TextNome.setText("");
                TextTipo.setText("");
                TextChegada.setText("");
                TextValidade.setText("");
                TextPreco.setText("");
                TextQntd.setText("");
            } else {
            	new MensagemView("Erro ao atualizar o produto.", 1);
            }
        } else {
        	new MensagemView("Selecione uma linha para editar.", 1);
        }
    }

    public static void buscarProdutos(JTable table) {
        try {
            List<Object[]> produtos = ProdutoDAO.buscarTodosProdutos();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  
            for (Object[] produto : produtos) {
                model.addRow(produto); 
            }
        } catch (SQLException e) {
        	new MensagemView("Erro ao buscar produtos.", 1);
     
            e.printStackTrace();
        }
    }
    public static void cadastrarProduto(JTable table, ProdutoDAO produtoDAO, JTextField TextNome, JTextField TextTipo, JTextField TextChegada, JTextField TextValidade, JTextField TextPreco, JTextField TextQntd) {
        String validade1 = TextValidade.getText();
        String dataChegada1 = TextChegada.getText();
        String qntd1 = TextQntd.getText();
        boolean hasLetter = qntd1.chars().anyMatch(ch -> !Character.isDigit(ch));
        String preco1 = TextPreco.getText();
        boolean hasLetter1 = preco1.chars().anyMatch(ch -> !Character.isDigit(ch) && ch != '.' && ch != ',');
        boolean hasLetter2 = dataChegada1.chars().anyMatch(ch -> !Character.isDigit(ch) && ch != '/');
        boolean hasLetter3 = validade1.chars().anyMatch(ch -> !Character.isDigit(ch) && ch != '/');

        if (TextNome.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo produto", 1);
        }  if (TextTipo.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo tipo do produto", 1);
        }  if (TextChegada.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo data de chegada", 1);
        }  if (hasLetter2) {
            new MensagemView("O campo data de chegada deve conter apenas datas.", 1);
        }  if (TextPreco.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo preço", 1);
        }  if (hasLetter1) {
            new MensagemView("O campo preço deve conter apenas números.", 1);
        }  if (TextValidade.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo validade", 1);
        }  if (hasLetter3) {
            new MensagemView("O campo data de validade deve conter apenas datas.", 1);
        }  if (TextQntd.getText().trim().isEmpty()) {
            new MensagemView("Preencha o campo quantidade", 1);
        }  if (hasLetter) {
            new MensagemView("O campo quantidade deve conter apenas números.", 1);
        } else {
            String nome = TextNome.getText();
            String tipo = TextTipo.getText();
            String dataChegada = TextChegada.getText();
            String preco = TextPreco.getText();
            String validade = TextValidade.getText();
            String qntd = TextQntd.getText();

            try {
                produtoDAO.cadastrarProduto(nome, tipo, dataChegada, preco, validade, qntd);
                new MensagemView("Produto cadastrado com sucesso!", 1);
            
                buscarProdutos(table); 

                TextNome.setText("");
                TextTipo.setText("");
                TextChegada.setText("");
                TextPreco.setText("");
                TextValidade.setText("");
                TextQntd.setText("");
            } catch (SQLException ex) {
            	new MensagemView("Erro ao cadastrar o produto.", 1);
   
                ex.printStackTrace();
            }
        }
    }
    public static void PreencherTabela(JTable table, JTextField TextNome, JTextField TextTipo, JTextField TextChegada, JTextField TextPreco, JTextField TextValidade, JTextField TextQntd) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            TextNome.setText(table.getValueAt(selectedRow, 1).toString());
            TextTipo.setText(table.getValueAt(selectedRow, 2).toString());
            TextChegada.setText(table.getValueAt(selectedRow, 3).toString());
            TextPreco.setText(table.getValueAt(selectedRow, 4).toString());
            TextValidade.setText(table.getValueAt(selectedRow, 5).toString());
            TextQntd.setText(table.getValueAt(selectedRow, 6).toString());
        }
    }
	public void abrirTelaResumo() {
		TelaResumo abrir = new TelaResumo();
		abrir.setVisible(true);
		
	}
	public static void buscarProdutoPeloIdCaixa(String idProduto, String quantidadeText,JTable tabela) {
			String idProduto2 = idProduto;
			String Quantidade = quantidadeText;
			
			VendaDAO.BuscarProdutoIDCaixa(idProduto2,Quantidade,tabela);
	}
}



