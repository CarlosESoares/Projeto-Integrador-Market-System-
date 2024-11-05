package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControleDeLogin;
import Controle.ControllerCadastro;
import Controle.ControllerEstoquista;
import Controle.ControllerTelaCliente;
import Controle.ControllerTelaVendas;
import Modelo.CadastroFuncionarioDAO;

public class Cadastro_Gerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String tipo_funcionario;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Gerente frame = new Cadastro_Gerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro_Gerente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1200, 200, Image.SCALE_SMOOTH); // Redimensione a imagem
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		
		RoundedButton btnProduto = new RoundedButton("Produto", 30, 30);
		btnProduto.setForeground(new Color(255, 255, 255));
		btnProduto.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnProduto.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnProduto.setBackground(Color.RED);
		    }
		});
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerEstoquista abrir = new ControllerEstoquista();
				abrir.AbrirTelaEstoquista();
				dispose();
		
			}
		});
		btnProduto.setText("Produtos");
		btnProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		btnProduto.setBackground(Color.RED);
		
		RoundedButton btnCliente = new RoundedButton("Cliente", 30, 30);
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnCliente.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnCliente.setBackground(Color.RED);
		    }
		});
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTelaCliente abrir = new ControllerTelaCliente();
				abrir.AbrirTelaCliente();
				dispose();
		
			}
		});
		btnCliente.setText("Clientes");
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCliente.setBackground(Color.RED);
		
		RoundedButton btnVendas = new RoundedButton("Vendas", 30, 30);
		btnVendas.setForeground(new Color(255, 255, 255));
		btnVendas.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	btnVendas.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	btnVendas.setBackground(Color.RED);
		    }
		});
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTelaVendas abrir = new ControllerTelaVendas();
				abrir.AbrirTelaVendas();
				dispose();
		
			}
		});
		btnVendas.setText("Vendas");
		btnVendas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVendas.setBackground(Color.RED);
		
		RoundedButton imgLogo = new RoundedButton("",1,1);
		imgLogo.setBackground(new Color(192, 192, 192));
		panel_1.add(imgLogo, "cell 0 0");
		imgLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTelaCliente abrir = new ControllerTelaCliente();
				abrir.AbrirTelaInicial();
				dispose();
			}
		});
		imgLogo.setIcon(ImgRedimencionada);
		
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnProduto, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVendas, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnProduto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVendas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(276, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro Funcionário");
		lblNewLabel_1.setBounds(299, 7, 187, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 43, 106, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(97, 41, 187, 24);
		TextNome.setColumns(10);
		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 163, 30, 18);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf = new TextFielArredondada(15,20,20);
		TextCpf.setBounds(97, 161, 187, 24);
		TextCpf.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 209, 42, 18);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha = new TextFielArredondada(15,20,20);
		TextSenha.setBounds(97, 207, 187, 24);
		TextSenha.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Função");
		lblFuncao.setBounds(10, 248, 49, 18);
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSobrenome = new TextFielArredondada(15, 20, 20);
		TextSobrenome.setColumns(10);
		TextSobrenome.setBounds(97, 83, 187, 24);
		panel_2.add(TextSobrenome);
		
		TextFielArredondada TextTelefone = new TextFielArredondada(15, 20, 20);
		TextTelefone.setColumns(10);
		TextTelefone.setBounds(97, 118, 187, 24);
		panel_2.add(TextTelefone);
		
		TextFielArredondada TextSalario = new TextFielArredondada(15, 20, 20);
		TextSalario.setColumns(10);
		TextSalario.setBounds(97, 279, 187, 24);
		panel_2.add(TextSalario);
		
		TextFielArredondada TextEndereço = new TextFielArredondada(15, 20, 20);
		TextEndereço.setColumns(10);
		TextEndereço.setBounds(97, 322, 187, 24);
		panel_2.add(TextEndereço);
		
		JComboBox<Object> comboFuncao = new JComboBox<Object>();
		comboFuncao.setBounds(97, 248, 187, 20);
		comboFuncao.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecionar", "Caixa", "Gerente", "Estoquista"}));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.setForeground(new Color(255, 255, 255));
		Cadastrar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	Cadastrar.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	Cadastrar.setBackground(Color.RED);
		    }
		});
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeFuncionario = TextNome.getText();
				String loginStr = TextCpf.getText();
				String senha = TextSenha.getText();
				String sobrenome = TextSobrenome.getText();
				String telefoneStr = TextTelefone.getText();
				String salarioStr = TextSalario.getText();
				String endereco = TextEndereço.getText();
				int op = comboFuncao.getSelectedIndex();

				try {
				    // Convert Strings to numbers
				    int login = Integer.parseInt(loginStr);
				    int telefone = Integer.parseInt(telefoneStr);
				    double salario = Double.parseDouble(salarioStr);

				    // Validation checks
				    if (loginStr.isEmpty() || loginStr.length() != 11) {
				        JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (NomeFuncionario.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "O campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (senha.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "O campo senha não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (sobrenome.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "O campo sobrenome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (telefoneStr.isEmpty() || telefoneStr.length() != 9) {
				        JOptionPane.showMessageDialog(null, "O telefone deve conter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (endereco.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "O campo endereço não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else if (salarioStr.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "O campo salario não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				    } else {
		            	try {
							ControllerCadastro.Controle(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
							System.out.println("Cadastrado"); 
							JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso", null, JOptionPane.PLAIN_MESSAGE);
							
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro ao Cadastra.", "Erro", JOptionPane.ERROR_MESSAGE);
						} 
				    }

				} catch (NumberFormatException e1) {
				    JOptionPane.showMessageDialog(null, "Erro ao converter número. Verifique os campos CPF, telefone e salario.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
	            //Validação do comboBox
                	if(op == 1) {
                		tipo_funcionario = "Caixa";
                	}else if(op == 2){
                		tipo_funcionario = "Gerente";
                	}else if (op == 2) {
                		tipo_funcionario = "Esqoquista";
                	}else {
                		tipo_funcionario = null;
                		JOptionPane.showMessageDialog(null, "Precisa escolher uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
                	}
            
                // testando ainda o cadastro, perdendo a cabeça
            
			}
		});
		Cadastrar.setBounds(373, 320, 113, 26);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(TextNome);
		panel_2.add(lblCpf);
		panel_2.add(lblSenha);
		panel_2.add(lblFuncao);
		panel_2.add(TextSenha);
		panel_2.add(TextCpf);
		panel_2.add(comboFuncao);
		panel_2.add(Cadastrar);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSobrenome.setBounds(10, 85, 106, 18);
		panel_2.add(lblSobrenome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 120, 106, 18);
		panel_2.add(lblTelefone);
		
		JLabel lblSalario = new JLabel("Salário");
		lblSalario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSalario.setBounds(10, 285, 106, 18);
		panel_2.add(lblSalario);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 324, 106, 18);
		panel_2.add(lblEndereco);
		
		RoundedButton Deslogar = new RoundedButton("Log Off", 30, 30); // deslogar
		Deslogar.setForeground(new Color(255, 255, 255));
		Deslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleDeLogin login = new ControleDeLogin();
            	login.iniciar();
            	dispose();
			}
		});
		Deslogar.setText("Log Off");
		Deslogar.setFont(new Font("Arial", Font.PLAIN, 15));
		Deslogar.setBackground(Color.RED);
		Deslogar.setBounds(731, 8, 113, 26);
		panel_2.add(Deslogar);
		
		table = new JTable();
		table.setBounds(333, 46, 511, 250);
		panel_2.add(table);
		
		RoundedButton excluir = new RoundedButton("Excluir",30,30);
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            int id_Funcionario = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
		            
		            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja demitir o Funcionaio selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
		            if (confirm == JOptionPane.YES_OPTION) {
		                try {
		                    boolean sucesso = CadastroFuncionarioDAO.excluirFuncionario(id_Funcionario);
		                    if (sucesso) {
		                 
		                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
								JOptionPane.showMessageDialog(null, "Funcionáio demitido com sucesso!");
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Falha ao demitir o produto.");
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "Erro ao demitir o produto: " + ex.getMessage());
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione um Funcionário para demitir.");
		        }
			}
		});
		excluir.setFont(new Font("Arial", Font.PLAIN, 15));
		excluir.setForeground(new Color(255, 255, 255));
		excluir.setBackground(new Color(255, 0, 0));
		excluir.setBounds(528, 322, 113, 24);
		panel_2.add(excluir);
		
		RoundedButton editar = new RoundedButton("Editar",30,30);
		editar.setFont(new Font("Arial", Font.PLAIN, 15));
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());


		            String NomeFuncionario = table.getValueAt(selectedRow, 1).toString();
		            int login = Integer.parseInt(table.getValueAt(selectedRow, 6).toString());
		            String senha = table.getValueAt(selectedRow, 3).toString();
		            String tipo_funcionario = table.getValueAt(selectedRow, 4).toString();
		            String sobrenome = table.getValueAt(selectedRow, 4).toString();
		            double salario = Double.parseDouble(table.getValueAt(selectedRow, 5).toString());
		            int telefone = Integer.parseInt(table.getValueAt(selectedRow, 6).toString());
		            String endereco = table.getValueAt(selectedRow, 4).toString();
		            int op = comboFuncao.getSelectedIndex();
		            if(op == 1) {
                		tipo_funcionario = "Caixa";
                	}else if(op == 2){
                		tipo_funcionario = "Gerente";
                	}else if (op == 2) {
                		tipo_funcionario = "Esqoquista";
                	}else {
                		tipo_funcionario = null;
                		JOptionPane.showMessageDialog(null, "Precisa escolher uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
                	}


		            boolean success = CadastroFuncionarioDAO.atualizarFuncionario(id, NomeFuncionario,login, senha, tipo_funcionario, sobrenome, salario, telefone, endereco);
		            
		            if (success) {
		                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
		            } else {
		                JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto.");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
		        }
		    }
		});
		editar.setForeground(new Color(255, 255, 255));
		editar.setBackground(new Color(255, 0, 0));
		editar.setBounds(695, 322, 113, 24);
		panel_2.add(editar);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-142, 277, 1200, 355);
		panel_2.add(imgOndinha);
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		
		
	}
}
