package visao.TelasErro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controle.ControleDeLogin;
import visao.Login;
import visao.RoundedButton;
import visao.TextFielArredondada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErroDeValidacao extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ControleDeLogin controleDeLogin;
	static ErroDeValidacao frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ErroDeValidacao();
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
	public ErroDeValidacao() {setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0,500,274); 
	setLocationRelativeTo(null);
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panel_2 = new JPanel();
	
	contentPane.add(panel_2, BorderLayout.CENTER);
	panel_2.setLayout(null);
	
	
	
	
	
	JLabel lblNewLabel = new JLabel("Erro");
	lblNewLabel.setBounds(198, 32, 83, 47);
	lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
	panel_2.add(lblNewLabel);

	
	RoundedButton BtnEntrarLogin2 = new RoundedButton("Entrar",30,30);
	BtnEntrarLogin2.setText("ok");
	BtnEntrarLogin2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	});
	BtnEntrarLogin2.addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e) {
	    	BtnEntrarLogin2.setBackground(Color.LIGHT_GRAY);
	    }
	    public void mouseExited(MouseEvent e) {
	    	BtnEntrarLogin2.setBackground(Color.RED);
	    }
	});
	BtnEntrarLogin2.setBounds(215, 90, 66, 32);
	
	BtnEntrarLogin2.addActionListener(controleDeLogin.logar());

	
	BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
	BtnEntrarLogin2.setForeground(new Color(255, 255, 255));
	BtnEntrarLogin2.setFont(new Font("Arial", Font.BOLD, 20));
	BtnEntrarLogin2.setBackground(new Color(255, 0, 0));
	panel_2.add(BtnEntrarLogin2);
	
	JLabel imgOndinha = new JLabel("");
	imgOndinha.setBounds(-99, 45, 729, 342);
	panel_2.add(imgOndinha);
	imgOndinha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png")));
	imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
	imgOndinha.setBackground(Color.LIGHT_GRAY);}
}
