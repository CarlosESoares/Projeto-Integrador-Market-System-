package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.ConexaoBanco;
import controle.RoundedButton;
import controle.TextFielArredondada;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Produto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextNome;
	private JTextField TextCpf;
	private JTextField TextSenha;
	private JTable table;

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

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); 
		Image newImage = image.getScaledInstance(1400, 100, Image.SCALE_SMOOTH); 
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JLabel imgLogo = new JLabel("");
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); 
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		imgLogo.setIcon(ImgRedimencionada);
		
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		RoundedButton Cadastrar_1 = new RoundedButton("Cadastrar", 30, 30);
		Cadastrar_1.setText("Produtos");
		Cadastrar_1.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar_1.setBackground(Color.RED);
		
		RoundedButton Cadastrar_1_1 = new RoundedButton("Cadastrar", 30, 30);
		Cadastrar_1_1.setText("Clientes");
		Cadastrar_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar_1_1.setBackground(Color.RED);
		
		RoundedButton Cadastrar_1_2 = new RoundedButton("Cadastrar", 30, 30);
		Cadastrar_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cadastrar_1_2.setText("Vendas");
		Cadastrar_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar_1_2.setBackground(Color.RED);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Cadastrar_1_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(Cadastrar_1_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(Cadastrar_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(Cadastrar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Cadastrar_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Cadastrar_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
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
		
		TextFielArredondada TextNome_1 = new TextFielArredondada(15,20,20);
		TextNome_1.setBounds(10, 104, 187, 24);
		TextNome_1.setColumns(10);
		
		JLabel lblCpf = new JLabel("Tipo do produto:");
		lblCpf.setBounds(10, 139, 105, 18);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf_1 = new TextFielArredondada(15,20,20);
		TextCpf_1.setBounds(10, 165, 187, 24);
		TextCpf_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Data de chegada:");
		lblSenha.setBounds(10, 200, 115, 18);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1 = new TextFielArredondada(15,20,20);
		TextSenha_1.setBounds(10, 229, 187, 24);
		TextSenha_1.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Preço:");
		lblFuncao.setBounds(10, 264, 43, 18);
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.setBounds(10, 369, 150, 26);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		
		TextFielArredondada TextSenha_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1.setBounds(10, 293, 187, 24);
		TextSenha_1_1.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
		rndbtnExcluir.setBounds(199, 369, 150, 26);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
		rndbtnEditar.setBounds(374, 369, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setBounds(234, 264, 139, 18);
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1_1.setBounds(234, 293, 187, 24);
		TextSenha_1_1_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 58, 344, 167);
		
		

        String[] columnNames = {"Nome do Produto", "Tipo", "Data de Chegada", "Preço", "Validade"};
        Object[][] data = {};
        table = new JTable(new DefaultTableModel(data, columnNames));
        
  
        JScrollPane scrollPane = new JScrollPane(table);
        panel_3.setLayout(new BorderLayout());
        panel_3.add(scrollPane, BorderLayout.CENTER);


        buscarProdutos();
		


		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(lblCpf);
		panel_2.add(TextNome_1);
		panel_2.add(TextCpf_1);
		panel_2.add(TextSenha_1);
		panel_2.add(lblFuncao);
		panel_2.add(TextSenha_1_1);
		panel_2.add(lblSenha);
		panel_2.add(Cadastrar);
		panel_2.add(rndbtnExcluir);
		panel_2.add(rndbtnEditar);
		panel_2.add(lblValidadeDoProduto);
		panel_2.add(TextSenha_1_1_1);
		panel_2.add(panel_3);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-14, 395, 690, 100);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);


}
	 private void buscarProdutos() {
	        List<Object[]> produtos = new ArrayList<>();
	        String query = "SELECT * FROM produtos";

	        try (Connection connection = ConexaoBanco.getConexaoMySQL();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {
	                String nome = resultSet.getString("produto");
	                String tipo = resultSet.getString("tipo_produto");
	                String dataChegada = resultSet.getString("data_chegada");
	                String preco = resultSet.getString("preco");
	                String validade = resultSet.getString("validade_produto");
	                produtos.add(new Object[]{nome, tipo, dataChegada, preco, validade});
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        atualizarTabela(produtos);
	    }
	 private void atualizarTabela(List<Object[]> produtos) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        for (Object[] produto : produtos) {
	            model.addRow(produto);
	        }
	        
}}