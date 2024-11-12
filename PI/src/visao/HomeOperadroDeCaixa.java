package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class HomeOperadroDeCaixa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeOperadroDeCaixa frame = new HomeOperadroDeCaixa();
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
	public HomeOperadroDeCaixa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(171, 171, 171));
		
		RoundedButton btnNewButton_1 = new RoundedButton("consultar vendas",30,30);
		btnNewButton_1.setBackground(new Color(216, 216, 216));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		RoundedButton btnNewButton = new RoundedButton("Consutar estoque",30,30);
		btnNewButton.setText(" iniciar caixa");
		btnNewButton.setBackground(new Color(216, 216, 216));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		RoundedButton btnNewButton_2 = new RoundedButton("Consutar estoque",30,30);
		btnNewButton_2.setBackground(new Color(216, 216, 216));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		RoundedButton btnNewButton_3 = new RoundedButton("<html><div style='text-align:center'>registra pagamento do crédito</div></html>",30,30);
		btnNewButton_3.setVerticalAlignment(SwingConstants.TOP);
		
		btnNewButton_3.setBackground(new Color(216, 216, 216));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(267)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(232, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel imgLogo = new JLabel("");
		panel_1.add(imgLogo);
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel imgLogo_2 = new JLabel("");
		imgLogo_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(imgLogo_2);
		contentPane.setLayout(gl_contentPane);
	}
}
