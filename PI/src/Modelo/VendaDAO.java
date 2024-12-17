package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import visao.MensagemView;
import visao.TelaDoCaixa;

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

	public void BuscarProdutoIDCaixa(String idProduto2, String quantidade, JTable tabela) {
		System.out.println(quantidade);
        String url = "jdbc:mysql://localhost:3306/mercado";
        String user = "root";
        String password = "aluno";
        String queryBusca = "SELECT * FROM produtos WHERE id_produto = ?";
        String queryAtualiza = "UPDATE produtos SET qntd = ? WHERE id_produto = ?";
        int quantV = Integer.parseInt(quantidade);
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmtBusca = conn.prepareStatement(queryBusca);
             PreparedStatement stmtAtualiza = conn.prepareStatement(queryAtualiza)) {

            stmtBusca.setInt(1, Integer.parseInt(idProduto2));
            ResultSet rs = stmtBusca.executeQuery();

         
            if (rs.next()) {
                String nomeProduto = rs.getString("produto");
                String tipoProduto = rs.getString("tipo_produto");
                String dataChegada = rs.getString("data_chegada");
                double preco = rs.getDouble("preco");
                String validade = rs.getString("validade_produto");
                int quantidade1 = rs.getInt("qntd");  // Aqui você pega a quantidade do banco
                	
                int quantCalc = Integer.valueOf(quantidade);
                
                
               calcularSubtotal(preco,quantCalc);
                // Verifica se a quantidade é maior que zero e quantTxt é válido
                if (quantidade1 > 0 && quantV > 0) {
                    // Atualizar quantidade
                    int novaQuantidade = quantidade1 - quantV;
                    stmtAtualiza.setInt(1, novaQuantidade);
                    stmtAtualiza.setInt(2, Integer.parseInt(idProduto2));
                    stmtAtualiza.executeUpdate();
                    
                    
                    
                    System.out.println("Quantidade atualizada para: " + novaQuantidade);

                    DefaultTableModel model = (DefaultTableModel) TelaDoCaixa.table_1.getModel();
                    model.addRow(new Object[]{
                        idProduto2, nomeProduto, tipoProduto, dataChegada,
                        String.format("R$ %.2f", preco*quantV), validade, quantV
                        
                        
                    });
                    
                } else {
                    System.out.println("Produto esgotado ou quantidade inválida.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }

        } catch (NumberFormatException e) {
            new MensagemView("ID do produto ou quantidade inválida: ",0);
        } catch (Exception ex) {
            ex.printStackTrace();
           new MensagemView("Erro ao acessar o banco de dados: ",1);
        }}
    public static  String calcularSubtotal(double preco, int quantidade) {
        ArrayList<Double> valoresItens = new ArrayList<>();
        int quant = Integer.valueOf(quantidade);
        double totalItem = preco * quant;
    	
        valoresItens.add(totalItem);

        double subtotal = valoresItens.stream().mapToDouble(Double::doubleValue).sum();

        String valor = (String.format("Subtotal: R$ %.2f", subtotal));
        return valor;
    		
	}
}
