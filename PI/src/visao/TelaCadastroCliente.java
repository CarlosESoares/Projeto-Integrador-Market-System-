
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import Modelo.ClienteDAO;
import Modelo.Funcionario;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	    public JTextField TextNome;
		public JTextField TextSobrenome;
		public JTextField TextCPF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente(null);
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
	public TelaCadastroCliente(Funcionario f) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		new ClienteDAO();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); 
		Image newImage = image.getScaledInstance(1400, 100, Image.SCALE_SMOOTH); 
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);

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
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); 
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		imgLogo.setIcon(ImgRedimencionada);
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);


		RoundedButton rndbtnHomeProdutos = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnHomeProdutos.setForeground(new Color(255, 255, 255));
		rndbtnHomeProdutos.setVisible(false);
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
		rndbtnHomeClientes.setForeground(Color.WHITE);
		rndbtnHomeClientes.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnHomeClientes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		    }
		});
		rndbtnHomeClientes.setText("Clientes");
		rndbtnHomeClientes.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeClientes.setBackground(Color.GRAY);

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
		rndbtnFuncionarios.setVisible(false);
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
		rndbtnResumo.setVisible(false);
		rndbtnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGerente abrir = new ControllerGerente();
				abrir.abrirTelaResumo(f);
				dispose();
			}
		});
		rndbtnResumo.setText("Resumo");
		rndbtnResumo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	rndbtnResumo.setBackground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e) {
            	rndbtnResumo.setBackground(Color.RED);
            }
        });
		rndbtnResumo.setText("Resumo");
		rndbtnResumo.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnResumo.setForeground(Color.WHITE);
		rndbtnResumo.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnResumo.setBackground(Color.RED);

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
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
		panel_1.setLayout(gl_panel_1);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de cliente");
		lblNewLabel_1.setBounds(185, 0, 182, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		TextFielArredondada TextLimite = new TextFielArredondada(15, 20, 20);
		TextLimite.setColumns(10);
		TextLimite.setBounds(18, 442, 187, 24);
		TextLimite.setText("R$:");
		panel_2.add(TextLimite);
		
		JLabel lblLimiteDeCrdito = new JLabel("Limite de crédito");
		lblLimiteDeCrdito.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLimiteDeCrdito.setBounds(18, 413, 115, 18);
		panel_2.add(lblLimiteDeCrdito);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(18, 318, 116, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(19, 351, 187, 24);
		TextNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Sobrenome:");
		lblTipo.setBounds(339, 325, 105, 18);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSobrenome = new TextFielArredondada(15,20,20);
		TextSobrenome.setBounds(339, 351, 187, 24);
		TextSobrenome.setColumns(10);
		
		JLabel lblChegada = new JLabel("CPF:");
		lblChegada.setBounds(644, 318, 115, 18);
		lblChegada.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCPF = new TextFielArredondada(15,20,20);
		TextCPF.setBounds(644, 347, 187, 24);
		TextCPF.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
		rndbtnExcluir.setForeground(new Color(255, 255, 255));
		rndbtnExcluir.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnExcluir.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnExcluir.setBackground(Color.RED);
		    }
		});
		rndbtnExcluir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ControllerGerente controller = new ControllerGerente();
		        controller.excluirCliente(table, TextNome, TextSobrenome, TextCPF,TextLimite);
		    }
		});
		rndbtnExcluir.setBounds(339, 573, 150, 26);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		
		
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
		rndbtnEditar.setForeground(new Color(255, 255, 255));
		rndbtnEditar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnEditar.setBackground(Color.LIGHT_GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnEditar.setBackground(Color.RED);
		    }
		});
		
		rndbtnEditar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ControllerGerente controller = new ControllerGerente();
		    	controller.editarCliente(table, TextNome, TextSobrenome, TextCPF,TextLimite);
		    }
		});
		rndbtnEditar.setBounds(644, 573, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(18, 59, 830, 195);
		
		

		String[] columnNames = {"ID", "Nome", "Sobrenome", "CPF","Limite de crédito"};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));

		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            TextNome.setText(table.getValueAt(selectedRow, 1).toString());
		            TextSobrenome.setText(table.getValueAt(selectedRow, 2).toString());
		            TextCPF.setText(table.getValueAt(selectedRow, 3).toString());
		            TextLimite.setText(table.getValueAt(selectedRow, 4).toString());
		        }
		    }
		});
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);



		  ControllerGerente controller = new ControllerGerente();
          controller.buscarClientes(table);
		RoundedButton rndbtnCadastrar = new RoundedButton("Cadastrar",30,30);
		rndbtnCadastrar.setForeground(new Color(255, 255, 255));
		rndbtnCadastrar.setBounds(18, 573, 150, 26);
		rndbtnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnCadastrar.setBackground(new Color(255, 0, 0));
		rndbtnCadastrar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnCadastrar.setBackground(Color.LIGHT_GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnCadastrar.setBackground(Color.RED);
		    }
		});
		 rndbtnCadastrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {


	            	ControllerGerente controller = new ControllerGerente();
	                controller.cadastrarCliente(table, TextNome, TextSobrenome, TextCPF,TextLimite);
	            }
	        });



		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(lblTipo);
		panel_2.add(TextNome);
		panel_2.add(TextSobrenome);
		panel_2.add(TextCPF);
		panel_2.add(lblChegada);
		panel_2.add(rndbtnCadastrar);
		panel_2.add(rndbtnExcluir);
		panel_2.add(rndbtnEditar);
		panel_2.add(panel_3);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-18, 631, 932, 100);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		
		String tipoFuncionario = f.getTipoFucionario();
		if (tipoFuncionario != null) {
            if (tipoFuncionario.equals("Caixa")) {
               
            } else if (tipoFuncionario.equals("Gerente")) {
            	rndbtnHomeProdutos.setVisible(true);
            	rndbtnFuncionarios.setVisible(true);
            	rndbtnResumo.setVisible(true);
            } else {
          
            }
            
        } else {
          new MensagemView( "Tipo de funcionário não definido.");
        }
		


}
}
