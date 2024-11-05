package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionarioDAO extends GenericDAO {
	public void cadastroFuncionario(String NomeFuncionario, String login, String senha, String tipo_funcionario,String sobrenome, String salario,String telefone,String endereco) throws SQLException {
        String query = "INSERT INTO funcionarios (NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, NomeFuncionario);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, tipo_funcionario);
            preparedStatement.setString(5, sobrenome);
            preparedStatement.setString(6, salario);
            preparedStatement.setString(7, telefone);
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
            	String id = resultSet.getString("id_funcionario");
            	String NomeFuncionario = resultSet.getString("NomeFuncionario");
            	String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String tipo_funcionario = resultSet.getString("tipo_funcionario");
                String sobrenome = resultSet.getString("Sobrenome");
            	String salario = resultSet.getString("salario");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");

                Funcionario.add(new Object[] { id, NomeFuncionario, login, senha, tipo_funcionario,sobrenome, salario, telefone, endereco});
            }
        }
        
        return Funcionario;
    }
    public static boolean atualizarFuncionario(int id,String NomeFuncionario, int login, String senha, String tipo_funcionario,String sobrenome, double salario,int telefone,String endereco) {
        String sql = "UPDATE funcionario SET NomeFuncionario = ?, login = ?, senha = ?, tipo_funcionario = ?, sobrenome = ?, salario = ?, telefone = ?, endereco = ? WHERE id_funcionario = ? ";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
        	 stmt.setString(1, NomeFuncionario);
        	stmt.setInt(2, login);
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
        String query = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
