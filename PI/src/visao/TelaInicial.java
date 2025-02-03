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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controle.ControleDeLogin;
import Controle.ControllerGerente;

import Modelo.Funcionario;


public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial(null);
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
    public TelaInicial(Funcionario f) {
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
        Image image = originalIcon.getImage();
        Image newImage = image.getScaledInstance(1200, 200, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(newImage);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel_1, BorderLayout.WEST);
        
        
		RoundedButton btnNewButton = new RoundedButton("",1,1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        
        
        btnNewButton.setBackground(Color.LIGHT_GRAY);
		ImageIcon originalIconLogo2 = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo2 = originalIconLogo2.getImage(); 
		Image NovaLogo2 = imageLogo2.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada2 = new ImageIcon(NovaLogo2);
		btnNewButton.setIcon(ImgRedimencionada2);

        panel_1.add(btnNewButton);
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        
        JLabel Titulo = new JLabel("HOME");
        Titulo.setBounds(367, 11, 187, 30);
        Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JLabel imgOndinha = new JLabel("");
        imgOndinha.setBounds(-12, 260, 1200, 355);
        imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
        imgOndinha.setIcon(resizedIcon);

        ImageIcon clienteIcon = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
        Image clienteImage = clienteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedClienteIcon = new ImageIcon(clienteImage);


        RoundedButton btnCliente = new RoundedButton("Tela_Cliente", 30, 30);
        btnCliente.setVisible(false);
        btnCliente.setHorizontalAlignment(SwingConstants.LEFT);
        btnCliente.setText("  Clientes");
        btnCliente.setForeground(new Color(255, 255, 255));
        btnCliente.setBackground(new Color(255, 0, 0));
        btnCliente.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCliente.setIcon(resizedClienteIcon);
        btnCliente.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnCliente.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                btnCliente.setBackground(Color.RED);
            }
        });
        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ControllerGerente abrir = new ControllerGerente();
                abrir.AbrirTelaCliente(f);
                dispose();
            }
        });
        btnCliente.setBounds(306, 45, 187, 66);
        panel_2.setLayout(null);
        panel_2.add(imgOndinha);
        panel_2.add(btnCliente);
        panel_2.add(Titulo);

        ImageIcon estoqueIcon = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
        Image estoqueImage = estoqueIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedEstoqueIcon = new ImageIcon(estoqueImage);

        RoundedButton btnEstoque = new RoundedButton("Tela_Estoque", 30, 30);
        btnEstoque.setVisible(false);
        btnEstoque.setHorizontalAlignment(SwingConstants.LEFT);
        btnEstoque.setForeground(Color.WHITE);
        btnEstoque.setText("  Estoque");
        btnEstoque.setFont(new Font("Arial", Font.PLAIN, 20));
        btnEstoque.setBackground(new Color(255, 0, 0));
        btnEstoque.setIcon(resizedEstoqueIcon);

        btnEstoque.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnEstoque.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                btnEstoque.setBackground(Color.RED);
            }
        });
        btnEstoque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ControllerGerente abrir = new ControllerGerente();
                abrir.AbrirTelaEstoque(f);
                dispose();
            }
        });
        btnEstoque.setBounds(563, 45, 187, 66);
        panel_2.add(btnEstoque);

        ImageIcon vendasIcon = new ImageIcon(getClass().getResource("/Imagens/comments-dollar-solid.png"));
        Image vendasImage = vendasIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedVendasIcon = new ImageIcon(vendasImage);


        ImageIcon caixaIcon = new ImageIcon(getClass().getResource("/Imagens/desktop-solid.png"));
        Image caixaImage = caixaIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedCaixaIcon = new ImageIcon(caixaImage);

        RoundedButton btnCaixa = new RoundedButton("Tela_Caixa", 30, 30);
        btnCaixa.setVisible(false);
        btnCaixa.setHorizontalAlignment(SwingConstants.LEFT);
        btnCaixa.setText("  Caixa");
        btnCaixa.setForeground(new Color(255, 255, 255));
        btnCaixa.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCaixa.setBackground(new Color(255, 0, 0));
        btnCaixa.setIcon(resizedCaixaIcon);
        btnCaixa.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnCaixa.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                btnCaixa.setBackground(Color.RED);
            }
        });
        btnCaixa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ControllerGerente abrir = new ControllerGerente();
                abrir.AbrirTelaCaixa(f);
                dispose();
            }
        });
        btnCaixa.setBounds(306, 171, 187, 66);
        panel_2.add(btnCaixa);
        ImageIcon LogoutIcon = new ImageIcon(getClass().getResource("/Imagens/left-from-backet.png"));
        Image LogoutImagem = LogoutIcon.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoutIcon = new ImageIcon(LogoutImagem);
        
        RoundedButton rndbtnLo = new RoundedButton("Tela_Estoque", 30, 30);
        rndbtnLo.setHorizontalAlignment(SwingConstants.LEFT);
        rndbtnLo.setForeground(Color.WHITE);
        rndbtnLo.setIcon(resizedLogoutIcon);
		rndbtnLo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControleDeLogin login = new ControleDeLogin();
            	login.iniciar();
            	dispose();
			}
		});
		rndbtnLo.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            	rndbtnLo.setBackground(Color.LIGHT_GRAY);
	            }
	            public void mouseExited(MouseEvent e) {
	            	rndbtnLo.setBackground(Color.RED);
	            }
	        });
		rndbtnLo.setText("Log off");
		rndbtnLo.setFont(new Font("Arial", Font.PLAIN, 12));
		rndbtnLo.setBackground(Color.RED);
		rndbtnLo.setBounds(743, 17, 109, 24);
		panel_2.add(rndbtnLo);
		
		RoundedButton btnFuncionários = new RoundedButton("Tela_Vendas", 30, 30);
		btnFuncionários.setIcon(resizedClienteIcon);
		btnFuncionários.setVisible(false);
		btnFuncionários.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            	btnFuncionários.setBackground(Color.LIGHT_GRAY);
	            }
	            public void mouseExited(MouseEvent e) {
	            	btnFuncionários.setBackground(Color.RED);
	            }
	        });
		btnFuncionários.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								dispose();
				
				ControllerGerente.TelaCadastro(f);
				

			}
		});
		 

		
			
		btnFuncionários.setText("Funcionários");
		btnFuncionários.setHorizontalAlignment(SwingConstants.LEFT);
		btnFuncionários.setForeground(Color.WHITE);
		btnFuncionários.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFuncionários.setBackground(Color.RED);
		btnFuncionários.setBounds(50, 45, 187, 66);
		panel_2.add(btnFuncionários);
		
		
		ImageIcon ResumoIcon = new ImageIcon(getClass().getResource("/Imagens/book-solid.png"));
        Image ResumoImagem = ResumoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedResumoIcon = new ImageIcon(ResumoImagem);
		RoundedButton rndbtnResumo = new RoundedButton("Tela_Vendas", 30, 30);
		
		rndbtnResumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerGerente abrir = new ControllerGerente();
				abrir.abrirTelaResumo(f);
				dispose();
			}
		});
		rndbtnResumo.setText("Resumo");
		rndbtnResumo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	rndbtnResumo.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
            	rndbtnResumo.setBackground(Color.RED);
            }
        });
		rndbtnResumo.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnResumo.setForeground(Color.WHITE);
		rndbtnResumo.setIcon(resizedResumoIcon);
		rndbtnResumo.setFont(new Font("Arial", Font.PLAIN, 20));
		rndbtnResumo.setBackground(Color.RED);
		rndbtnResumo.setBounds(50, 171, 187, 66);
		rndbtnResumo.setVisible(false);
		panel_2.add(rndbtnResumo);
		
		
		
		String tipoFuncionario = f.getTipoFucionario();
		
		   if (tipoFuncionario != null) {
	            if (tipoFuncionario.equals("Caixa")) {
	            	btnCaixa.setVisible(true);
	            	btnCliente.setVisible(true);
	            } else if (tipoFuncionario.equals("Gerente")) {
	            	btnCaixa.setVisible(true);
	            	btnCliente.setVisible(true);
	            	btnEstoque.setVisible(true);
	
	            	btnFuncionários.setVisible(true);
	            	rndbtnResumo.setVisible(true);
	            } else {
	               
	                btnEstoque.setVisible(true);

	            }
	            
	        }

	    
    }
    
 
}
