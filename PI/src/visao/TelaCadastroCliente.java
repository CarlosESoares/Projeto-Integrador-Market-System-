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
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerEstoquista;
import Controle.ControllerTelaCliente;
import Modelo.ClienteDAO;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ClienteDAO clienteDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		clienteDAO = new ClienteDAO();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Imagens/Ondinha23.png"));
		Image image = originalIcon.getImage(); 
		Image newImage = image.getScaledInstance(1400, 100, Image.SCALE_SMOOTH); 
		
		ImageIcon resizedIcon = new ImageIcon(newImage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.WEST);

		RoundedButton imgLogo = new RoundedButton("", 1, 1);
		imgLogo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ControllerEstoquista abrir = new ControllerEstoquista();
		        abrir.AbrirTelaInicial();
		        dispose();
		    }
		});
		imgLogo.setBackground(Color.LIGHT_GRAY);
		imgLogo.setForeground(Color.LIGHT_GRAY);
		ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
		Image imageLogo = originalIconLogo.getImage(); 
		Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
		ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
		imgLogo.setIcon(ImgRedimencionada);
		imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);

		// Botão Produtos
		RoundedButton rndbtnHomeProdutos = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnHomeProdutos.setForeground(new Color(255, 255, 255));
		rndbtnHomeProdutos.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		        rndbtnHomeProdutos.setBackground(Color.GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		        rndbtnHomeProdutos.setBackground(Color.RED);
		    }
		});
		rndbtnHomeProdutos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ControllerTelaCliente abrir = new ControllerTelaCliente();
		        abrir.AbrirTelaEstoque();
		        dispose();
		    }
		});
		rndbtnHomeProdutos.setText("Estoque");
		rndbtnHomeProdutos.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeProdutos.setBackground(Color.RED);

		// Adicionando ícone ao botão Produtos
		ImageIcon iconProdutos = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
		Image imgProdutos = iconProdutos.getImage();
		Image novaImgProdutos = imgProdutos.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeProdutos.setIcon(new ImageIcon(novaImgProdutos));

		// Botão Clientes
		RoundedButton rndbtnHomeClientes = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeClientes.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnHomeClientes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Adicionar ação aqui
		    }
		});
		rndbtnHomeClientes.setText("Clientes");
		rndbtnHomeClientes.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeClientes.setBackground(Color.GRAY);

		// Adicionando ícone ao botão Clientes
		ImageIcon iconClientes = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
		Image imgClientes = iconClientes.getImage();
		Image novaImgClientes = imgClientes.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeClientes.setIcon(new ImageIcon(novaImgClientes));

		// Botão Vendas
		RoundedButton rndbtnHomeVendas = new RoundedButton("Cadastrar", 30, 30);
		rndbtnHomeVendas.setHorizontalAlignment(SwingConstants.LEFT);
		rndbtnHomeVendas.setForeground(new Color(255, 255, 255));
		rndbtnHomeVendas.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		        rndbtnHomeVendas.setBackground(Color.GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		        rndbtnHomeVendas.setBackground(Color.RED);
		    }
		});
		rndbtnHomeVendas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Adicionar ação aqui
		    }
		});
		rndbtnHomeVendas.setText("Vendas");
		rndbtnHomeVendas.setFont(new Font("Arial", Font.PLAIN, 11));
		rndbtnHomeVendas.setBackground(Color.RED);

		// Adicionando ícone ao botão Vendas
		ImageIcon iconVendas = new ImageIcon(getClass().getResource("/Imagens/comments-dollar-solid.png"));
		Image imgVendas = iconVendas.getImage();
		Image novaImgVendas = imgVendas.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		rndbtnHomeVendas.setIcon(new ImageIcon(novaImgVendas));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
		    gl_panel_1.createParallelGroup(Alignment.TRAILING)
		        .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(12, Short.MAX_VALUE))
		        .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(12, Short.MAX_VALUE))
		        .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(rndbtnHomeVendas, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(12, Short.MAX_VALUE))
		        .addGroup(gl_panel_1.createSequentialGroup()
		            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		            .addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
		    gl_panel_1.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_panel_1.createSequentialGroup()
		            .addContainerGap()
		            .addComponent(imgLogo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(rndbtnHomeProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(rndbtnHomeClientes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(rndbtnHomeVendas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
		            .addContainerGap(284, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de cliente");
		lblNewLabel_1.setBounds(185, 0, 182, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(9, 71, 116, 18);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextNome = new TextFielArredondada(15,20,20);
		TextNome.setBounds(10, 104, 187, 24);
		TextNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Sobrenome:");
		lblTipo.setBounds(10, 139, 105, 18);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextSobrenome = new TextFielArredondada(15,20,20);
		TextSobrenome.setBounds(10, 165, 187, 24);
		TextSobrenome.setColumns(10);
		
		JLabel lblChegada = new JLabel("CPF:");
		lblChegada.setBounds(10, 200, 115, 18);
		lblChegada.setFont(new Font("Arial", Font.PLAIN, 15));
		
		TextFielArredondada TextCPF = new TextFielArredondada(15,20,20);
		TextCPF.setBounds(10, 229, 187, 24);
		TextCPF.setColumns(10);
		
		RoundedButton rndbtnExcluir = new RoundedButton("Cadastrar", 30, 30);
		rndbtnExcluir.setForeground(new Color(255, 255, 255));
		rndbtnExcluir.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnExcluir.setBackground(Color.LIGHT_GRAY);
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnExcluir.setBackground(Color.RED);
		    }
		});
		rndbtnExcluir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            int idcliente = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
		            
		            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
		            if (confirm == JOptionPane.YES_OPTION) {
		                try {
		                    boolean sucesso = ClienteDAO.excluircliente(idcliente);
		                    if (sucesso) {
		                 
		                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
		                        JOptionPane.showMessageDialog(null, "cliente excluído com sucesso!");
		                        TextNome.setText("");
		   	                 TextSobrenome.setText("");
		   	                 TextCPF.setText("");
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Falha ao excluir o cliente.");
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente: " + ex.getMessage());
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
		        }
		    }

		});
		rndbtnExcluir.setBounds(255, 396, 150, 26);
		rndbtnExcluir.setText("Excluir");
		rndbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnExcluir.setBackground(Color.RED);
		RoundedButton rndbtnEditar = new RoundedButton("Cadastrar", 30, 30);
		rndbtnEditar.setForeground(new Color(255, 255, 255));
		rndbtnEditar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnEditar.setBackground(Color.LIGHT_GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnEditar.setBackground(Color.RED);
		    }
		});
		
		rndbtnEditar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {

		            int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
		            String nome = TextNome.getText();
		            String sobrenome = TextSobrenome.getText();
		            String CPF = TextCPF.getText();

		            boolean success = ClienteDAO.atualizarcliente(id, nome, sobrenome, CPF);

					if (success) {
					    table.setValueAt(nome, selectedRow, 1);
					    table.setValueAt(sobrenome, selectedRow, 2);
					    table.setValueAt(CPF, selectedRow, 3);
					    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
					    buscarClientes();
					       TextNome.setText("");
			                 TextSobrenome.setText("");
			                 TextCPF.setText("");
					} else {
					    JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente.");
					}
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
		        }
		    }
		});

		rndbtnEditar.setBounds(523, 396, 150, 26);
		rndbtnEditar.setText("Editar");
		rndbtnEditar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnEditar.setBackground(Color.RED);
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(224, 58, 486, 195);
		
		

		String[] columnNames = {"ID", "Nome", "Sobrenome", "CPF",};
		Object[][] data = {};
		table = new JTable(new DefaultTableModel(data, columnNames));

		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            TextNome.setText(table.getValueAt(selectedRow, 1).toString());
		            TextSobrenome.setText(table.getValueAt(selectedRow, 2).toString());
		            TextCPF.setText(table.getValueAt(selectedRow, 3).toString());
		        }
		    }
		});
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(scrollPane, BorderLayout.CENTER);



        buscarClientes();
		RoundedButton rndbtnCadastrar = new RoundedButton("Cadastrar",30,30);
		rndbtnCadastrar.setForeground(new Color(255, 255, 255));
		rndbtnCadastrar.setBounds(10, 396, 150, 26);
		rndbtnCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
		rndbtnCadastrar.setBackground(new Color(255, 0, 0));
		rndbtnCadastrar.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	rndbtnCadastrar.setBackground(Color.LIGHT_GRAY); 
		    }
		    public void mouseExited(MouseEvent e) {
		    	rndbtnCadastrar.setBackground(Color.RED);
		    }
		});
		rndbtnCadastrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String CPF1 = TextCPF.getText();
                boolean hasLetter = CPF1.chars().anyMatch(ch -> !Character.isDigit(ch));
		    	 if (TextNome.getText().trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Erro", JOptionPane.ERROR_MESSAGE);
	                }
		    	  if   (TextSobrenome.getText().trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Preencha o campo Sobrenome", "Erro", JOptionPane.ERROR_MESSAGE);
	                }
	                 if   (TextCPF.getText().trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Preencha o campo CPF", "Erro", JOptionPane.ERROR_MESSAGE);
	  
	                }
	           
	                 else if  (CPF1.length() != 11) {
		                JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
		            } else if   (hasLetter) {
		                JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
		            }
	                else {
	             String nome = TextNome.getText();
	                String Sobrenome = TextSobrenome.getText();
	                String CPF = TextCPF.getText();
	                
	               
	               
	            
	                try {
	                    ClienteDAO.cadastrarCliente(nome, Sobrenome, CPF);
	                    JOptionPane.showMessageDialog(null, "cliente cadastrado com sucesso!");
	                    buscarClientes(); 
	                } catch (SQLException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente.");
	                    ex.printStackTrace();
	                }
	                }

	                 TextNome.setText("");
	                 TextSobrenome.setText("");
	                 TextCPF.setText("");
	            }
	        });


		panel_2.setLayout(null);
		panel_2.add(lblNewLabel_1);
		panel_2.add(lblNome);
		panel_2.add(lblTipo);
		panel_2.add(TextNome);
		panel_2.add(TextSobrenome);
		panel_2.add(TextCPF);
		panel_2.add(lblChegada);
		panel_2.add(rndbtnCadastrar);
		panel_2.add(rndbtnExcluir);
		panel_2.add(rndbtnEditar);
		panel_2.add(panel_3);
		
		JLabel imgOndinha = new JLabel("");
		imgOndinha.setBounds(-25, 433, 866, 100);
		panel_2.add(imgOndinha);
		imgOndinha.setBackground(new Color(192, 192, 192));
		imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		imgOndinha.setIcon(resizedIcon);
		


}
	private void buscarClientes() {
        try {
            List<Object[]> clientes = ClienteDAO.buscarTodosClientes();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
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