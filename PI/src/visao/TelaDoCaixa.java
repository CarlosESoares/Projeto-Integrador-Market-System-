package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Controle.ControllerGerente;
import Modelo.Funcionario;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import java.util.Arrays;

public class TelaDoCaixa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static JTable table_1;
    public HintTextField quantidade_produto;
    public static JLabel lblSubTotal;
    public double subT;
    public double  SubSoma;
    public double SubValor1;
    public double SubValor2;
    private DefaultTableModel model;
    public String valorTotalIten;

    public String subtV;
    private JTextField TxtTroco;
    /**
     * 
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	TelaDoCaixa frame = new TelaDoCaixa(null);
  frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

  
    public TelaDoCaixa(Funcionario f) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1042, 536);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

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
            	ControllerGerente abrir = new ControllerGerente();
				abrir.AbrirTelaInicial(f);
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
        // Adiciona o efeito de mudança de cor ao passar o mouse
        rndbtnFecharCaixa.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                rndbtnFecharCaixa.setBackground(Color.GRAY); // Cor ao passar o mouse
            }

            public void mouseExited(MouseEvent e) {
                rndbtnFecharCaixa.setBackground(Color.RED); // Cor original
            }
        });

        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBackground(Color.WHITE);
        panel_3_2.setBounds(47, 80, 155, 23);
        panel_2.add(panel_3_2);

        JLabel lblTotal = new JLabel("0.00");
        panel_3_2.add(lblTotal);
       // proco = lblNewLabel_2; // Atribuindo para uso futuro

        RoundedButton btnNewButton_1_2 = new RoundedButton("New button", 1, 1);
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1_2.setText("TOTAL DO ITEM");
        btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_2.setBounds(47, 57, 155, 23);
        panel_2.add(btnNewButton_1_2);

        RoundedButton btnNewButton_1_3 = new RoundedButton("New button", 1, 1);
        btnNewButton_1_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_3.setText("CÓDIGO");
        btnNewButton_1_3.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_3.setBounds(47, 130, 155, 23);
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

         lblSubTotal = new JLabel("");
        panel_3_3_1.add(lblSubTotal);

        RoundedButton btnNewButton_1_3_1_1 = new RoundedButton("New button", 1, 1);
        btnNewButton_1_3_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_3_1_1.setText("TOTAL RECEBIDO");
        btnNewButton_1_3_1_1.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_3_1_1.setBounds(345, 399, 181, 23);
        panel_2.add(btnNewButton_1_3_1_1);

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

        JLabel lblTroco = new JLabel("R$:0,00");
        panel_3_3_1_1_1.add(lblTroco);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(247, 57, 582, 263);
        panel_2.add(panel_4);

        panel_4.setLayout(new BorderLayout());

        HintTextField TxtCodigoProduto = new HintTextField("00000");
     
        TxtCodigoProduto.setHorizontalAlignment(SwingConstants.CENTER);
        TxtCodigoProduto.setColumns(10);
        TxtCodigoProduto.setBounds(47, 152, 155, 20);
        panel_2.add(TxtCodigoProduto);
       

        
        
        // Tabela de produtos
        table_1 = new JTable();
        model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "NDProduto", "Tipo", "DataChegada", "Preço", "Validade", "Quantidade"
            }
        );
        table_1.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(50, 50, 700, 250);
        panel_4.add(scrollPane, BorderLayout.NORTH);
        

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(192, 192, 192));
        panel_3.setBounds(0, 369, 125, 117);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel = new JLabel("F3 - Excluir item");
        lblNewLabel.setBounds(10, 36, 95, 14);
        panel_3.add(lblNewLabel);

        JLabel lblNewLabel_3 = new JLabel("F5 - Fechar venda");
        lblNewLabel_3.setBounds(10, 86, 95, 14);
        panel_3.add(lblNewLabel_3);

        JLabel lblNewLabel_7 = new JLabel("F2 - Puxar Dados");
        lblNewLabel_7.setBounds(10, 11, 107, 14);
        panel_3.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("F4 - Limpar Campo");
        lblNewLabel_8.setBounds(10, 61, 107, 14);
        panel_3.add(lblNewLabel_8);
        

        RoundedButton btnDoCliente = new RoundedButton("New button", 1, 1);
        btnDoCliente.setText("Cpf do cliente");
        btnDoCliente.setBackground(Color.LIGHT_GRAY);
        btnDoCliente.setBounds(47, 266, 155, 23);
        panel_2.add(btnDoCliente);
        
        HintTextField TxtCPF = new HintTextField("00000");
        TxtCPF.setHorizontalAlignment(SwingConstants.CENTER);
        TxtCPF.setColumns(10);
        TxtCPF.setBounds(47, 287, 155, 20);
        panel_2.add(TxtCPF);
        
        RoundedButton btnNewButton_1_3_2 = new RoundedButton("New button", 1, 1);
        btnNewButton_1_3_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1_3_2.setText("Quantidade");
        btnNewButton_1_3_2.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1_3_2.setBounds(47, 199, 155, 23);
        panel_2.add(btnNewButton_1_3_2);
        
         quantidade_produto= new HintTextField("1");
         quantidade_produto.setHorizontalAlignment(SwingConstants.CENTER);
         quantidade_produto.setColumns(10);
         quantidade_produto.setBounds(47, 221, 155, 20);
        panel_2.add(         quantidade_produto);
        
        RoundedButton BtnFecharVenda = new RoundedButton("ABRIR CAIXA", 30, 30);
        BtnFecharVenda.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	BtnFecharVenda.setBackground(Color.LIGHT_GRAY);
		    }});
        BtnFecharVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = model.getRowCount();
                int colCount = model.getColumnCount();

                Object[][] tabelaDados = new Object[rowCount][colCount];

                // Capturando os dados da tabela
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < colCount; j++) {
                        tabelaDados[i][j] = model.getValueAt(i, j);
                    }
                }
               
                long CpfCliente = 0;

             // Verifica se o valor inserido é o valor de ajuda
             if (!TxtCPF.getText().trim().equals("00000")) {
            	 try {
            		    String cpfTexto = TxtCPF.getText().trim().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos

            		    if (cpfTexto.isEmpty()) {
            		        System.out.println("Erro: O campo CPF está vazio.");
            		    } else {
            		        CpfCliente = Long.parseLong(cpfTexto);
            		        System.out.println("CPF válido: " + CpfCliente);
            		    }
            		} catch (NumberFormatException e1) {
            		    System.out.println("Erro: CPF inválido. Digite apenas números.");
            		}
                
                
                
                ControllerGerente controller = new ControllerGerente();
               
                controller.CadastrarVenda(table_1,CpfCliente,f);
                // Exibindo os dados no console
                for (Object[] row : tabelaDados) {
                    System.out.println(Arrays.toString(row));
                }
             }
            
            
             new MensagemView("Venda finalizada com sucesso",0);
        }});
        BtnFecharVenda.setBounds(135, 369, 130, 24);
        panel_2.add(BtnFecharVenda);
        BtnFecharVenda.setText("Fechar Venda");
        BtnFecharVenda.setForeground(Color.WHITE);
        BtnFecharVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
        BtnFecharVenda.setBackground(Color.RED);
        
        RoundedButton rndbtnLimparATabela = new RoundedButton("ABRIR CAIXA", 30, 30);
        rndbtnLimparATabela.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limparTabela();
        	}
        });
        rndbtnLimparATabela.setText("Limpar a tabela");
        rndbtnLimparATabela.setForeground(Color.WHITE);
        rndbtnLimparATabela.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rndbtnLimparATabela.setBackground(Color.RED);
        rndbtnLimparATabela.setBounds(135, 398, 130, 24);
        panel_2.add(rndbtnLimparATabela);
        
        TxtTroco = new JTextField();
        TxtTroco.setBounds(345, 422, 181, 23);
        panel_2.add(TxtTroco);
        TxtTroco.setColumns(10);
        
        
               
        
       
        TxtCodigoProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F2) { 
                    String idProduto = TxtCodigoProduto.getText(); 
                    Integer quantida = 0;
                    String quantidadeText = quantidade_produto.getText();  
                    
                    if (!quantidadeText.isEmpty()) {
                        try {
                            quantida = Integer.parseInt(quantidadeText);  
                        } catch (NumberFormatException ex) {
                            System.out.println("Quantidade inválida: " + ex.getMessage());
                        }
                    } else {
                        System.out.println("Campo de quantidade vazio.");
                    }

                    if (!idProduto.isEmpty() && quantida > 0) {
                        ControllerGerente controllerGerente = new ControllerGerente();
						subtV =String.valueOf(controllerGerente.buscarProdutoPeloIdCaixa(idProduto, quantidadeText, subT));
						SubValor1 = Double.valueOf(subtV);
						SubValor2 = Double.valueOf(subtV);
						valorTotalIten = String.valueOf(SubValor2);
						lblTotal.setText("R$"+valorTotalIten);
						SubSoma=SubValor1 + SubSoma;
						lblSubTotal.setText("R$:"+SubSoma);
                    } else {
                       new MensagemView("O campo de ID do produto ou quantidade está vazio ou inválido!",0);
                    }
                  
                    JTextField  TextNome = new JTextField();
                    JTextField TextTipo= new JTextField();
                    JTextField TextChegada= new JTextField();
                    JTextField TextPreco= new JTextField(); 
                    JTextField TextValidade= new JTextField();
                    JTextField TextQntd= new JTextField();
                    
                    ControllerGerente.PreencherTabelaDoCaixa(idProduto,quantidadeText,table_1, TextNome, TextTipo,TextChegada,TextPreco,TextValidade,TextQntd);
                }
            }
        });}
        private void limparTabela() {
            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
            model.setRowCount(0);  // Remove todas as linhas da tabela
        }
        private double CalculcularTroco(double Total,double ValorCompra) {
			double troco = ValorCompra-Total;
        	
        	return troco;
        	
        }
}


