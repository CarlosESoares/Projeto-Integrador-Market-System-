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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import Modelo.Funcionario;
import Modelo.ProdutoDAO;
import javax.swing.JComboBox;

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ProdutoDAO produtoDAO;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public TelaEstoque(Funcionario f) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		produtoDAO = new ProdutoDAO();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); 
		Image newImage = image.getScaledInstance(1400, 100, Image.SCALE_SMOOTH); 
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
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
		String tipoFuncionario = f.getTipoFucionario();
		 if (tipoFuncionario != null) {
	            if (tipoFuncionario.equals("Caixa")) {
	                
	            } else if (tipoFuncionario.equals("Gerente")) {
	            	panel_1.setVisible(true);
	            	setBounds(100, 100, 1024, 768);
	            	
	            } else {
	                
	            }
	          
	        } else {
	          new MensagemView( "Tipo de funcionário não definido.");
	        }

	

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


		rndbtnHomeProdutos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ControllerGerente abrir = new ControllerGerente();
		        abrir.AbrirTelaEstoque(f);
		        dispose();
		    }
		});
		rndbtnHomeProdutos.setText("Estoque");
		rndbtnHomeProdutos.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeProdutos.setBackground(Color.GRAY);


		ImageIcon iconProdutos = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
		Image imgProdutos = iconProdutos.getImage();
		Image novaImgProdutos = imgProdutos.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeProdutos.setIcon(new ImageIcon(novaImgProdutos));


		RoundedButton rndbtnHomeClientes = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeClientes.setForeground(Color.WHITE);
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
		JComboBox<Integer> combodia_1 = new JComboBox<>();
        combodia_1.setBounds(303, 389, 43, 21);
        for (int i = 1; i <= 31; i++) {
            combodia_1.addItem(i);
        }
        panel_2.add(combodia_1);

        JComboBox<Integer> combomes_1 = new JComboBox<>();
        combomes_1.setBounds(356, 389, 43, 21);
        for (int i = 1; i <= 12; i++) {
            combomes_1.addItem(i);
        }
        panel_2.add(combomes_1);

        JComboBox<Integer> comboano_1 = new JComboBox<>();
        comboano_1.setBounds(411, 389, 57, 21);
        for (int i = 2024; i <= 2050; i++) {
            comboano_1.addItem(i);
        }
        panel_2.add(comboano_1);
        
		JComboBox<Integer> combodia = new JComboBox<Integer>();
		combodia.setBounds(10, 389, 43, 21);
        for (int i = 1; i <= 31; i++) {
        	combodia.addItem(i);
        }
		panel_2.add(combodia);
		
		JComboBox<Integer> combomes = new JComboBox<Integer>();
		combomes.setBounds(63, 389, 43, 21);
	     for (int i = 1; i <= 12; i++) {
	    	 combomes.addItem(i);
	        }
		panel_2.add(combomes);
		
		JComboBox<Integer> comboano = new JComboBox<Integer>();
		comboano.setBounds(116, 389, 57, 21);
	     for (int i = 2024; i <= 2050; i++) {
	    	 comboano.addItem(i);
	        }
		panel_2.add(comboano);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de produto");
		lblNewLabel_1.setBounds(298, 0, 230, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome do produto:");
		lblNome.setBounds(10, 282, 131, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(10, 310, 188, 24);
		TextNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo do produto:");
		lblTipo.setBounds(303, 282, 130, 18);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextTipo = new TextFielArredondada(15,20,20);
		TextTipo.setBounds(303, 310, 188, 24);
		TextTipo.setColumns(10);
		
		JLabel lblChegada = new JLabel("Data de chegada:");
		lblChegada.setBounds(11, 359, 150, 18);
		lblChegada.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(599, 282, 111, 18);
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextQntd = new TextFielArredondada(15, 20, 20);
		TextQntd.setColumns(10);
		TextQntd.setBounds(599, 388, 187, 24);
		panel_2.add(TextQntd);
		
		JLabel lblQntd = new JLabel("Quantidade:");
		lblQntd.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQntd.setBounds(599, 359, 139, 18);
		panel_2.add(lblQntd);

		
		TextFielArredondada TextPreco = new TextFielArredondada(15, 20, 20);
		TextPreco.setBounds(599, 310, 188, 24);
		TextPreco.setColumns(10);
		TextPreco.setText("R$:");
		
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
		    	ProdutoDAO produtoDAO = new ProdutoDAO();
		    	ControllerGerente.excluirProduto(table, produtoDAO);
		    }
		});
		rndbtnExcluir.setBounds(316, 541, 150, 26);
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
		    	int dia = (int) combodia.getSelectedItem();
                int mes = (int) combomes.getSelectedItem();
                int ano = (int) comboano.getSelectedItem();

                // Formata a data no formato dd/mm/yyyy
                String dataChegada = String.format("%02d/%02d/%04d", dia, mes, ano);
		    	int dia1 = (int) combodia_1.getSelectedItem();
                int mes1 = (int) combomes_1.getSelectedItem();
                int ano1 = (int) comboano_1.getSelectedItem();

                // Formata a data no formato dd/mm/yyyy
                String validade = String.format("%02d/%02d/%04d", dia1, mes1, ano1);
		        ControllerGerente.editarProduto(table, produtoDAO, TextNome, TextTipo, dataChegada, validade, TextPreco, TextQntd);
		        ControllerGerente.buscarProdutos(table);
		    }
		});

		rndbtnEditar.setBounds(637, 541, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setBounds(303, 361, 187, 18);
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(11, 58, 837, 195);
		
		

		String[] NomeColunas = {"ID", "Produto", "Tipo", "Chegada", "Preço", "Validade", "Quantidade"};
		Object[][] dados = {};
		table = new JTable(new DefaultTableModel(dados, NomeColunas));

		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);

		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int linhaSelecionada = table.getSelectedRow();
		        if (linhaSelecionada != -1) {
		            TextNome.setText(table.getValueAt(linhaSelecionada, 1).toString());
		            TextTipo.setText(table.getValueAt(linhaSelecionada, 2).toString());
		            TextPreco.setText(table.getValueAt(linhaSelecionada, 4).toString());
		            TextQntd.setText(table.getValueAt(linhaSelecionada, 6).toString());

		            // Data de Chegada
		            String dataChegada = table.getValueAt(linhaSelecionada, 3).toString();
		            if (!dataChegada.isEmpty()) {
		                String[] partesChegada = dataChegada.split("/");
		                if (partesChegada.length == 3) {
		                    combodia.setSelectedItem(Integer.parseInt(partesChegada[0]));
		                    combomes.setSelectedItem(Integer.parseInt(partesChegada[1]));
		                    comboano.setSelectedItem(Integer.parseInt(partesChegada[2]));
		                }
		            }

		            // Validade
		            String validade = table.getValueAt(linhaSelecionada, 5).toString();
		            if (!validade.isEmpty()) {
		                String[] partesValidade = validade.split("/");
		                if (partesValidade.length == 3) {
		                    combodia_1.setSelectedItem(Integer.parseInt(partesValidade[0]));
		                    combomes_1.setSelectedItem(Integer.parseInt(partesValidade[1]));
		                    comboano_1.setSelectedItem(Integer.parseInt(partesValidade[2]));
		                }
		            }
		        }
		    }
		});

		ControllerGerente.buscarProdutos(table);
		RoundedButton rndbtnCadastrar = new RoundedButton("Cadastrar",30,30);
		rndbtnCadastrar.setForeground(new Color(255, 255, 255));
		rndbtnCadastrar.setBounds(10, 541, 150, 26);
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
		    	int dia = (int) combodia.getSelectedItem();
                int mes = (int) combomes.getSelectedItem();
                int ano = (int) comboano.getSelectedItem();

                // Formata a data no formato dd/mm/yyyy
                String dataChegada = String.format("%02d/%02d/%04d", dia, mes, ano);
		    	int dia1 = (int) combodia_1.getSelectedItem();
                int mes1 = (int) combomes_1.getSelectedItem();
                int ano1 = (int) comboano_1.getSelectedItem();

                // Formata a data no formato dd/mm/yyyy
                String validade = String.format("%02d/%02d/%04d", dia1, mes1, ano1);

		        ControllerGerente.cadastrarProduto(table, produtoDAO, TextNome, TextTipo, dataChegada, validade, TextPreco, TextQntd);
		    }
		});


		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(lblTipo);
		panel_2.add(TextNome);
		panel_2.add(TextTipo);
		panel_2.add(lblPreco);
		panel_2.add(TextPreco);
		panel_2.add(lblChegada);
		panel_2.add(rndbtnCadastrar);
		panel_2.add(rndbtnExcluir);
		panel_2.add(rndbtnEditar);
		panel_2.add(lblValidadeDoProduto);
		panel_2.add(panel_3);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-17, 539, 938, 290);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		
		
	




}
}