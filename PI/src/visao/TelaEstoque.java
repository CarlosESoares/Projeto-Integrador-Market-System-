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

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ProdutoDAO produtoDAO;
	static Funcionario f;
	static TelaEstoque frame = new TelaEstoque(f);

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
	public TelaEstoque(Funcionario f) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 582);
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
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);

		RoundedButton imgLogo = new RoundedButton("", 1, 1);
		imgLogo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ControllerGerente.tipo(f);
		    }
		});
		TextFielArredondada TextValidade = new TextFielArredondada(15, 20, 20);
		TextValidade.setBounds(255, 293, 187, 24);
		TextValidade.setColumns(10);
		imgLogo.setBackground(Color.LIGHT_GRAY);
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); 
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		imgLogo.setIcon(ImgRedimencionada);

		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);

		// Botão Estoque
		RoundedButton rndbtnHomeProdutos = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeProdutos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		rndbtnHomeProdutos.setText("Estoque");
		rndbtnHomeProdutos.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeProdutos.setBackground(Color.GRAY);

		// Adicionando ícone ao botão Estoque
		ImageIcon iconProdutos = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
		Image imgProdutos = iconProdutos.getImage();
		Image novaImgProdutos = imgProdutos.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeProdutos.setIcon(new ImageIcon(novaImgProdutos));

		// Botão Clientes
		RoundedButton rndbtnHomeClientes = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeClientes.setForeground(new Color(255, 255, 255));
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

		// Adicionando ícone ao botão Clientes
		ImageIcon iconClientes = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
		Image imgClientes = iconClientes.getImage();
		Image novaImgClientes = imgClientes.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeClientes.setIcon(new ImageIcon(novaImgClientes));

		// Botão Vendas
		RoundedButton rndbtnHomeVendas = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeVendas.setForeground(new Color(255, 255, 255));
		rndbtnHomeVendas.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		        rndbtnHomeVendas.setBackground(Color.GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		        rndbtnHomeVendas.setBackground(Color.RED);
		    }
		});
		rndbtnHomeVendas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		rndbtnHomeVendas.setText("Vendas");
		rndbtnHomeVendas.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeVendas.setBackground(Color.RED);

		
		ImageIcon iconVendas = new ImageIcon(getClass().getResource("/Imagens/comments-dollar-solid.png"));
		Image imgVendas = iconVendas.getImage();
		Image novaImgVendas = imgVendas.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeVendas.setIcon(new ImageIcon(novaImgVendas));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
		    gl_panel_1.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		                .addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE)
		                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		                    .addComponent(rndbtnHomeVendas, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(rndbtnHomeProdutos, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
		    gl_panel_1.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addGap(24)
		            .addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(rndbtnHomeVendas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(276, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de produto");
		lblNewLabel_1.setBounds(185, 0, 182, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome do produto:");
		lblNome.setBounds(9, 71, 116, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(10, 104, 187, 24);
		TextNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo do produto:");
		lblTipo.setBounds(10, 139, 105, 18);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextTipo = new TextFielArredondada(15,20,20);
		TextTipo.setBounds(10, 165, 187, 24);
		TextTipo.setColumns(10);
		
		JLabel lblChegada = new JLabel("Data de chegada:");
		lblChegada.setBounds(10, 200, 115, 18);
		lblChegada.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextChegada = new TextFielArredondada(15,20,20);
		TextChegada.setBounds(10, 229, 187, 24);
		TextChegada.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(10, 264, 43, 18);
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextQntd = new TextFielArredondada(15, 20, 20);
		TextQntd.setColumns(10);
		TextQntd.setBounds(523, 293, 187, 24);
		panel_2.add(TextQntd);
		
		JLabel lblQntd = new JLabel("Quantidade:");
		lblQntd.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQntd.setBounds(523, 264, 139, 18);
		panel_2.add(lblQntd);

		
		TextFielArredondada TextPreco = new TextFielArredondada(15, 20, 20);
		TextPreco.setBounds(10, 293, 187, 24);
		TextPreco.setColumns(10);
		
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
		rndbtnExcluir.setBounds(255, 396, 150, 26);
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
		        ControllerGerente.editarProduto(table, produtoDAO, TextNome, TextTipo, TextChegada, TextValidade, TextPreco, TextQntd);
		        ControllerGerente.buscarProdutos(table);
		    }
		});

		rndbtnEditar.setBounds(523, 396, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setBounds(255, 264, 139, 18);
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 58, 486, 195);
		
		

		String[] columnNames = {"ID", "Nome do Produto", "Tipo", "Data de Chegada", "Preço", "Validade", "Quantidade"};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));

		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
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
		});


		ControllerGerente.buscarProdutos(table);
		RoundedButton rndbtnCadastrar = new RoundedButton("Cadastrar",30,30);
		rndbtnCadastrar.setForeground(new Color(255, 255, 255));
		rndbtnCadastrar.setBounds(10, 396, 150, 26);
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
		        ControllerGerente.cadastrarProduto(table, produtoDAO, TextNome, TextTipo, TextChegada, TextValidade, TextPreco, TextQntd);
		    }
		});


		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(lblTipo);
		panel_2.add(TextNome);
		panel_2.add(TextTipo);
		panel_2.add(TextChegada);
		panel_2.add(lblPreco);
		panel_2.add(TextPreco);
		panel_2.add(lblChegada);
		panel_2.add(rndbtnCadastrar);
		panel_2.add(rndbtnExcluir);
		panel_2.add(rndbtnEditar);
		panel_2.add(lblValidadeDoProduto);
		panel_2.add(TextValidade);
		panel_2.add(panel_3);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-25, 433, 866, 100);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		



}
	


	
}