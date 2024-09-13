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

public class Cadastro_Gerente extends JFrame {

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
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1200, 200, Image.SCALE_SMOOTH); // Redimensione a imagem
		
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
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome_1 = new TextFielArredondada(15,20,20);
		TextNome_1.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf_1 = new TextFielArredondada(15,20,20);
		TextCpf_1.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha_1 = new TextFielArredondada(15,20,20);
		TextSenha_1.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Função");
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JComboBox comboFuncao = new JComboBox();
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Selecionar", "Caixa", "Gerente", "Estoquista"}));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		
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
							.addGap(252)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(TextNome_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCpf)
										.addComponent(lblSenha)
										.addComponent(lblFuncao, Alignment.TRAILING))
									.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(TextSenha_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(TextCpf_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(comboFuncao, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addGap(390))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(416)
					.addComponent(Cadastrar)
					.addContainerGap(603, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel_1)
					.addGap(4)
					.addComponent(lblNewLabel)
					.addGap(9)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(TextNome_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(TextCpf_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
					.addGap(26)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(TextSenha_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFuncao))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(Cadastrar))
		);
		panel_2.setLayout(gl_panel_2);
		
		

}
}
