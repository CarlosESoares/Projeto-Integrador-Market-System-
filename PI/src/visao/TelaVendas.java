	package visao;
	
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import Modelo.Funcionario;
	
	public class TelaVendas extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTable table;
		private static TelaVendas frame;
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						 frame = new TelaVendas(null);
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
			
			public TelaVendas(Funcionario f) {
			    // Configurações da janela
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setBounds(100, 100, 1000, 598);
	
			    // Inicialização do contentPane
			    contentPane = new JPanel();
			    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			    setContentPane(contentPane);
			    contentPane.setLayout(new BorderLayout(0, 0));
	
			    JPanel panel_1 = new JPanel();
			    panel_1.setBackground(Color.LIGHT_GRAY);
			    contentPane.add(panel_1, BorderLayout.WEST);
			    
			    ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
			    Image imageLogo = originalIconLogo.getImage(); // Obtenha a imagem do ImageIcon
			    Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensione a imagem
			    ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
	
			    JPanel panel = new JPanel();
			    panel.setBackground(new Color(192, 192, 192));
			    contentPane.add(panel, BorderLayout.WEST);
	
			    RoundedButton imgLogo = new RoundedButton("", 1, 1);
			    imgLogo.setBackground(new Color(192, 192, 192));
			    imgLogo.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            ControllerGerente.TelaGerente(f);
			            dispose();
			        }
			    });
			    imgLogo.setIcon(ImgRedimencionada);
			    imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
			    
			    JButton btnNewButton = new JButton("Funcionarios");
			    btnNewButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		ControllerGerente.TelaGerente(f);
			    		frame.dispose();
			    	}
			    });
			    
			    JButton btnNewButton_1 = new JButton("Vendas");
			    	
			    
			    JButton btnNewButton_2 = new JButton("Estoque");
			    btnNewButton_2.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		ControllerGerente abrir = new ControllerGerente();
			    		abrir.AbrirTelaEstoque(f);
			    		frame.dispose();
			    	}
			    });
	
			    GroupLayout gl_panel = new GroupLayout(panel);
			    gl_panel.setHorizontalGroup(
			    	gl_panel.createParallelGroup(Alignment.LEADING)
			    		.addGroup(gl_panel.createSequentialGroup()
			    			.addGap(5)
			    			.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			    		.addGroup(gl_panel.createSequentialGroup()
			    			.addContainerGap()
			    			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
			    				.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    				.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    				.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			    );
			    gl_panel.setVerticalGroup(
			    	gl_panel.createParallelGroup(Alignment.LEADING)
			    		.addGroup(gl_panel.createSequentialGroup()
			    			.addGap(5)
			    			.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			    			.addGap(18)
			    			.addComponent(btnNewButton)
			    			.addGap(18)
			    			.addComponent(btnNewButton_1)
			    			.addGap(18)
			    			.addComponent(btnNewButton_2)
			    			.addContainerGap(313, Short.MAX_VALUE))
			    );
			    panel.setLayout(gl_panel);
	
			    JPanel panel_2 = new JPanel();
			    contentPane.add(panel_2, BorderLayout.CENTER);
	
			    JScrollPane scrollPane = new JScrollPane();
			    GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			    gl_panel_2.setHorizontalGroup(
			        gl_panel_2.createParallelGroup(Alignment.LEADING)
			            .addGroup(gl_panel_2.createSequentialGroup()
			                .addContainerGap()
			                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
			                .addContainerGap(208, Short.MAX_VALUE))
			    );
			    gl_panel_2.setVerticalGroup(
			        gl_panel_2.createParallelGroup(Alignment.LEADING)
			            .addGroup(gl_panel_2.createSequentialGroup()
			                .addContainerGap()
			                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
			                .addContainerGap(150, Short.MAX_VALUE))
			    );
	
			    table = new JTable();
			    table.setModel(new DefaultTableModel(
			        new Object[][] {},
			        new String[] {
			            "ID da venda", "id Funcionario", "valor", "Tipo do pagamento", "New column"
			        }
			    ));
			    
			    // Adiciona um listener para cliques na tabela
			    table.addMouseListener(new MouseAdapter() {
			        @Override
			        public void mouseClicked(MouseEvent e) {
			            if (e.getClickCount() == 1) { // clique simples
			                int row = table.getSelectedRow(); // obtém a linha selecionada
			                if (row != -1) {
			                    // A linha foi clicada - abre a tela de Relatório
			                    RelatorioVenda relatorioVenda = new RelatorioVenda();
			                    relatorioVenda.setVisible(true);
			                    dispose(); // opcional: fecha a TelaVendas
			                }
			            }
			        }
			    });
	
			    scrollPane.setViewportView(table);
			    panel_2.setLayout(gl_panel_2);
			}
	}
