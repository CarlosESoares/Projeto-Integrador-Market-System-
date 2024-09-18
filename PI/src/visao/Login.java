package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import controle.Banco2;
import controle.ProcessoDeLogin;
import controle.RoundedButton;
import controle.TextFielArredondada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField resCPF;
	private JTextField ResSenha;
	private JTextField ResCPF;
	private JTextField ResSenha2;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,500,500); 
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(215, 216, 216));
		contentPane.add(panel_2, BorderLayout.CENTER);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel txtCPF = new JLabel("CPF:");
		sl_panel_2.putConstraint(SpringLayout.WEST, txtCPF, 100, SpringLayout.WEST, panel_2);
		txtCPF.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(txtCPF);
		
		JLabel txtSenha = new JLabel("Senha:");
		sl_panel_2.putConstraint(SpringLayout.WEST, txtSenha, 97, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, txtSenha, -735, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, txtCPF, -58, SpringLayout.NORTH, txtSenha);
		txtSenha.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(txtSenha);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Fazer Login");
		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel, -115, SpringLayout.EAST, panel_2);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(lblNewLabel);
		
		JLabel TxtCPF2 = new JLabel("CPF");
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel, -78, SpringLayout.NORTH, TxtCPF2);
		sl_panel_2.putConstraint(SpringLayout.WEST, TxtCPF2, 151, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, TxtCPF2, -282, SpringLayout.SOUTH, panel_2);
		TxtCPF2.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(TxtCPF2);
		
		
		TextFielArredondada ResCPF = new TextFielArredondada(15,20,20);
		sl_panel_2.putConstraint(SpringLayout.NORTH, ResCPF, 6, SpringLayout.SOUTH, TxtCPF2);
		sl_panel_2.putConstraint(SpringLayout.WEST, ResCPF, 151, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, ResCPF, -144, SpringLayout.EAST, panel_2);
		panel_2.add(ResCPF);
		ResCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, TxtCPF2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -181, SpringLayout.SOUTH, panel_2);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(lblNewLabel_1);
		
		
		
		TextFielArredondada ResSenha2 = new TextFielArredondada(15, 20, 20);
		sl_panel_2.putConstraint(SpringLayout.NORTH, ResSenha2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_2.putConstraint(SpringLayout.WEST, ResSenha2, 151, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, ResSenha2, -144, SpringLayout.EAST, panel_2);
		panel_2.add(ResSenha2);
		ResSenha2.setColumns(10);
		
		RoundedButton BtnEntrarLogin2 = new RoundedButton("Entrar",30,30);
		BtnEntrarLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stml = null;
				Connection conn = Banco2.getConexaoMySQL();
				
				try {
					stml = (Statement) conn.createStatement();
					ResultSet resl = null;
					resl = ((java.sql.Statement) stml).executeQuery("SELECT * FROM Funcionarios");
					while(resl.next())
					{
						if(ResCPF.getText().equals(resl.getString("login")))
						{
							if(txtSenha.getText().equals(resl.getString("senha")))
							{
								if(resl.getInt("administrador") == 1)
								{
									JOptionPane.showMessageDialog(null, "ADM");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "FUNC");
								}
							}
						}
					}
					resl.close();
					((Connection) stml).close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("N foi");
		        
		        
		        
		    }
		}});
		sl_panel_2.putConstraint(SpringLayout.WEST, BtnEntrarLogin2, 151, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, BtnEntrarLogin2, -144, SpringLayout.EAST, panel_2);
		
		BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, BtnEntrarLogin2, 39, SpringLayout.SOUTH, ResSenha2);
		BtnEntrarLogin2.setForeground(new Color(255, 255, 255));
		BtnEntrarLogin2.setFont(new Font("Arial", Font.BOLD, 20));
		BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
		panel_2.add(BtnEntrarLogin2);
		
		
		
	}
}
