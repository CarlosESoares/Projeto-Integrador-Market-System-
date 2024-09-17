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
		setBounds(100, 100, 1042, 536);
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
		
		panel_1.add(imgLogo);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro Funcionário");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("SVGEM");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblNome = new JLabel("Nome do produto:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome_1 = new TextFielArredondada(15,20,20);
		TextNome_1.setColumns(10);
		
		JLabel lblCpf = new JLabel("Tipo do produto:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf_1 = new TextFielArredondada(15,20,20);
		TextCpf_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Data de chegada:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1 = new TextFielArredondada(15,20,20);
		TextSenha_1.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Preço:");
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.setText("Cadastrar produto");
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		
		TextFielArredondada TextSenha_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		
		JLabel lblValidadeDoProduto = new JLabel("Validade do produto:");
		lblValidadeDoProduto.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1_1_1 = new TextFielArredondada(15, 20, 20);
		TextSenha_1_1_1.setColumns(10);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(299)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(361)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap(110, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(lblNome)
											.addGap(90))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addGap(10)
													.addComponent(lblCpf))
												.addComponent(TextNome_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
												.addComponent(TextCpf_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
												.addComponent(TextSenha_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addGap(10)
													.addComponent(lblFuncao))
												.addComponent(TextSenha_1_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
												.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(27)))
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(10)
											.addComponent(TextSenha_1_1_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(23)
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(lblValidadeDoProduto, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_panel_2.createSequentialGroup()
													.addComponent(rndbtnExcluir, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
													.addGap(65)
													.addComponent(rndbtnEditar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(10)
									.addComponent(lblSenha)))
							.addGap(198)))
					.addGap(390))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_1)
					.addGap(4)
					.addComponent(lblNewLabel)
					.addGap(9)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TextNome_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TextCpf_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TextSenha_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuncao)
						.addComponent(lblValidadeDoProduto, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(TextSenha_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(TextSenha_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(rndbtnExcluir, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(rndbtnEditar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		

}
}