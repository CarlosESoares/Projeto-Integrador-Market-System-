package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controle.ControleDeLogin;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField ResCPF;
	public JTextField ResSenha2;
	ControleDeLogin controleDeLogin;

	/**
	 * Create the frame.
	 * @param controleDeLogin 
	 */
	public Login(ControleDeLogin controleDeLogin) {
		this.controleDeLogin = controleDeLogin;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,500,500); 
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel txtCPF = new JLabel("CPF:");
		txtCPF.setBounds(100, -390, 46, 24);
		txtCPF.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(txtCPF);
		
		JLabel txtSenha = new JLabel("Senha:");
		txtSenha.setBounds(97, -308, 66, 24);
		txtSenha.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(txtSenha);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Fazer Login");
		lblNewLabel.setBounds(138, 20, 221, 47);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(lblNewLabel);
		
		JLabel TxtCPF2 = new JLabel("Login");
		TxtCPF2.setBounds(151, 145, 82, 24);
		TxtCPF2.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(TxtCPF2);
		
		
		this.ResCPF = new TextFielArredondada(15, 20, 20);  // Usando "this." para referenciar a variável de instância
        ResCPF.setBounds(151, 175, 179, 24);
        panel_2.add(ResCPF);
        ResCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(151, 246, 59, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		
		
		  this.ResSenha2 = new TextFielArredondada(15, 20, 20);  // Usando "this." para referenciar a variável de instância
	        ResSenha2.setBounds(151, 276, 179, 24);
	        panel_2.add(ResSenha2);
	        ResSenha2.setColumns(10);

		
		RoundedButton BtnEntrarLogin2 = new RoundedButton("Entrar",30,30);
		BtnEntrarLogin2.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	BtnEntrarLogin2.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	BtnEntrarLogin2.setBackground(Color.RED);
		    }
		});
		BtnEntrarLogin2.setBounds(151, 335, 179, 32);
		
		BtnEntrarLogin2.addActionListener(controleDeLogin.logar());
	
		
		BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
		BtnEntrarLogin2.setForeground(new Color(255, 255, 255));
		BtnEntrarLogin2.setFont(new Font("Arial", Font.BOLD, 20));
		BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
		panel_2.add(BtnEntrarLogin2);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-78, 262, 729, 342);
		panel_2.add(imgOndinha);
		imgOndinha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png")));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setBackground(Color.LIGHT_GRAY);
		
		
		
	}
}
