package visao;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaDoCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoCaixa frame = new TelaDoCaixa();
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
	public TelaDoCaixa() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[10px][4px][410px]", "[59px][192px]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(171, 171, 171));
		contentPane.add(panel, "cell 0 0 3 1,growx,aligny top");
		
		JLabel lblCAixa = new JLabel("Caixa");
		lblCAixa.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(lblCAixa);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(171, 171, 171));
		contentPane.add(panel_1, "cell 0 1,alignx left,growy");
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		
		JLabel logo = new JLabel("");
		contentPane.add(logo, "flowx,cell 2 1,alignx left,aligny center");
		logo.setIcon(ImgRedimencionada);
		
		JLabel label_1 = new JLabel("New label");
		contentPane.add(label_1, "cell 2 1");
		
		JLabel label = new JLabel("New label");
		contentPane.add(label, "cell 2 1");
		
		
	}

}
