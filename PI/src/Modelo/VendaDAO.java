package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VendaDAO {

    private Connection connection;

    public void buscarVendas(JTable table) {
        try {
            this.connection = ConexaoBanco.conector();

            if (connection != null) {
                // Criando a instrução SQL
                Statement statement = connection.createStatement();

                // Consulta SQL para buscar as vendas e seus detalhes
                String sql = "SELECT v.id_venda, v.funcionario_id_funcionario, v.cliente_id_cliente, p.produto, p.preco, c.quantidade, (p.preco * c.quantidade) AS total "
                           + "FROM vendas v "
                           + "JOIN carrinho c ON v.id_venda = c.id_venda "
                           + "JOIN produtos p ON c.produtos_Id_produto = p.id_produto";

                // Executa a consulta e obtém os resultados
                ResultSet resultSet = statement.executeQuery(sql);

                // Limpa as linhas atuais da tabela antes de adicionar novas
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                // Itera sobre os resultados e adiciona cada linha na tabela
                while (resultSet.next()) {
                    int idVenda = resultSet.getInt("id_venda");
                    int idFuncionario = resultSet.getInt("funcionario_id_funcionario");
                    int idCliente = resultSet.getInt("cliente_id_cliente");
                    String produto = resultSet.getString("produto");
                    double preco = resultSet.getDouble("preco");
                    int quantidade = resultSet.getInt("quantidade");
                    double total = resultSet.getDouble("total");

                    // Adiciona os dados na tabela
                    model.addRow(new Object[]{idVenda, idFuncionario, idCliente, produto, preco, quantidade, total});
                }

                // Fecha a conexão com o banco de dados
                connection.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
