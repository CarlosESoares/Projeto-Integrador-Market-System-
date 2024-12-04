package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(String nome, String tipo, String dataChegada, String preco, String validade, String qntd) throws SQLException {
        String query = "INSERT INTO produtos (produto, tipo_produto, data_chegada, preco, validade_produto, qntd) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, dataChegada);
            preparedStatement.setString(4, preco);
            preparedStatement.setString(5, validade);
            preparedStatement.setString(6, qntd);
            
            preparedStatement.executeUpdate();
        }
    }

    public static   List<Object[]> buscarTodosProdutos() throws SQLException {
        List<Object[]> produtos = new ArrayList<>();
        String query = "SELECT * FROM produtos";
        
        try (Connection connection = ConexaoBanco.conector();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
            	String id = resultSet.getString("id_produto");
                String nome = resultSet.getString("produto");
                String tipo = resultSet.getString("tipo_produto");
                String dataChegada = resultSet.getString("data_chegada");
                String preco = resultSet.getString("preco");
                String validade = resultSet.getString("validade_produto");
                String qntd = resultSet.getString("qntd");
                double preco1 = Double.parseDouble(preco);
                produtos.add(new Object[] { id, nome, tipo, dataChegada,   "R$: " + String.format("%.2f", preco1), validade, qntd });
            }
        }
        
        return produtos;
    }
    public boolean atualizarProduto(int id, String nome, String tipo, String chegada, String validade, double preco, int quantidade) {
        String sql = "UPDATE produtos SET produto = ?, tipo_produto = ?, data_chegada = ?, validade_produto = ?, preco = ?, qntd = ? WHERE id_produto = ?";
        try (Connection connection = ConexaoBanco.conector();
        	PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, chegada);
            stmt.setString(4, validade);
            stmt.setDouble(5, preco);
            stmt.setInt(6, quantidade);
            stmt.setInt(7, id);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluirProduto(int id) throws SQLException {
        String query = "DELETE FROM produtos WHERE id_produto = ?";
        
        try (Connection connection = ConexaoBanco.conector();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, id);
            
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }}