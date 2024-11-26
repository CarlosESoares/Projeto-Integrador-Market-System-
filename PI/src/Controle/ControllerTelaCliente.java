package Controle;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.ClienteDAO;
import visao.TelaCadastroCliente;
import visao.TelaEstoque;
import visao.telaInicial;

public class ControllerTelaCliente {
	public void AbrirTelaCliente(){
		TelaCadastroCliente Tela = new TelaCadastroCliente();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
	}

	public void AbrirTelaEstoque() {
		TelaEstoque Tela = new TelaEstoque();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}

    public void excluirCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        int selectedRow = table.getSelectedRow();
        
        if (selectedRow != -1) {
            int idcliente = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
            
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o cliente selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    boolean sucesso = ClienteDAO.excluircliente(idcliente);
                    if (sucesso) {
                        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                        limparCampos(TextNome, TextSobrenome, TextCPF);
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

    public void editarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
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
                buscarClientes(table);  
                limparCampos(TextNome, TextSobrenome, TextCPF);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
        }
    }



    
    public void cadastrarCliente(JTable table, JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        String nome = TextNome.getText();
        String sobrenome = TextSobrenome.getText();
        String CPF = TextCPF.getText();
        String CPF1 = CPF;
        boolean hasLetter = CPF1.chars().anyMatch(ch -> !Character.isDigit(ch));
        
        if (nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sobrenome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Sobrenome", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (CPF.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CPF", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (CPF1.length() != 11) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter 11 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hasLetter) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        try {
            ClienteDAO.cadastrarCliente(nome, sobrenome, CPF);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            

            limparCampos(TextNome, TextSobrenome, TextCPF);
            buscarClientes(table);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente.");
            ex.printStackTrace();
        }
    }

    public void buscarClientes(JTable table) {
        try {
            List<Object[]> clientes = ClienteDAO.buscarTodosClientes();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);  
            for (Object[] cliente : clientes) {
                model.addRow(cliente); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes.");
            e.printStackTrace();
        }
    }
    public void limparCampos(JTextField TextNome, JTextField TextSobrenome, JTextField TextCPF) {
        TextNome.setText("");
        TextSobrenome.setText("");
        TextCPF.setText("");
    }
}
