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
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import Modelo.ClienteDAO;
import Modelo.Funcionario;
import Modelo.ProdutoDAO;
import Modelo.VendaDAO;

public class TelaResumo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tableFuncionario;
	public JTable tableProdutos;
	public JTable tableClientes;
	static TelaResumo frame = new TelaResumo(null);
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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

		public TelaResumo(Funcionario f) {
		    // Configuração básica da janela
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 1078, 739);

		    // Inicialize o contentPane e defina o layout
		    contentPane = new JPanel();
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(new BorderLayout(0, 0));

		    // Redimensionar e configurar o logotipo
		    ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		    Image imageLogo = originalIconLogo.getImage();
		    Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		    ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);

		    // Chamar método para buscar produtos

		    // Outros componentes e configurações...
		    JPanel panel_11 = new JPanel();
			panel_11.setBackground(Color.LIGHT_GRAY);
			contentPane.add(panel_11, BorderLayout.WEST);

			RoundedButton imgLogo = new RoundedButton("", 1, 1);
			imgLogo.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	ControllerGerente abrir = new ControllerGerente();
			    	abrir.AbrirTelaInicial(f);
					dispose();
				}
			});
			imgLogo.setBackground(Color.LIGHT_GRAY);
			imgLogo.setForeground(Color.LIGHT_GRAY);
		
			imgLogo.setIcon(ImgRedimencionada);
			imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);


			RoundedButton rndbtnHomeProdutos = new RoundedButton("Cadastrar", 30, 30);
			rndbtnHomeProdutos.setHorizontalAlignment(SwingConstants.LEFT);
			rndbtnHomeProdutos.setForeground(new Color(255, 255, 255));
			rndbtnHomeProdutos.addMouseListener(new MouseAdapter() {
			    public void mouseEntered(MouseEvent e) {
			        rndbtnHomeProdutos.setBackground(Color.GRAY); 
			    }
			    public void mouseExited(MouseEvent e) {
			        rndbtnHomeProdutos.setBackground(Color.RED);
			    }
			});
			rndbtnHomeProdutos.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        ControllerGerente abrir = new ControllerGerente();
			        abrir.AbrirTelaEstoque(f);
			        dispose();
			    }
			});
			rndbtnHomeProdutos.setText("Estoque");
			rndbtnHomeProdutos.setFont(new Font("Arial", Font.PLAIN, 11));
			rndbtnHomeProdutos.setBackground(Color.RED);


			ImageIcon iconProdutos = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
			Image imgProdutos = iconProdutos.getImage();
			Image novaImgProdutos = imgProdutos.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			rndbtnHomeProdutos.setIcon(new ImageIcon(novaImgProdutos));


			RoundedButton rndbtnHomeClientes = new RoundedButton("Cadastrar", 30, 30);
			rndbtnHomeClientes.setHorizontalAlignment(SwingConstants.LEFT);
			rndbtnHomeClientes.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            	rndbtnHomeClientes.setBackground(Color.GRAY);
	            }
	            public void mouseExited(MouseEvent e) {
	            	rndbtnHomeClientes.setBackground(Color.RED);
	            }
	        });
			rndbtnHomeClientes.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {

			    	ControllerGerente abrir = new ControllerGerente();
	                abrir.AbrirTelaCliente(f);
	                dispose();
	            }
	        });
			rndbtnHomeClientes.setText("Clientes");
			rndbtnHomeClientes.setFont(new Font("Arial", Font.PLAIN, 11));
			rndbtnHomeClientes.setBackground(Color.RED);

			ImageIcon iconClientes = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
			Image imgClientes = iconClientes.getImage();
			Image novaImgClientes = imgClientes.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			rndbtnHomeClientes.setIcon(new ImageIcon(novaImgClientes));


			RoundedButton rndbtnHomeCaixa = new RoundedButton("Cadastrar", 30, 30);
			rndbtnHomeCaixa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControllerGerente abrir = new ControllerGerente();
	                abrir.AbrirTelaCaixa(f);
	                dispose();
	            }
	        });
			rndbtnHomeCaixa.setHorizontalAlignment(SwingConstants.LEFT);
			rndbtnHomeCaixa.setForeground(new Color(255, 255, 255));
			rndbtnHomeCaixa.addMouseListener(new MouseAdapter() {
			    public void mouseEntered(MouseEvent e) {
			        rndbtnHomeCaixa.setBackground(Color.GRAY); 
			    }
			    public void mouseExited(MouseEvent e) {
			        rndbtnHomeCaixa.setBackground(Color.RED);
			    }
			});

			rndbtnHomeCaixa.setText("Caixa");
			rndbtnHomeCaixa.setFont(new Font("Arial", Font.PLAIN, 11));
			rndbtnHomeCaixa.setBackground(Color.RED);

			
			ImageIcon iconCaixa = new ImageIcon(getClass().getResource("/Imagens/desktop-solid.png"));
			Image imgCaixa = iconCaixa.getImage();
			Image novaImgCaixa = imgCaixa.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			rndbtnHomeCaixa.setIcon(new ImageIcon(novaImgCaixa));
			
			
			
			RoundedButton rndbtnFuncionarios = new RoundedButton("Cadastrar", 30, 30);
			rndbtnFuncionarios.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            	rndbtnFuncionarios.setBackground(Color.GRAY);
	            }
	            public void mouseExited(MouseEvent e) {
	            	rndbtnFuncionarios.setBackground(Color.RED);
	            }
	        });
			rndbtnFuncionarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			dispose();
					
					ControllerGerente.TelaCadastro(f);
					

		
				}
			});
			rndbtnFuncionarios.setText("Funcionários");
			rndbtnFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
			rndbtnFuncionarios.setForeground(Color.WHITE);
			rndbtnFuncionarios.setFont(new Font("Arial", Font.PLAIN, 11));
			rndbtnFuncionarios.setBackground(Color.RED);
			rndbtnFuncionarios.setIcon(new ImageIcon(novaImgClientes));
			
			ImageIcon iconResumo = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
			Image imgResumo = iconClientes.getImage();
			Image novaImgResumo = imgResumo.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			
	        
			RoundedButton rndbtnResumo = new RoundedButton("Cadastrar", 30, 30);
			rndbtnResumo.setIcon(new ImageIcon(novaImgResumo));
			rndbtnResumo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControllerGerente abrir = new ControllerGerente();
					abrir.abrirTelaResumo(f);
					dispose();
				}
			});
			rndbtnResumo.setText("Resumo");
		
			rndbtnResumo.setHorizontalAlignment(SwingConstants.LEFT);
			rndbtnResumo.setForeground(Color.WHITE);
			rndbtnResumo.setFont(new Font("Arial", Font.PLAIN, 11));
			rndbtnResumo.setBackground(Color.GRAY);

			GroupLayout gl_panel_1 = new GroupLayout(panel_11);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(rndbtnResumo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
									.addComponent(rndbtnFuncionarios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(rndbtnHomeCaixa, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(rndbtnHomeClientes, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(rndbtnHomeProdutos, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(19)
								.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rndbtnHomeCaixa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rndbtnFuncionarios, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(rndbtnResumo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(197, Short.MAX_VALUE))
			);
			panel_11.setLayout(gl_panel_1);

		    // Outros painéis e componentes
		    JPanel panel_2 = new JPanel();
		    contentPane.add(panel_2, BorderLayout.CENTER);
		    panel_2.setLayout(new BorderLayout(0, 0));

		

		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane, 65, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane, 59, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane, 322, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane, 364, SpringLayout.WEST, panel_3);
		panel_3.add(scrollPane);
		
		String[] columnNames2={"Nome", "Sobrenome", "Telefone", "Cargo"};

		Object[][] data1 = {};

		tableFuncionario = new JTable(new DefaultTableModel(data1,columnNames2));
		scrollPane.setViewportView(tableFuncionario);
		
		
		ControllerGerente.BuscarFR(TelaResumo.tableFuncionario);
		
		JLabel Funcio = new JLabel("Funcionarios");
		sl_panel_3.putConstraint(SpringLayout.NORTH, Funcio, -56, SpringLayout.NORTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, Funcio, 0, SpringLayout.WEST, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, Funcio, -6, SpringLayout.NORTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.EAST, Funcio, 266, SpringLayout.WEST, panel_3);
		Funcio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(Funcio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_1, -257, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_1, 25, SpringLayout.EAST, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_1, 330, SpringLayout.EAST, scrollPane);
		panel_3.add(scrollPane_1);
			

		String[] columnNames = {"ID", "Nome", "Preço", "Quantidade"};
		Object[][] data = {};
		tableProdutos = new JTable(new DefaultTableModel(data, columnNames));
        buscarProdutos();

		scrollPane_1.setViewportView(tableProdutos);
		
		JLabel lblNewLabel = new JLabel("Produto");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel, -4, SpringLayout.NORTH, Funcio);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 133, SpringLayout.EAST, Funcio);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, -2, SpringLayout.NORTH, scrollPane_1);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, scrollPane_1);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_2, 59, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_2, 59, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_2, 14, SpringLayout.EAST, scrollPane);
		panel_3.add(scrollPane_2);
		
		String[] columnNames3 = {"ID", "Nome", "Sobrenome", "CPF",};
		Object[][] data2 = {};
		tableClientes = new JTable(new DefaultTableModel(data2, columnNames3));
		buscarClientes();
		
		
		scrollPane_2.setViewportView(tableClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1, 62, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, scrollPane_2);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(lblNewLabel_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_3, 35, SpringLayout.EAST, scrollPane_2);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_3, -215, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_2, 0, SpringLayout.SOUTH, scrollPane_3);
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_3, 59, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_3, 326, SpringLayout.SOUTH, scrollPane_1);
		panel_3.add(scrollPane_3);
		
		table = new JTable();
		String[] columnNames4 = {"Id", "Preço", "ID Funcionario", "ID Cliente",};
		Object[][] data3 = {};
		table= new JTable(new DefaultTableModel(data3,columnNames4));
		BuscarVendas();
		scrollPane_3.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vendas");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, scrollPane_3);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(lblNewLabel_1_1);
		
	}
		private void BuscarVendas() {
			List<Object[]> vendas = VendaDAO.buscarVendasReduzindas(table);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados
			
			// Preenche a tabela com os dados dos produtos
			for (Object[] produto : vendas) {
			    model.addRow(produto);  // Adiciona uma nova linha à tabela
			}
		}
			
		
		private void buscarProdutos() {
		    try {
		        List<Object[]> produtos = ProdutoDAO.buscarTodosProdutosR();  // Recupera a lista de produtos
		        DefaultTableModel model = (DefaultTableModel) tableProdutos.getModel();
		        model.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados
		        
		        // Preenche a tabela com os dados dos produtos
		        for (Object[] produto : produtos) {
		            model.addRow(produto);  // Adiciona uma nova linha à tabela
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
		        e.printStackTrace();
		    }
		}
		
		private void buscarClientes() {
	        try {
	            List<Object[]> clientes = ClienteDAO.buscarTodosClientesR();
	            DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
	            model.setRowCount(0);  
	            for (Object[] clientes1 : clientes) {
	                model.addRow(clientes1); 
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes.");
	            e.printStackTrace();
	        }
	    }
}
