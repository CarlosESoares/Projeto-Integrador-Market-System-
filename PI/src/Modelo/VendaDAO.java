package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import visao.MensagemView;
import visao.TelaDoCaixa;

public class VendaDAO {

    private Connection connection;
    int quantCalc;
	ArrayList<Double>valoresItens = new ArrayList<>();

    double preco;
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
    public void CadastrarVenda(JTable table, Funcionario f, long cpfCliente) {
    	System.out.println(f.getTipoFucionario());
        int idFuncionario = f.getIdFuncionario();
        ControllerGerente geral = new ControllerGerente();
        // Buscando o idCliente a partir do CPF
        long idCliente =  geral.BuscarClientePorCPF(cpfCliente);
        if (idCliente == -1) {
            return;  // Retorna caso o cliente não tenha sido encontrado
        }
        String idClienteString =String.valueOf(idCliente);
        try {
            this.connection = ConexaoBanco.conector();
            if (connection != null) {
                // Criar a venda e obter o ID da venda
                String sqlVenda = "INSERT INTO vendas (funcionario_id_funcionario, cliente_id_cliente) VALUES (?, ?)";
                PreparedStatement statementVenda = connection.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS);
                statementVenda.setInt(1, idFuncionario);
                statementVenda.setString(2,idClienteString);
                int rowsAffectedVenda = statementVenda.executeUpdate();

                int idVenda = -1;
                if (rowsAffectedVenda > 0) {
                    ResultSet generatedKeys = statementVenda.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        idVenda = generatedKeys.getInt(1);  // Obtendo o ID da venda gerada
                    }
                }

                if (idVenda == -1) {
                    new MensagemView("Erro ao criar venda", 0);
                    return;
                }

                // Percorrer as linhas da JTable e inserir os produtos no carrinho
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    int idProduto = Integer.parseInt(model.getValueAt(i, 0).toString());  // ID do produto
                    String nomeProduto = model.getValueAt(i, 1).toString();  // Nome/descrição do produto
                    String tipo = model.getValueAt(i, 2).toString();  // Tipo do produto
                    String dataChegada = model.getValueAt(i, 3).toString();  // Data de chegada
                    
                    String precoString =String.valueOf(model.getValueAt(i, 4).toString());
                    precoString = precoString.replace("R$", "").trim();  // Remove "R$"
                    precoString = precoString.replace(",", ".");  // Substitui vírgula por ponto
                    double preco = Double.parseDouble(precoString);
                    String validade = model.getValueAt(i, 5).toString();  // Validade
                    int quantidade = Integer.parseInt(model.getValueAt(i, 6).toString());  // Quantidade

                    // Inserir produto no carrinho
                    String sqlCarrinho = "INSERT INTO carrinho (id_venda, produtos_Id_produto, quantidade, preco, data_chegada, tipo, validade) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement statementCarrinho = connection.prepareStatement(sqlCarrinho);
                    statementCarrinho.setInt(1, idVenda);
                    statementCarrinho.setInt(2, idProduto);
                    statementCarrinho.setInt(3, quantidade);
                    statementCarrinho.setDouble(4, preco);
                    statementCarrinho.setString(5, dataChegada);
                    statementCarrinho.setString(6, tipo);
                    statementCarrinho.setString(7, validade);

                    statementCarrinho.executeUpdate();
                }

                new MensagemView("Venda cadastrada com sucesso!", 1);
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            new MensagemView("Erro ao cadastrar venda", 0);
        }
    }

    public  double ColocarProdutoNaTabela(String idProduto2, String quantidade,Double total) {
        String url = "jdbc:mysql://localhost:3306/mercado";
        String user = "root";
        String password = "Aluno";
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
                String validade = rs.getString("validade_produto");
                 preco = rs.getDouble("preco");
                int quantidade2 = rs.getInt("qntd");  
                System.out.println("chego aqui2");
                 quantCalc = Integer.valueOf(quantidade);
                
                
                // Verifica se a quantidade é maior que zero e quantTxt é válido
                if (quantidade2 > 0 && quantV > 0) {
                    // Atualizar quantidade
                    int novaQuantidade = quantidade2 - quantV;
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
            System.out.println("ID do produto ou quantidade inválida: " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao acessar o banco de dados: " + ex.getMessage());
        }
        return calcularSubtotal(preco,quantCalc);
    
    }
    public double calcularSubtotal(double preco, int quantidade) {  
        double totalItem = preco * quantidade;
    	double TotalCompra = 0;
    	TotalCompra = totalItem+ TotalCompra;
        valoresItens.add(TotalCompra);

        double subtotal = valoresItens.stream().mapToDouble(Double::doubleValue).sum();
        
        return subtotal;

	}
}
