package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;

public class MensagemView extends JDialog {

    private static final long serialVersionUID = 1L;
    private int resposta;

    /**
     * @wbp.parser.constructor
     */
    public MensagemView(String mensagem, int tipo) {
    	
        setTitle("Mensagem");
        setModal(true);

        // Criar Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Rótulo para mensagem
        JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
        panel.add(lblMensagem, BorderLayout.CENTER);

        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(painelSul, BorderLayout.SOUTH);
        
        RoundedButton BtnEntrarLogin2 = new RoundedButton("Entrar", 30, 30);
        BtnEntrarLogin2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		BtnEntrarLogin2.setBackground(Color.LIGHT_GRAY);
        	}

        	public void mouseExited(MouseEvent e) {
        		BtnEntrarLogin2.setBackground(Color.RED);
        	}
        });
        BtnEntrarLogin2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });

        BtnEntrarLogin2.setText("ok");
        BtnEntrarLogin2.setForeground(Color.WHITE);
        BtnEntrarLogin2.setFont(new Font("Arial", Font.BOLD, 20));
        BtnEntrarLogin2.setBackground(Color.RED);
        painelSul.add(BtnEntrarLogin2);
        setSize(350, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    // Método para mensagens de perguntas
    public MensagemView(String pergunta) {
        setTitle("Mensagem");
        setModal(true);

        // Criar Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        JLabel labelPergunta = new JLabel(pergunta, SwingConstants.CENTER);
        panel.add(labelPergunta, BorderLayout.CENTER);

        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        RoundedButton btnSim = new RoundedButton("Sim", 30, 30);
        btnSim.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnSim.setBackground(Color.LIGHT_GRAY);
        	}

        	public void mouseExited(MouseEvent e) {
        		btnSim.setBackground(Color.RED);
        	}
        });
        
        btnSim.setPreferredSize(new Dimension(100, 30));
        btnSim.setForeground(Color.WHITE);
        btnSim.setFont(new Font("Arial", Font.BOLD, 20));
        btnSim.setBackground(Color.RED);
        btnSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resposta = 1;
                setVisible(false);
            }
        });
        painelSul.add(btnSim);
        RoundedButton btnNao = new RoundedButton("Não", 30, 30);
        btnNao.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnNao.setBackground(Color.LIGHT_GRAY);
        	}

        	public void mouseExited(MouseEvent e) {
        		btnNao.setBackground(Color.RED);
        	}
        });
        btnNao.setPreferredSize(new Dimension(100, 30));
        btnNao.setForeground(Color.WHITE);
        btnNao.setFont(new Font("Arial", Font.BOLD, 20));
        btnNao.setBackground(Color.RED);
        btnNao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resposta = 0;
                setVisible(false);
            }
        });
        painelSul.add(btnNao);

        painelSul.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(painelSul, BorderLayout.SOUTH);

        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public int getResposta() {
        return resposta;
    }
    
}
