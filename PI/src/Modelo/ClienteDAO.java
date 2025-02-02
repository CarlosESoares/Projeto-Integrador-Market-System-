package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static void cadastrarCliente(String nome, String sobrenome, String CPF, String Limite) throws SQLException {
        String query = "INSERT INTO mercado.clientes (nome, sobrenome, cpf_cliente, credito) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.setString(3, CPF);
            preparedStatement.setString(4, Limite);

            
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
                String Limite = resultSet.getString("credito");
                double Limite1 = Double.parseDouble(Limite);
                clientes.add(new Object[] { id, nome, sobrenome, CPF, "R$:" + String.format("%.2f", Limite1)});
            }
        }
        
        return clientes;
    }
    public static List<Object[]> buscarTodosClientesR() throws SQLException {
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
                String Limite = resultSet.getString("credito");
                double Limite1 = Double.parseDouble(Limite);
                clientes.add(new Object[] { id, nome, sobrenome, CPF});
            }
        }
        
        return clientes;
    }
    
    public static List<Object[]> buscarCliente(long cpfCliente) throws SQLException {
        List<Object[]> clientes = new ArrayList<>();
        
        // Corrigindo a consulta SQL e utilizando PreparedStatement
        String query = "SELECT * FROM mercado.clientes WHERE cpf_cliente = ?";

        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Substitui o parâmetro do CPF na consulta
        	preparedStatement.setString(1, String.valueOf(cpfCliente));

            // Executa a consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Itera sobre o resultado e adiciona os dados na lista
                while (resultSet.next()) {
                    String id = resultSet.getString("id_cliente");
                    String nome = resultSet.getString("nome");
                    String sobrenome = resultSet.getString("sobrenome");
                    String CPF = resultSet.getString("cpf_cliente");
                    String limite = resultSet.getString("credito");

                    // Adiciona os dados à lista de resultados
                    clientes.add(new Object[] { id, nome, sobrenome, CPF, limite });
                }
            }
        }
        
        return clientes;
    }

    public static boolean atualizarcliente(int id, String nome, String sobrenome, String CPF, String Limite) {
        String sql = "UPDATE mercado.clientes SET nome = ?, sobrenome = ?, cpf_cliente = ?, credito = ? WHERE id_cliente = ?";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, CPF);
            stmt.setString(4, Limite);
            stmt.setInt(5, id);
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