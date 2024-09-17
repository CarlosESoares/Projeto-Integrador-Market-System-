package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
import javax.swing.DefaultComboBoxModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Produto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextNome;
	private JTextField TextCpf;
	private JTextField TextSenha;

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
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1400, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		imgOndinha.setIcon(resizedIcon);
		panel.add(imgOndinha);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JLabel imgLogo = new JLabel("");
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
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
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(imgLogo)
						.addComponent(Cadastrar_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cadastrar_1_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cadastrar_1_2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(7)
					.addComponent(imgLogo)
					.addGap(28)
					.addComponent(Cadastrar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Cadastrar_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Cadastrar_1_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de produto");
		lblNewLabel_1.setBounds(195, 0, 182, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("SVGEM");
		lblNewLabel.setBounds(224, 30, 64, 22);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblNome = new JLabel("Nome do produto:");
		lblNome.setBounds(18, 66, 116, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome_1 = new TextFielArredondada(15,20,20);
		TextNome_1.setBounds(10, 90, 187, 24);
		TextNome_1.setColumns(10);
		
		JLabel lblCpf = new JLabel("Tipo do produto:");
		lblCpf.setBounds(20, 125, 105, 18);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf_1 = new TextFielArredondada(15,20,20);
		TextCpf_1.setBounds(10, 149, 187, 24);
		TextCpf_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Data de chegada:");
		lblSenha.setBounds(20, 184, 115, 18);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1 = new TextFielArredondada(15,20,20);
		TextSenha_1.setBounds(10, 208, 187, 24);
		TextSenha_1.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Preço:");
		lblFuncao.setBounds(20, 238, 43, 18);
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.setBounds(10, 340, 150, 26);
		Cadastrar.setText("Cadastrar produto");
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		
		TextFielArredondada TextSenha_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1.setBounds(10, 262, 187, 24);
		TextSenha_1_1.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
		rndbtnExcluir.setBounds(227, 340, 150, 26);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
		rndbtnEditar.setBounds(446, 340, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setBounds(248, 238, 139, 18);
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1_1.setBounds(234, 262, 187, 24);
		TextSenha_1_1_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 58, 344, 167);
		
		
		String[] columnNames = {"Nome do Produto", "Tipo", "Data de Chegada", "Preço", "Validade"};
		Object[][] data = {
		    {"Produto 1", "Tipo 1", "01/09/2024", "10.00", "10/12/2024"},
		    {"Produto 2", "Tipo 2", "05/09/2024", "15.00", "15/12/2024"},
		    {"Produto 3", "Tipo 3", "07/09/2024", "20.00", "20/12/2024"}
		};

		// Crie a tabela
		JTable table = new JTable(new DefaultTableModel(data, columnNames));
		JScrollPane scrollPane = new JScrollPane(table);

		// Adicione a tabela ao panel_3
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);
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
		panel_2.add(lblNewLabel);
		panel_2.add(panel_3);


}
}