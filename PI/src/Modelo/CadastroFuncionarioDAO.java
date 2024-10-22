package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarioDAO extends GenericDAO {
	public static void cadastroFuncionario(String login, String senha, String tipo_funcionario) throws SQLException {
        String query = "INSERT INTO funcionarios (login, senha, tipo_funcionario) VALUES (=?, =?, =?)";
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, tipo_funcionario);
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
            	String id = resultSet.getString("id_funcionario");
            	String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String tipo_funcionario = resultSet.getString("tipo_funcionario");

                Funcionario.add(new Object[] { id, login, senha, tipo_funcionario});
            }
        }
        
        return Funcionario;
    }
    public boolean atualizarFuncionario(int id, String login, String senha, String tipo_funcionario) {
        String sql = "UPDATE funcionario SET login = ?, senha = ?, tipo_funcionario = ? WHERE id_funcionario = ?";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setString(3, tipo_funcionario);
            stmt.setInt(7, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluirFuncionario(int id) throws SQLException {
        String query = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
