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

import Controle.ControllerEstoquista;
import Controle.ControllerTelaCAIxa;
import Controle.ControllerTelaCliente;
import Controle.ControllerTelaVendas;

public class telaInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    telaInicial frame = new telaInicial();
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
    public telaInicial() {
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
        
        JLabel imgLogo = new JLabel("");
        ImageIcon originalIconLogo = new ImageIcon(Login.class.getResource("/Imagens/Logo2.png"));
        Image imageLogo = originalIconLogo.getImage();
        Image NovaLogo = imageLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon ImgRedimencionada = new ImageIcon(NovaLogo);
        imgLogo.setIcon(ImgRedimencionada);
        
        imgLogo.setVerticalAlignment(SwingConstants.BOTTOM);
        panel_1.add(imgLogo);
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        
        JLabel Titulo = new JLabel("HOME");
        Titulo.setBounds(367, 11, 187, 30);
        Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JLabel imgOndinha = new JLabel("");
        imgOndinha.setBounds(0, 228, 1200, 355);
        imgOndinha.setFont(new Font("Tahoma", Font.PLAIN, 11));
        imgOndinha.setIcon(resizedIcon);
        
        // Carregar a imagem do ícone do cliente
        ImageIcon clienteIcon = new ImageIcon(getClass().getResource("/Imagens/address-card-solid.png"));
        Image clienteImage = clienteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedClienteIcon = new ImageIcon(clienteImage);

        // Criar o botão com o texto e o ícone do cliente
        RoundedButton btnCliente = new RoundedButton("Tela_Cliente", 30, 30);
        btnCliente.setHorizontalAlignment(SwingConstants.LEFT);
        btnCliente.setText("  Clientes");
        btnCliente.setForeground(new Color(255, 255, 255));
        btnCliente.setBackground(new Color(255, 0, 0));
        btnCliente.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCliente.setIcon(resizedClienteIcon); // Adiciona o ícone no botão
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
                ControllerTelaCliente abrir = new ControllerTelaCliente();
                abrir.AbrirTelaCliente();
                dispose();
            }
        });
        btnCliente.setBounds(306, 45, 187, 66);
        panel_2.setLayout(null);
        panel_2.add(imgOndinha);
        panel_2.add(btnCliente);
        panel_2.add(Titulo);

        // Carregar a imagem do ícone de estoque
        ImageIcon estoqueIcon = new ImageIcon(getClass().getResource("/Imagens/box-open-solid.png"));
        Image estoqueImage = estoqueIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedEstoqueIcon = new ImageIcon(estoqueImage);

        // Criar o botão com o texto e o ícone de estoque
        RoundedButton btnEstoque = new RoundedButton("Tela_Estoque", 30, 30);
        btnEstoque.setHorizontalAlignment(SwingConstants.LEFT);
        btnEstoque.setForeground(Color.WHITE);
        btnEstoque.setText("  Estoque");
        btnEstoque.setFont(new Font("Arial", Font.PLAIN, 20));
        btnEstoque.setBackground(new Color(255, 0, 0));
        btnEstoque.setIcon(resizedEstoqueIcon); // Adiciona o ícone no botão

        // Configurar o botão para alterar a cor ao passar o mouse
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
                ControllerEstoquista abrir = new ControllerEstoquista();
                abrir.AbrirTelaEstoque();
                dispose();
            }
        });
        btnEstoque.setBounds(306, 122, 187, 66);
        panel_2.add(btnEstoque);

        // Carregar a imagem do ícone de vendas
        ImageIcon vendasIcon = new ImageIcon(getClass().getResource("/Imagens/comments-dollar-solid.png"));
        Image vendasImage = vendasIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedVendasIcon = new ImageIcon(vendasImage);

        // Criar o botão com o texto e o ícone de vendas
        RoundedButton btnVendas = new RoundedButton("Tela_Vendas", 30, 30);
        btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
        btnVendas.setText("  Vendas");
        btnVendas.setForeground(new Color(255, 255, 255));
        btnVendas.setFont(new Font("Arial", Font.PLAIN, 20));
        btnVendas.setBackground(new Color(255, 0, 0));
        btnVendas.setIcon(resizedVendasIcon); // Adiciona o ícone no botão
        btnVendas.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnVendas.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                btnVendas.setBackground(Color.RED);
            }
        });
        btnVendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControllerTelaVendas abrir = new ControllerTelaVendas();
                abrir.AbrirTelaVendas();    
                dispose();
            }
        });
        btnVendas.setBounds(306, 276, 187, 66);
        panel_2.add(btnVendas);

        // Carregar a imagem do ícone de caixa
        ImageIcon caixaIcon = new ImageIcon(getClass().getResource("/Imagens/desktop-solid.png"));
        Image caixaImage = caixaIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedCaixaIcon = new ImageIcon(caixaImage);

        // Criar o botão com o texto e o ícone de caixa
        RoundedButton btnCaixa = new RoundedButton("Tela_Caixa", 30, 30);
        btnCaixa.setHorizontalAlignment(SwingConstants.LEFT);
        btnCaixa.setText("  Caixa");
        btnCaixa.setForeground(new Color(255, 255, 255));
        btnCaixa.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCaixa.setBackground(new Color(255, 0, 0));
        btnCaixa.setIcon(resizedCaixaIcon); // Adiciona o ícone no botão
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
                ControllerTelaCAIxa abrir = new ControllerTelaCAIxa();
                abrir.AbrirCaixa();
                dispose();
            }
        });
        btnCaixa.setBounds(306, 199, 187, 66);
        panel_2.add(btnCaixa);
    }
}
