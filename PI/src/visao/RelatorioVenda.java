package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;

public class RelatorioVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
		private JTable tableRelatorio;
		static RelatorioVenda frame = new RelatorioVenda();
	/**
	 * Launch the application.
	 */
	
	public RelatorioVenda() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, BorderLayout.WEST);
		RoundedButton imgLogo = new RoundedButton("",1,1);
		imgLogo.setBackground(new Color(192, 192, 192));
		panel.add(imgLogo, "cell 0 0");
		imgLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGerente abrir = new ControllerGerente();
				abrir.TelaInicial();
				dispose();
			}
		});
		imgLogo.setIcon(ImgRedimencionada);
		
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Proxima Venda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("relatorio");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(306)
					.addComponent(lblNewLabel)
					.addGap(284)
					.addComponent(btnNewButton)
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE)
					.addGap(137))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		
		 tableRelatorio = new JTable();
		tableRelatorio.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] {
		        "ID da venda", "id Funcionario", "Produtos", "valor", "Quantidade", "Total"
		    }
		));
		
		scrollPane.setViewportView(tableRelatorio);
		panel_2.setLayout(gl_panel_2);
	}

}
