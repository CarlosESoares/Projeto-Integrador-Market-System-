package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Modelo.ConexaoBanco;
import Modelo.ProdutoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Produto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ProdutoDAO produtoDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produto frame = new Produto();
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
	public Produto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 554);
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
		
		JLabel imgLogo = new JLabel("");
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); 
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		imgLogo.setIcon(ImgRedimencionada);
		
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		RoundedButton rndbtnHomeProdutos = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rndbtnHomeProdutos.setText("Produtos");
		rndbtnHomeProdutos.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnHomeProdutos.setBackground(Color.GRAY);
		
		RoundedButton rndbtnHomeClientes = new RoundedButton("Cadastrar", 30, 30);
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
			}
		});
		rndbtnHomeClientes.setText("Clientes");
		rndbtnHomeClientes.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnHomeClientes.setBackground(Color.RED);
		
		RoundedButton rndbtnHomeVendas = new RoundedButton("Cadastrar", 30, 30);
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
		rndbtnHomeVendas.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnHomeVendas.setBackground(Color.RED);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(rndbtnHomeVendas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(imgLogo)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgLogo)
					.addGap(24)
					.addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rndbtnHomeVendas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
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
		TextQntd.setBounds(450, 293, 187, 24);
		panel_2.add(TextQntd);
		
		JLabel lblQntd = new JLabel("Quantidade:");
		lblQntd.setFont(new Font("Arial", Font.PLAIN, 15));
		lblQntd.setBounds(450, 264, 139, 18);
		panel_2.add(lblQntd);

		
		TextFielArredondada TextPreco = new TextFielArredondada(15, 20, 20);
		TextPreco.setBounds(10, 293, 187, 24);
		TextPreco.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
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
				
			}
		});
		rndbtnExcluir.setBounds(199, 369, 150, 26);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
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
			}
		});
		rndbtnEditar.setBounds(374, 369, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setBounds(234, 264, 139, 18);
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextValidade = new TextFielArredondada(15, 20, 20);
		TextValidade.setBounds(234, 293, 187, 24);
		TextValidade.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 58, 344, 167);
		
		

		String[] columnNames = {"ID", "Nome do Produto", "Tipo", "Data de Chegada", "Preço", "Validade", "Quantidade"};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));

		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);



        buscarProdutos();
		RoundedButton rndbtnCadastrar = new RoundedButton("Cadastrar",30,30);
		rndbtnCadastrar.setBounds(10, 369, 150, 26);
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
	             String nome = TextNome.getText();
	                String tipo = TextTipo.getText();
	                String dataChegada = TextChegada.getText();
	                String preco = TextPreco.getText();
	                String validade = TextValidade.getText();
	                String qntd = TextQntd.getText();
	                try {
	                    produtoDAO.cadastrarProduto(nome, tipo, dataChegada, preco, validade, qntd);
	                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
	                    buscarProdutos(); 
	                } catch (SQLException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto.");
	                    ex.printStackTrace();
	                }
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
		imgOndinha.setBounds(-20, 416, 710, 100);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		



}
	private void buscarProdutos() {
        try {
            List<Object[]> produtos = produtoDAO.buscarTodosProdutos();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  
            for (Object[] produto : produtos) {
                model.addRow(produto); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
            e.printStackTrace();
        }
    }
}