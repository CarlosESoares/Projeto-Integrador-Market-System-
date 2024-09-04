package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Cadastro_Gerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		JLabel lblNewLabel = new JLabel("SVGEM");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro Funcionário");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Função");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Caixa", "Gerente", "Estoquista"}));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(345)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(388, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(284)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addContainerGap())
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(470))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(textField_1, Alignment.LEADING)
								.addComponent(textField_2, Alignment.LEADING)
								.addComponent(comboBox, Alignment.LEADING, 0, 261, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(25))
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		

}
}
