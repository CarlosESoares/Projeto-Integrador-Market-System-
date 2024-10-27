package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controle.ControleDeLogin;
import Controle.ControllerCadastro;

public class Cadastro_Gerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String tipo_funcionario;

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
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro Funcionário");
		lblNewLabel_1.setBounds(299, 7, 187, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("SVGEM");
		lblNewLabel.setBounds(361, 35, 64, 22);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(160, 68, 106, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(220, 66, 187, 24);
		TextNome.setColumns(10);
		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(159, 113, 30, 18);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCpf = new TextFielArredondada(15,20,20);
		TextCpf.setBounds(220, 111, 187, 24);
		TextCpf.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(160, 163, 42, 18);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSenha = new TextFielArredondada(15,20,20);
		TextSenha.setBounds(220, 161, 187, 24);
		TextSenha.setColumns(10);
		
		JLabel lblFuncao = new JLabel("Função");
		lblFuncao.setBounds(160, 206, 49, 18);
		lblFuncao.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSobrenome = new TextFielArredondada(15, 20, 20);
		TextSobrenome.setColumns(10);
		TextSobrenome.setBounds(522, 66, 187, 24);
		panel_2.add(TextSobrenome);
		
		TextFielArredondada TextTelefone = new TextFielArredondada(15, 20, 20);
		TextTelefone.setColumns(10);
		TextTelefone.setBounds(522, 114, 187, 24);
		panel_2.add(TextTelefone);
		
		TextFielArredondada TextSalario = new TextFielArredondada(15, 20, 20);
		TextSalario.setColumns(10);
		TextSalario.setBounds(522, 161, 187, 24);
		panel_2.add(TextSalario);
		
		TextFielArredondada TextEndereço = new TextFielArredondada(15, 20, 20);
		TextEndereço.setColumns(10);
		TextEndereço.setBounds(522, 207, 187, 24);
		panel_2.add(TextEndereço);
		
		JComboBox<Object> comboFuncao = new JComboBox<Object>();
		comboFuncao.setBounds(220, 206, 187, 20);
		comboFuncao.setModel(new DefaultComboBoxModel<Object>(new String[] {"Selecionar", "Caixa", "Gerente", "Estoquista"}));
		
		RoundedButton Cadastrar = new RoundedButton("Cadastrar",30,30);
		Cadastrar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	Cadastrar.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	Cadastrar.setBackground(Color.RED);
		    }
		});
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomeFuncionario = TextNome.getText();
				String login = TextCpf.getText();
                String senha = TextSenha.getText();
                String sobrenome = TextSobrenome.getText();
                String telefone = TextTelefone.getText();
                String salario = TextSalario.getText();
                String endereco = TextEndereço.getText();
                int op = comboFuncao.getSelectedIndex();
                
                boolean hasLetter = login.chars().anyMatch(ch -> !Character.isDigit(ch));
                boolean hasLetter2 = telefone.chars().anyMatch(ch -> !Character.isDigit(ch));
                boolean hasLetter3 = telefone.chars().anyMatch(ch -> !Character.isDigit(ch));
                
                //Campos para validação
	            if (login.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo CPF não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (login.length() != 11) {
	                JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (hasLetter) {
	                JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (NomeFuncionario.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (senha.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo senha não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (sobrenome.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo sobrenome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }else if (hasLetter2) {
	                JOptionPane.showMessageDialog(null, "O Telefone deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (telefone.length() != 9) {
	                JOptionPane.showMessageDialog(null, "O telefone deve conter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }else if (telefone.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo telefone não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else if (endereco.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo endereço não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }else if (salario.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "O campo salario não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }else if (hasLetter3) {
	                JOptionPane.showMessageDialog(null, "O Salaeio deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	            //Validação do comboBox
                	if(op == 1) {
                		tipo_funcionario = "Caixa";
                	}else if(op == 2){
                		tipo_funcionario = "Gerente";
                	}else if (op == 2) {
                		tipo_funcionario = "Esqoquista";
                	}else {
                		tipo_funcionario = null;
                		JOptionPane.showMessageDialog(null, "Precisa escolher uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
                	}
            
                // testando ainda o cadastro, perdendo a cabeça
                try {
					ControllerCadastro.Controle(NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco);
					System.out.println("Cadastrado"); 
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Erro ao Cadastrar");
				} 
			}
		});
		Cadastrar.setBounds(331, 277, 113, 26);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		Cadastrar.setBackground(new Color(255, 0, 0));
		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNewLabel);
		panel_2.add(lblNome);
		panel_2.add(TextNome);
		panel_2.add(lblCpf);
		panel_2.add(lblSenha);
		panel_2.add(lblFuncao);
		panel_2.add(TextSenha);
		panel_2.add(TextCpf);
		panel_2.add(comboFuncao);
		panel_2.add(Cadastrar);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-132, 277, 1200, 355);
		panel_2.add(imgOndinha);
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSobrenome.setBounds(431, 68, 106, 18);
		panel_2.add(lblSobrenome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefone.setBounds(431, 113, 106, 18);
		panel_2.add(lblTelefone);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSalario.setBounds(431, 163, 106, 18);
		panel_2.add(lblSalario);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereco.setBounds(431, 206, 106, 18);
		panel_2.add(lblEndereco);
		
		RoundedButton Deslogar = new RoundedButton("Cadastrar", 30, 30); // deslogar
		Deslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleDeLogin login = new ControleDeLogin();
            	login.iniciar();
            	dispose();
			}
		});
		Deslogar.setText("Log Off");
		Deslogar.setFont(new Font("Arial", Font.PLAIN, 15));
		Deslogar.setBackground(Color.RED);
		Deslogar.setBounds(783, 7, 113, 26);
		panel_2.add(Deslogar);
		
		
	}
}
