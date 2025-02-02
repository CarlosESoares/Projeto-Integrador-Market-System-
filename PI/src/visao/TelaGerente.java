package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.ControllerGerente;
import Modelo.Funcionario;

public class TelaGerente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TelaGerente frame = new TelaGerente(null);
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaGerente(Funcionario f) {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,500,500); 
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Gerentes");
		lblNewLabel.setBounds(154, 22, 179, 47);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		panel_2.add(lblNewLabel);

		
		RoundedButton Btnfuncionarios = new RoundedButton("Entrar",30,30);
		Btnfuncionarios.setText("Funcionarios");
		Btnfuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								frame.dispose();
				
				ControllerGerente.TelaCadastro(f);
				

			}
		});
		Btnfuncionarios.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	Btnfuncionarios.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	Btnfuncionarios.setBackground(Color.RED);
		    }
		});
		Btnfuncionarios.setBounds(154, 92, 179, 32);
	
		
		Btnfuncionarios.setBackground(new Color(255, 0, 0));
		Btnfuncionarios.setForeground(new Color(255, 255, 255));
		Btnfuncionarios.setFont(new Font("Arial", Font.BOLD, 20));
		Btnfuncionarios.setBackground(new Color(255, 0, 0));
		panel_2.add(Btnfuncionarios);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-86, 314, 729, 342);
		panel_2.add(imgOndinha);
		imgOndinha.setIcon(new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png")));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setBackground(Color.LIGHT_GRAY);
		
		
		RoundedButton estoqueBtn = new RoundedButton("Estoque", 30, 30);
		estoqueBtn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	estoqueBtn.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	estoqueBtn.setBackground(Color.RED);
		    }
		});
		estoqueBtn.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {
		    	ControllerGerente abrir = new ControllerGerente();
		        
		        frame.dispose();
		        abrir.AbrirTelaEstoque(f);
		    }
		});
		estoqueBtn.setForeground(Color.WHITE);
		estoqueBtn.setFont(new Font("Arial", Font.BOLD, 20));
		estoqueBtn.setBackground(Color.RED);
		estoqueBtn.setBounds(154, 178, 179, 32);
		panel_2.add(estoqueBtn);

		RoundedButton telaInicialBTN = new RoundedButton("Tela Inicial", 30, 30);
		telaInicialBTN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ControllerGerente.AbrirTelaInicial(f);
		    }
		});
		telaInicialBTN.setForeground(Color.WHITE);
		telaInicialBTN.setFont(new Font("Arial", Font.BOLD, 20));
		telaInicialBTN.setBackground(Color.RED);
		telaInicialBTN.setBounds(154, 221, 179, 32);
		panel_2.add(telaInicialBTN);
		
		RoundedButton btnNewButton = new RoundedButton("Re", 30,30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGerente abrir = new ControllerGerente();
				abrir.abrirTelaResumo(f);
			}
		});
		btnNewButton.setText("Resumo");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(154, 265, 179, 38);
		panel_2.add(btnNewButton);

		telaInicialBTN.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		        telaInicialBTN.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		        telaInicialBTN.setBackground(Color.RED);
		    }
		});
		}
}
