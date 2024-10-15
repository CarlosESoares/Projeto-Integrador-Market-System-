package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaDoCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TextNome;
	private JTextField TextCpf;
	private JTextField TextSenha;
	private JTable table;
	private JTextField textfield;

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
		setBounds(100, 100, 1042, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); // Obtenha a imagem do ImageIcon
		Image newImage = image.getScaledInstance(1200, 200, Image.SCALE_SMOOTH); // Redimensione a imagem
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
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
		panel_2.setLayout(null);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-132, 456, 1200, 355);
		panel_2.add(imgOndinha);
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		
		RoundedButton btnNewButton = new RoundedButton("ABRIR CAIXA",30,30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(44, 25, 777, 34);
		panel_2.add(btnNewButton);
		
		RoundedButton btnNewButton_1 = new RoundedButton("New button",1,1);
		btnNewButton_1.setText("CÓIGO DE BARRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(48, 113, 155, 23);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(48, 199, 155, 23);
		panel_2.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("R$ 0,00");
		panel_3_1.add(lblNewLabel_1);
		
		RoundedButton btnNewButton_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_1.setText("VALOR UNITÁRIO");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(48, 178, 155, 23);
		panel_2.add(btnNewButton_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(48, 266, 155, 23);
		panel_2.add(panel_3_2);
		
		JLabel lblNewLabel_2 = new JLabel("R$ 0,00");
		panel_3_2.add(lblNewLabel_2);
		
		RoundedButton btnNewButton_1_2 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_2.setText("TOTAL DO IEM");
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(48, 245, 155, 23);
		panel_2.add(btnNewButton_1_2);
		
		RoundedButton btnNewButton_1_3 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3.setText("CÓDIGO");
		btnNewButton_1_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3.setBounds(48, 310, 155, 23);
		panel_2.add(btnNewButton_1_3);
		
		RoundedButton btnNewButton_1_3_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1.setText("SUBTOTAL");
		btnNewButton_1_3_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1.setBounds(246, 331, 486, 23);
		panel_2.add(btnNewButton_1_3_1);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBackground(Color.WHITE);
		panel_3_3_1.setBounds(246, 354, 486, 23);
		panel_2.add(panel_3_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_3_3_1.add(lblNewLabel_4);
		
		RoundedButton btnNewButton_1_3_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_1.setText("TOTAL RECEBIDO");
		btnNewButton_1_3_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1_1.setBounds(297, 399, 181, 23);
		panel_2.add(btnNewButton_1_3_1_1);
		
		JPanel panel_3_3_1_1 = new JPanel();
		panel_3_3_1_1.setBackground(Color.WHITE);
		panel_3_3_1_1.setBounds(297, 422, 181, 23);
		panel_2.add(panel_3_3_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_3_3_1_1.add(lblNewLabel_5);
		
		RoundedButton btnNewButton_1_3_1_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_1_1.setText("TROCO");
		btnNewButton_1_3_1_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1_1_1.setBounds(488, 399, 186, 23);
		panel_2.add(btnNewButton_1_3_1_1_1);
		
		JPanel panel_3_3_1_1_1 = new JPanel();
		panel_3_3_1_1_1.setBackground(Color.WHITE);
		panel_3_3_1_1_1.setBounds(488, 422, 186, 23);
		panel_2.add(panel_3_3_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_3_3_1_1_1.add(lblNewLabel_6);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(246, 113, 486, 195);
		panel_2.add(panel_4);
		
		String[] columnNames = {"N°item", "codigo ", "Discriçao", "QTD", "valor.unitario", "total"};
		Object[][] data = {};
		panel_4.setLayout(new BorderLayout());
		table = new JTable(new DefaultTableModel(data, columnNames));
		panel_4.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		HintTextField textfield = new HintTextField("000 00000 00000");  
		textfield.setHorizontalAlignment(SwingConstants.CENTER);

		textfield.setBounds(48, 133, 155, 20);
		panel_2.add(textfield);
		textfield.setColumns(10);
		
		HintTextField textfield_1 = new HintTextField("00000");
		textfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_1.setColumns(10);
		textfield_1.setBounds(48, 332, 155, 20);
		panel_2.add(textfield_1);
		
		/*-----------------------------------------------------
		
		
		

		String[] columnNames = {"ID", "Nome do Produto", "Tipo", "Data de Chegada", "Preço", "Validade", "Quantidade"};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));

		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);

		*/
}
}

