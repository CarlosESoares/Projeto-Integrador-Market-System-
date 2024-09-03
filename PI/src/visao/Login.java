package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(500, 500, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(56, 55, 70));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(30);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblFazerLogin = new JLabel("Fazer Login");
		lblFazerLogin.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblFazerLogin.setForeground(new Color(255, 255, 255));
		panel.add(lblFazerLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(56, 55, 70));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(0);
		contentPane.add(panel_1, BorderLayout.WEST);
		

		JLabel LblIcon = new JLabel("");
		LblIcon.setBackground(new Color(69, 68, 89));
		
		LblIcon.setIcon(new ImageIcon(Login.class.getResource("/Imagens/telas.png")));
		panel_1.add(LblIcon);
	}

}
