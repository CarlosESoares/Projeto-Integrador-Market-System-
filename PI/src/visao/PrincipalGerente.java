package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerEstoquista;
import Controle.ControllerGerente;
import Controle.ControllerTelaCliente;
import Modelo.ClienteDAO;
import Modelo.ProdutoDAO;

public class PrincipalGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableFuncionario;
	private JTable tableProdutos;
	private JTable tableClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGerente frame = new PrincipalGerente();
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

		public PrincipalGerente() {
		    // Configuração básica da janela
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 1078, 822);

		    // Inicialize o contentPane e defina o layout
		    contentPane = new JPanel();
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(new BorderLayout(0, 0));

		    // Configuração do panel_1 e adição ao contentPane
		    JPanel panel_1 = new JPanel();
		    panel_1.setBackground(Color.LIGHT_GRAY);
		    contentPane.add(panel_1, BorderLayout.WEST);

		    // Redimensionar e configurar o logotipo
		    ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		    Image imageLogo = originalIconLogo.getImage();
		    Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		    ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);

		    // Chamar método para buscar produtos

		    // Outros componentes e configurações...
		    JPanel panel = new JPanel();
		    panel.setBackground(new Color(192, 192, 192));
		    contentPane.add(panel, BorderLayout.WEST);

		    RoundedButton imgLogo = new RoundedButton("", 1, 1);
		    imgLogo.setBackground(new Color(192, 192, 192));
		    imgLogo.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            ControllerTelaCliente abrir = new ControllerTelaCliente();
		            abrir.AbrirTelaInicial();
		            dispose();
		        }
		    });
		    imgLogo.setIcon(ImgRedimencionada);
		    imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		    
		    JButton btnFunciora = new JButton("Funcionarios");
		    btnFunciora.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ControllerGerente tela = new ControllerGerente();
		    		tela.AbrirTelaFunfionario();
		    	}
		    });
		    
		    JButton btnProduto = new JButton("Produto");
		    btnProduto.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		ControllerEstoquista tela = new ControllerEstoquista();
		    		tela.AbrirTelaEstoque();
		    	}
		    });
		    
		    JButton btnCliente = new JButton("Clientes");
		    btnCliente.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
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
		    			.addComponent(btnFunciora))
		    		.addGroup(gl_panel.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(btnProduto))
		    		.addGroup(gl_panel.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(btnCliente))
		    );
		    gl_panel.setVerticalGroup(
		    	gl_panel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_panel.createSequentialGroup()
		    			.addGap(5)
		    			.addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		    			.addGap(18)
		    			.addComponent(btnFunciora)
		    			.addGap(18)
		    			.addComponent(btnProduto)
		    			.addGap(18)
		    			.addComponent(btnCliente)
		    			.addContainerGap(537, Short.MAX_VALUE))
		    );
		    panel.setLayout(gl_panel);

		    // Outros painéis e componentes
		    JPanel panel_2 = new JPanel();
		    contentPane.add(panel_2, BorderLayout.CENTER);
		    panel_2.setLayout(new BorderLayout(0, 0));

		    // Continuação do código para configurar o restante da interface...
		

		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane, 65, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane, 59, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane, 322, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane, 364, SpringLayout.WEST, panel_3);
		panel_3.add(scrollPane);
		
		tableFuncionario = new JTable();
		tableFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Sobrenome", "Telefone", "Cargo"
			}
		));
		scrollPane.setViewportView(tableFuncionario);
		
		JLabel Funcio = new JLabel("Funcionarios");
		sl_panel_3.putConstraint(SpringLayout.NORTH, Funcio, -56, SpringLayout.NORTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, Funcio, 0, SpringLayout.WEST, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, Funcio, -6, SpringLayout.NORTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.EAST, Funcio, 266, SpringLayout.WEST, panel_3);
		Funcio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(Funcio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_1, -257, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_1, 25, SpringLayout.EAST, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_1, 0, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_1, 330, SpringLayout.EAST, scrollPane);
		panel_3.add(scrollPane_1);
			

		String[] columnNames = {"ID", "Nome", "Preço", "Quantidade"};
		Object[][] data = {};
		tableProdutos = new JTable(new DefaultTableModel(data, columnNames));
        buscarProdutos();

		scrollPane_1.setViewportView(tableProdutos);
		
		JLabel lblNewLabel = new JLabel("Produto");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel, -4, SpringLayout.NORTH, Funcio);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel, 133, SpringLayout.EAST, Funcio);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel, -2, SpringLayout.NORTH, scrollPane_1);
		sl_panel_3.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, scrollPane_1);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sl_panel_3.putConstraint(SpringLayout.NORTH, scrollPane_2, 59, SpringLayout.SOUTH, scrollPane);
		sl_panel_3.putConstraint(SpringLayout.WEST, scrollPane_2, 59, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, scrollPane_2, -127, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, scrollPane_2, 92, SpringLayout.EAST, scrollPane);
		panel_3.add(scrollPane_2);
		
		String[] columnNames2 = {"ID", "Nome", "Sobrenome", "CPF",};
		Object[][] data2 = {};
		tableClientes = new JTable(new DefaultTableModel(data2, columnNames2));
		buscarClientes();
		
		
		scrollPane_2.setViewportView(tableClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1, 62, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, scrollPane_2);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_3.add(lblNewLabel_1);
		
	}
		private void buscarProdutos() {
		    try {
		        List<Object[]> produtos = ProdutoDAO.buscarTodosProdutos();  // Recupera a lista de produtos
		        DefaultTableModel model = (DefaultTableModel) tableProdutos.getModel();
		        model.setRowCount(0);  // Limpa a tabela antes de adicionar novos dados
		        
		        // Preenche a tabela com os dados dos produtos
		        for (Object[] produto : produtos) {
		            model.addRow(produto);  // Adiciona uma nova linha à tabela
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
		        e.printStackTrace();
		    }
		}
		
		private void buscarClientes() {
	        try {
	            List<Object[]> clientes = ClienteDAO.buscarTodosClientes();
	            DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
	            model.setRowCount(0);  
	            for (Object[] clientes1 : clientes) {
	                model.addRow(clientes1); 
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes.");
	            e.printStackTrace();
	        }
	    }


}
