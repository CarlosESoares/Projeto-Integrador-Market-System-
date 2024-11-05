package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerTelaCliente;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;

public class TelaGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerente frame = new TelaGerente();
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
	public TelaGerente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1200, 200, Image.SCALE_SMOOTH); // Redimensione a imagem
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		
		RoundedButton imgLogo = new RoundedButton("",1,1);
		imgLogo.setBackground(new Color(192, 192, 192));
		panel.add(imgLogo, "cell 0 0");
		imgLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTelaCliente abrir = new ControllerTelaCliente();
				abrir.AbrirTelaInicial();
				dispose();
			}
		});
		imgLogo.setIcon(ImgRedimencionada);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][][][][][][][]", "[][][][][][][][][]"));
		
		RoundedButton btnNewButton = new RoundedButton("New button",30,30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		panel_1.add(btnNewButton, "cell 2 2");
		
		RoundedButton btnNewButton_1 = new RoundedButton("New button",30,30);
		btnNewButton_1.setBackground(new Color(255, 0, 0))
		;
		btnNewButton_1.setForeground(new Color(255, 255, 255));

		panel_1.add(btnNewButton_1, "cell 4 2");
		
		RoundedButton btnNewButton_2 = new RoundedButton("New button",30,30);
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));

		panel_1.add(btnNewButton_2, "cell 7 2");
		
		
	}
}
