package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static void cadastrarCliente(String nome, String sobrenome, String CPF) throws SQLException {
        String query = "INSERT INTO clientes (nome, sobrenome, cpf_cliente) VALUES (?, ?, ?)";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.setString(3, CPF);

            
            preparedStatement.executeUpdate();
        }
    }

    public static List<Object[]> buscarTodosClientes() throws SQLException {
        List<Object[]> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        
        try (Connection connection = ConexaoBanco.conector();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
            	String id = resultSet.getString("id_cliente");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String CPF = resultSet.getString("cpf_cliente");

                clientes.add(new Object[] { id, nome, sobrenome, CPF});
            }
        }
        
        return clientes;
    }
    public static boolean atualizarcliente(int id, String nome, String sobrenome, String CPF) {
        String sql = "UPDATE clientes SET nome = ?, sobrenome = ?, cpf_cliente = ? WHERE id_cliente = ?";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, CPF);
            stmt.setInt(4, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean excluircliente(int id) throws SQLException {
        String query = "DELETE FROM clientes WHERE id_cliente = ?";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }}