package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrarProduto(String nome, String tipo, String dataChegada, String preco, String validade) throws SQLException {
        String query = "INSERT INTO produtos (produto, tipo_produto, data_chegada, preco, validade_produto) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = ConexaoBanco.getConexaoMySQL();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, tipo);
            preparedStatement.setString(3, dataChegada);
            preparedStatement.setString(4, preco);
            preparedStatement.setString(5, validade);
            
            preparedStatement.executeUpdate();
        }
    }

    public List<Object[]> buscarTodosProdutos() throws SQLException {
        List<Object[]> produtos = new ArrayList<>();
        String query = "SELECT * FROM produtos";
        
        try (Connection connection = ConexaoBanco.getConexaoMySQL();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String nome = resultSet.getString("produto");
                String tipo = resultSet.getString("tipo_produto");
                String dataChegada = resultSet.getString("data_chegada");
                String preco = resultSet.getString("preco");
                String validade = resultSet.getString("validade_produto");

                produtos.add(new Object[] { nome, tipo, dataChegada, preco, validade });
            }
        }
        
        return produtos;
    }}