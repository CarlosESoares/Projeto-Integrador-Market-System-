package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.RoundedButton;
import controle.TextFielArredondada;

import javax.swing.JLabel;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField resCPF;
	private JTextField ResSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 700, 1000, 700); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel imgOndinha = new JLabel("");
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1000, 250, Image.SCALE_SMOOTH); // Redimensione a imagem
		
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
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel txtCPF = new JLabel("CPF:");
		txtCPF.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(txtCPF);
		
		TextFielArredondada resCPF = new TextFielArredondada(15,20,20);
		resCPF.setBorder(BorderFactory.createEmptyBorder());
		
		sl_panel_2.putConstraint(SpringLayout.NORTH, resCPF, 160, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, resCPF, -194, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, txtCPF, 0, SpringLayout.WEST, resCPF);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, txtCPF, -17, SpringLayout.NORTH, resCPF);
		sl_panel_2.putConstraint(SpringLayout.WEST, resCPF, 259, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, resCPF, -327, SpringLayout.EAST, panel_2);
		panel_2.add(resCPF);
		resCPF.setColumns(10);
		
		JLabel txtSenha = new JLabel("Senha:");
		txtSenha.setFont(new Font("Arial", Font.BOLD, 20));
		sl_panel_2.putConstraint(SpringLayout.NORTH, txtSenha, 34, SpringLayout.SOUTH, resCPF);
		sl_panel_2.putConstraint(SpringLayout.WEST, txtSenha, 0, SpringLayout.WEST, txtCPF);
		panel_2.add(txtSenha);
		
		//ta dando erro aq
		TextFielArredondada ResSenha = new TextFielArredondada(15, 20, 20);
		ResSenha.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda padrão para usar a nossa
		sl_panel_2.putConstraint(SpringLayout.NORTH, ResSenha, 6, SpringLayout.SOUTH, txtSenha);
		sl_panel_2.putConstraint(SpringLayout.WEST, ResSenha, 0, SpringLayout.WEST, txtCPF);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, ResSenha, 45, SpringLayout.SOUTH, txtSenha);
		sl_panel_2.putConstraint(SpringLayout.EAST, ResSenha, 0, SpringLayout.EAST, resCPF);
		
		panel_2.add(ResSenha);
		ResSenha.setColumns(10);
		
		
		RoundedButton BtnEntrarLogin = new RoundedButton("Entrar", 30, 30);
		BtnEntrarLogin.setForeground(new Color(255, 255, 255));
		BtnEntrarLogin.setFont(new Font("Arial", Font.BOLD, 20));
		BtnEntrarLogin.setBackground(new Color(255, 0, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, BtnEntrarLogin, 22, SpringLayout.SOUTH, ResSenha);
		sl_panel_2.putConstraint(SpringLayout.WEST, BtnEntrarLogin, 259, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, BtnEntrarLogin, 61, SpringLayout.SOUTH, ResSenha);
		sl_panel_2.putConstraint(SpringLayout.EAST, BtnEntrarLogin, 0, SpringLayout.EAST, resCPF);
		panel_2.add(BtnEntrarLogin);
		
		
		JLabel lblNewLabel = new JLabel("Fazer Login");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel, 23, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel, 296, SpringLayout.WEST, panel_2);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(lblNewLabel);
		
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		
		
	}
}
