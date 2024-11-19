package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import visao.Cadastro_Gerente;

public class FuncionarioDAO  {
	public void cadastroFuncionario(String NomeFuncionario, long login, String senha, String tipo_funcionario,String sobrenome, double salario,int telefone,String endereco) throws SQLException {
        String query = "INSERT INTO funcionarios (NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, NomeFuncionario);
            preparedStatement.setLong(2, login);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, tipo_funcionario);
            preparedStatement.setString(5, sobrenome);
            preparedStatement.setDouble(6, salario);
            preparedStatement.setInt(7, telefone);
            preparedStatement.setString(8, endereco);
            
            preparedStatement.executeUpdate();
        }
    }

    public static List<Object[]> buscarFuncionario() throws SQLException {
        List<Object[]> Funcionario = new ArrayList<>();
        String query = "SELECT * FROM funcionarios";
        
        try (Connection connection = ConexaoBanco.conector();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
            	int id = resultSet.getInt("id_funcionario");
            	String NomeFuncionario = resultSet.getString("NomeFuncionario");
            	long login = resultSet.getLong("login");
                String senha = resultSet.getString("senha");
                String tipo_funcionario = resultSet.getString("tipo_funcionario");
                String sobrenome = resultSet.getString("Sobrenome");
            	double salario = resultSet.getDouble("salario");
                int telefone = resultSet.getInt("telefone");
                String endereco = resultSet.getString("endereco");

                Funcionario.add(new Object[] { id, NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco});
                DefaultTableModel model = (DefaultTableModel) Cadastro_Gerente.table.getModel();
                int NumItem = model.getRowCount() +1;
                model.addRow(new Object[] {
                		id,
                		NomeFuncionario,
                		sobrenome,
                		telefone,
                		salario,
                		endereco
                });
            }
        }
        
        return Funcionario;
    }
    public static boolean atualizarFuncionario(int id,String NomeFuncionario, long login, String senha, String tipo_funcionario,String sobrenome, double salario,int telefone,String endereco) {
    	int selectedRow = Cadastro_Gerente.table.getSelectedRow();
        if (selectedRow != -1) {
            id = Integer.parseInt(Cadastro_Gerente.table.getValueAt(selectedRow, 0).toString());

            boolean success = FuncionarioDAO.atualizarFuncionario(id, NomeFuncionario,login, senha, tipo_funcionario, sobrenome, salario, telefone, endereco);
            
            if (success) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o produto.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para editar.");
        }
    	
    	String sql = "UPDATE funcionario SET NomeFuncionario = ?, login = ?, senha = ?, tipo_funcionario = ?, sobrenome = ?, salario = ?, telefone = ?, endereco = ? WHERE id_funcionario = ? ";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
        	 stmt.setString(1, NomeFuncionario);
        	stmt.setLong(2, login);
            stmt.setString(3, senha);
            stmt.setString(4, tipo_funcionario);
            stmt.setString(5, sobrenome);
        	stmt.setDouble(6, salario);
            stmt.setInt(7, telefone);
            stmt.setString(8, endereco);
            stmt.setInt(9, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean excluirFuncionario(int id) throws SQLException {
        
    	int selectedRow = Cadastro_Gerente.table.getSelectedRow();
        if (selectedRow != -1) {
            int id_Funcionario = Integer.parseInt(Cadastro_Gerente.table.getValueAt(selectedRow, 0).toString());
            
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja demitir o Funcionaio selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    boolean sucesso = FuncionarioDAO.excluirFuncionario(id_Funcionario);
                    if (sucesso) {
                 
                        ((DefaultTableModel) Cadastro_Gerente.table.getModel()).removeRow(selectedRow);
						JOptionPane.showMessageDialog(null, "Funcionáio demitido com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao demitir o produto.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao demitir o produto: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Funcionário para demitir.");
        }      
    	String query = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
    


	 Connection conexao = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;


	 public static Funcionario autenticar(String resCPF, String ResSenha2) throws SQLException {
		    String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";
		    
		    try (Connection conexao = ConexaoBanco.conector();
		         PreparedStatement pst = conexao.prepareStatement(sql)) {
		        
		        pst.setString(1, resCPF);
		        pst.setString(2, ResSenha2);
		        
		        try (ResultSet rs = pst.executeQuery()) {
		            if (rs.next()) {
		                Funcionario f = new Funcionario();
		                f.setNomeFuncionario(rs.getString("NomeFuncionario"));
		                f.setSobrenomeFuncionario(rs.getString("SobreNome"));
		                f.setIdFuncionario(rs.getInt("id_funcionario"));
		                f.setTipoFucionario(rs.getString("tipo_funcionario")); // corrigido
		                f.setLoginFuncionari(rs.getString("login"));
		                f.setSenhaFuncionario(rs.getString("senha"));
		                f.setTelefoneFuncionario(rs.getInt("Telefone")); // corrigido
		                f.setSalario(rs.getFloat("Salario"));
		                f.setEndereco(rs.getString("Endereco"));
		                
		                return f;
		            }
		        }
		    }
		    return null; // Retorna null se não encontrar
		}

		
	 public static String buscarTipoFuncionarioDoUsuarioLogado(int idFuncionarioLogado) throws SQLException {
		    String tipoFuncionario = null;
		    
		    // Consulta SQL para buscar o tipo de funcionário pelo ID
		    String sql = "SELECT tipo_funcionario FROM funcionarios WHERE id_funcionario = ?";
		    
		    try (Connection connection = ConexaoBanco.conector();
		         PreparedStatement pst = connection.prepareStatement(sql)) {
		        
		        // Defina o ID do funcionário
		        pst.setInt(1, idFuncionarioLogado);
		        
		        // Executa a consulta e recupera o tipo de funcionário
		        try (ResultSet rs = pst.executeQuery()) {
		            if (rs.next()) {
		                tipoFuncionario = rs.getString("tipo_funcionario");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return tipoFuncionario; // Retorna o tipo do funcionário ou null se não encontrado
		}
	
	
	public void FecharConexao() {
		if (conexao != null){
			try {
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
}
