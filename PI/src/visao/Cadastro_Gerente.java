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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControleDeLogin;
import Controle.ControllerGerente;
import Modelo.Funcionario;

public class Cadastro_Gerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	private static Cadastro_Gerente frame;
	public int id;
	public static JButton BtnGerente;
//	public 		Funcionario f;
	public ControllerGerente tipo = new ControllerGerente();
public	String tipoFunci;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Cadastro_Gerente(null);
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
	public Cadastro_Gerente(Funcionario f) {
		
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
				ControllerGerente abrir = new ControllerGerente();
				abrir.AbrirTelaEstoque(null);
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
				ControllerGerente abrir = new ControllerGerente();
				abrir.AbrirTelaCliente(f);
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
				ControllerGerente abrir = new ControllerGerente();
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
				ControllerGerente abrir = new ControllerGerente();
                abrir.TelaInicial();
                dispose();
            
			
		}});
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
		        int op = comboFuncao.getSelectedIndex();
		    	try {
					ControllerGerente.Cadastro(TextNome,TextSobrenome,TextTelefone,TextCpf,TextSenha,op,TextSalario,TextEndereço);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
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
		
		RoundedButton excluir = new RoundedButton("Excluir",30,30);
		excluir.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	excluir.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	excluir.setBackground(Color.RED);
		    }
		});
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Janelaexcluir = new JFrame("Demitir Funcionario");
				 Janelaexcluir.setSize(300, 200);
			     Janelaexcluir.setLocationRelativeTo(null);
			     Janelaexcluir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			     JPanel painelExcluir = new JPanel();
			        painelExcluir.setLayout(null);
			        Janelaexcluir.add(painelExcluir);

			     
			        JLabel lblId = new JLabel("ID do Funcionário:");
			        lblId.setBounds(10, 30, 150, 30);
			        lblId.setFont(new Font("Arial", Font.PLAIN, 15));
			        painelExcluir.add(lblId);

			        TextFielArredondada textId = new TextFielArredondada(15, 20, 20);
			        textId.setColumns(10);
			        textId.setBounds(160, 30, 100, 30);
			        painelExcluir.add(textId);

			        RoundedButton btnExcluir = new RoundedButton("Excluir", 30, 30);
			        btnExcluir.setBounds(90, 100, 120, 40);
			        btnExcluir.setForeground(Color.WHITE);
			        btnExcluir.setBackground(Color.RED);
			        btnExcluir.addMouseListener(new MouseAdapter() {
			            public void mouseEntered(MouseEvent e) {
			                btnExcluir.setBackground(Color.LIGHT_GRAY);
			            }

			            public void mouseExited(MouseEvent e) {
			                btnExcluir.setBackground(Color.RED);
			            }
			        });
			        btnExcluir.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                try {
			                	
			                    int id = Integer.parseInt(textId.getText());
			                    ControllerGerente.excluir(id);
			                    Janelaexcluir.dispose();
			                    JOptionPane.showMessageDialog(Janelaexcluir, "Funcionário excluído com sucesso!");            
			                    
			                } catch (NumberFormatException ex) {
			                	
			                    JOptionPane.showMessageDialog(Janelaexcluir, "Por favor, insira um ID válido!", "Erro", JOptionPane.ERROR_MESSAGE);
			                }
			            }
			        });
			        painelExcluir.add(btnExcluir);
			        Janelaexcluir.setVisible(true);
			    }
			});
		
		excluir.setFont(new Font("Arial", Font.PLAIN, 15));
		excluir.setForeground(new Color(255, 255, 255));
		excluir.setBackground(new Color(255, 0, 0));
		excluir.setBounds(528, 322, 113, 24);
		panel_2.add(excluir);
		
		RoundedButton editar = new RoundedButton("Editar", 30, 30);
		editar.setFont(new Font("Arial", Font.PLAIN, 15));
		editar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Criando a janela de edição
		        JFrame editarWindow = new JFrame("Editar Funcionário");
		        editarWindow.setSize(400, 400);  // Aumentei o tamanho para acomodar todos os campos
		        editarWindow.setLocationRelativeTo(null);  // Centraliza a janela
		        editarWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		        // Painel para organizar os componentes
		        JPanel painelEditar = new JPanel();
		        painelEditar.setLayout(null);  // Layout personalizado
		        editarWindow.getContentPane().add(painelEditar);

		        // Rótulo e campo para ID do Funcionário
		        JLabel lblId = new JLabel("ID do Funcionário:");
		        lblId.setBounds(20, 20, 150, 30);  // Posicionei o ID no topo
		        lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblId);
		        
		        TextFielArredondada textId = new TextFielArredondada(15, 20, 20);  // Assumindo que seja uma classe personalizada
		        textId.setColumns(10);
		        textId.setBounds(160, 20, 100, 30);  // Ajustei a posição para não sobrepor outros campos
		        painelEditar.add(textId);

		        // Rótulo e campo para Nome
		        JLabel lblNome = new JLabel("Nome:");
		        lblNome.setBounds(20, 70, 100, 25);  // Ajustei a posição para deixar espaço
		        lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblNome);

		        JTextField tfNome = new JTextField();
		        tfNome.setBounds(120, 70, 200, 25);
		        painelEditar.add(tfNome);

		        // Rótulo e campo para Sobrenome
		        JLabel lblSobrenome = new JLabel("Sobrenome:");
		        lblSobrenome.setBounds(20, 110, 100, 25);
		        lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblSobrenome);

		        JTextField tfSobrenome = new JTextField();
		        tfSobrenome.setBounds(120, 110, 200, 25);
		        painelEditar.add(tfSobrenome);

		        // Rótulo e campo para Telefone
		        JLabel lblTelefone = new JLabel("Telefone:");
		        lblTelefone.setBounds(20, 150, 100, 25);
		        lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblTelefone);

		        JTextField tfTelefone = new JTextField();
		        tfTelefone.setBounds(120, 150, 200, 25);
		        painelEditar.add(tfTelefone);

		        // Rótulo e campo para Salário
		        JLabel lblSalario = new JLabel("Salário:");
		        lblSalario.setBounds(20, 190, 100, 25);
		        lblSalario.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblSalario);

		        JTextField tfSalario = new JTextField();
		        tfSalario.setBounds(120, 190, 200, 25);
		        painelEditar.add(tfSalario);

		        // Rótulo e campo para Endereço
		        JLabel lblEndereco = new JLabel("Endereço:");
		        lblEndereco.setBounds(20, 230, 100, 25);
		        lblEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
		        painelEditar.add(lblEndereco);

		        JTextField tfEndereco = new JTextField();
		        tfEndereco.setBounds(120, 230, 200, 25);
		        painelEditar.add(tfEndereco);

		        // Botão para Salvar as alterações
		        RoundedButton btnSalvar = new RoundedButton("Salvar", 30, 30);
		        btnSalvar.setBounds(120, 270, 100, 40);
		        btnSalvar.setForeground(Color.WHITE);
		        btnSalvar.setBackground(Color.GREEN);
		        
		        // Alteração de cor ao passar o mouse sobre o botão
		        btnSalvar.addMouseListener(new MouseAdapter() {
		            public void mouseEntered(MouseEvent e) {
		                btnSalvar.setBackground(Color.LIGHT_GRAY);
		            }

		            public void mouseExited(MouseEvent e) {
		                btnSalvar.setBackground(Color.GREEN);
		            }
		        });

		        btnSalvar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                int id = Integer.parseInt(textId.getText());  // Obtém o ID inserido no campo de texto    
		                
		                ControllerGerente.editar(table,id,tfNome, tfSobrenome, tfSalario, tfTelefone, tfEndereco);
		                editarWindow.dispose(); // Fecha a janela após salvar
		            }
		        });

		        painelEditar.add(btnSalvar);

		        // Torna a janela visível
		        editarWindow.setVisible(true);
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
		
		
		table = new JTable();
		String[] columnNames = {"Id","Nome","Sobrenome","Telefone","Salário","Endereço"};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(299, 83, 545, 190);
		panel_2.add(scrollPane);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGerente tela = new ControllerGerente();
				frame.dispose();
				tela.TelaInicial();
			}
		});
			ControllerGerente.BuscarF(Cadastro_Gerente.table);
}
}


