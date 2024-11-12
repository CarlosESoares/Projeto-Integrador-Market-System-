package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerTelaCliente;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.miginfocom.swing.MigLayout;

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
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		panel_1.setLayout(new MigLayout("", "[100px]", "[100px][][][][][][][][][][]"));

		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-132, 456, 1200, 355);
		panel_2.add(imgOndinha);
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);

		// Botão "ABRIR CAIXA"
		RoundedButton btnNewButton = new RoundedButton("ABRIR CAIXA", 30, 30);
		btnNewButton.setText("  ABRIR CAIXA  ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0)); // Cor padrão
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
			}
		});

		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.GRAY); // Cor ao passar o mouse
			}

			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(255, 0, 0)); // Cor original
			}
		});

		RoundedButton imgLogo = new RoundedButton("", 1, 1);
		imgLogo.setBackground(new Color(192, 192, 192));
		panel_1.add(imgLogo, "cell 0 0");
		imgLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerTelaCliente abrir = new ControllerTelaCliente();
				abrir.AbrirTelaInicial();
				dispose();
			}
		});
		imgLogo.setIcon(ImgRedimencionada);

		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnNewButton, "cell 0 6,alignx left,aligny center");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(255, 0, 0));

		RoundedButton rndbtnFecharCaixa = new RoundedButton("ABRIR CAIXA", 30, 30);
		rndbtnFecharCaixa.setForeground(new Color(255, 255, 255));
		rndbtnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);

			}
		});
		rndbtnFecharCaixa.setText(" FECHAR CAIXA ");
		rndbtnFecharCaixa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rndbtnFecharCaixa.setBackground(Color.RED);
		panel_1.add(rndbtnFecharCaixa, "cell 0 8");

		RoundedButton btnNewButton_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1.setText("CÓIGO DE BARRAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		// Adiciona o efeito de mudança de cor ao passar o mouse
		rndbtnFecharCaixa.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rndbtnFecharCaixa.setBackground(Color.GRAY); // Cor ao passar o mouse
			}

			public void mouseExited(MouseEvent e) {
				rndbtnFecharCaixa.setBackground(Color.RED); // Cor original
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(47, 57, 155, 23);
		panel_2.add(btnNewButton_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(47, 152, 155, 23);
		panel_2.add(panel_3_1);

		JLabel lblNewLabel_1 = new JLabel("R$ 0,00");
		panel_3_1.add(lblNewLabel_1);

		RoundedButton btnNewButton_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_1.setText("VALOR UNITÁRIO");
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(47, 131, 155, 23);
		panel_2.add(btnNewButton_1_1);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(47, 227, 155, 23);
		panel_2.add(panel_3_2);

		JLabel lblNewLabel_2 = new JLabel("R$ 0,00");
		panel_3_2.add(lblNewLabel_2);

		RoundedButton btnNewButton_1_2 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_2.setText("TOTAL DO IEM");
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(47, 206, 155, 23);
		panel_2.add(btnNewButton_1_2);

		RoundedButton btnNewButton_1_3 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3.setText("CÓDIGO");
		btnNewButton_1_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3.setBounds(47, 278, 155, 23);
		panel_2.add(btnNewButton_1_3);

		RoundedButton btnNewButton_1_3_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1.setText("SUBTOTAL");
		btnNewButton_1_3_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1.setBounds(294, 331, 486, 23);
		panel_2.add(btnNewButton_1_3_1);

		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBackground(Color.WHITE);
		panel_3_3_1.setBounds(294, 354, 486, 23);
		panel_2.add(panel_3_3_1);

		JLabel lblNewLabel_4 = new JLabel("R$:0,00");
		panel_3_3_1.add(lblNewLabel_4);

		RoundedButton btnNewButton_1_3_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_1.setText("TOTAL RECEBIDO");
		btnNewButton_1_3_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1_1.setBounds(345, 399, 181, 23);
		panel_2.add(btnNewButton_1_3_1_1);

		JPanel panel_3_3_1_1 = new JPanel();
		panel_3_3_1_1.setBackground(Color.WHITE);
		panel_3_3_1_1.setBounds(345, 422, 181, 23);
		panel_2.add(panel_3_3_1_1);

		JLabel lblNewLabel_5 = new JLabel("R$:0,00");
		panel_3_3_1_1.add(lblNewLabel_5);

		RoundedButton btnNewButton_1_3_1_1_1 = new RoundedButton("New button", 1, 1);
		btnNewButton_1_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_3_1_1_1.setText("TROCO");
		btnNewButton_1_3_1_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_3_1_1_1.setBounds(536, 399, 186, 23);
		panel_2.add(btnNewButton_1_3_1_1_1);

		JPanel panel_3_3_1_1_1 = new JPanel();
		panel_3_3_1_1_1.setBackground(Color.WHITE);
		panel_3_3_1_1_1.setBounds(536, 422, 186, 23);
		panel_2.add(panel_3_3_1_1_1);

		JLabel lblNewLabel_6 = new JLabel("R$:0,00");
		panel_3_3_1_1_1.add(lblNewLabel_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(247, 57, 582, 263);
		panel_2.add(panel_4);

		String[] columnNames = { "N°item", "codigo ", "Discriçao", "QTD", "valor.unitario", "total" };
		Object[][] data = {};
		panel_4.setLayout(new BorderLayout());

		HintTextField textfield = new HintTextField("000 00000 00000");
		textfield.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) { // Se quiser a tecla Enter
					// evento
					System.out.println("22222");
				}
			}
		});
		textfield.setHorizontalAlignment(SwingConstants.CENTER);

		textfield.setBounds(47, 80, 155, 20);
		panel_2.add(textfield);
		textfield.setColumns(10);

		HintTextField textfield_1 = new HintTextField("00000");
		textfield_1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) { // Se quiser a tecla Enter
					// evento
					System.out.println("22222");
				}
			}
		});
		textfield_1.setHorizontalAlignment(SwingConstants.CENTER);
		textfield_1.setColumns(10);
		textfield_1.setBounds(47, 300, 155, 20);
		panel_2.add(textfield_1);
		table = new JTable(new DefaultTableModel(data, columnNames));
		panel_4.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		panel_4.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 350, 125, 120);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("F3 - Excluir item");
		lblNewLabel.setBounds(10, 35, 95, 14);
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("F5 - Nova Venda");
		lblNewLabel_3.setBounds(10, 85, 95, 14);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("F2 - Puxar Dados");
		lblNewLabel_7.setBounds(10, 10, 107, 14);
		panel_3.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("F4 - Limpar Campo");
		lblNewLabel_8.setBounds(10, 60, 107, 14);
		panel_3.add(lblNewLabel_8);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBounds(184, 350, 100, 120);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

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
