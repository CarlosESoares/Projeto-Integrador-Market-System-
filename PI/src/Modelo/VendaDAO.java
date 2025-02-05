package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controle.ControllerGerente;
import visao.MensagemView;
import visao.TelaDoCaixa;

public class VendaDAO {

    private static Connection connection;
    int quantCalc;
	ArrayList<Double>valoresItens = new ArrayList<>();

    double preco;
   
    public static List<Object[]> buscarVendasReduzindas(JTable table) {
        List<Object[]> vendas = new ArrayList<>();

        try {
            connection = ConexaoBanco.conector();
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
                    vendas.add(new Object[] { idVenda, "R$:" + String.format("%.2f", total), idFuncionario, idCliente,   "R$:" + String.format("%.2f", preco), quantidade, total });

                    // Adiciona os dados na tabela
                    model.addRow(new Object[]{idVenda,produto, idFuncionario, idCliente});
                }

                // Fecha a conexão com o banco de dados
                connection.close();
            }
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return vendas;
        
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
            VendaDAO.connection = ConexaoBanco.conector();
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
                    String tipo = model.getValueAt(i, 2).toString();  // Tipo do produto
                    String dataChegada = model.getValueAt(i, 3).toString();  // Data de chegada
                    
                    String precoString =String.valueOf(model.getValueAt(i, 4).toString());
                    precoString = precoString.replace("R$", "").trim();  // Remove "R$"
                    precoString = precoString.replace(",", ".");  // Substitui vírgula por ponto
                    double preco = Double.parseDouble(precoString);
                    String validade = model.getValueAt(i, 5).toString();  // Validade
                    int quantidade = Integer.parseInt(model.getValueAt(i, 6).toString());  // Quantidade
                    
                    double total = preco*quantidade;
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
                    finalizarCompra(idVenda, idCliente, total);
                    
                    
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            new MensagemView("Erro ao cadastrar venda", 0);
        }
    }

    public  double ColocarProdutoNaTabela(String idProduto2, String quantidade,Double total) {
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



                    new MensagemView("Quantidade atualizada para: " + novaQuantidade,1);

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
    public static void finalizarCompra(int idVenda, long idCliente, double totalCompra) {
        try {
            connection = ConexaoBanco.conector();
            
            if (connection != null) {
                // 1. Exibir mensagem para perguntar se deseja usar crédito
            	MensagemView mv = new MensagemView("Usar credito do cliente? ");
                int confirmacao = mv.getResposta();

               
               

                if (confirmacao == 1) { // Sim, usar crédito
                    PreparedStatement stmt = connection.prepareStatement("SELECT credito FROM clientes WHERE id_cliente = ?");
                    stmt.setFloat(1, idCliente);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        double creditoAtual = rs.getDouble("credito");

                        if (creditoAtual >= totalCompra) {
                            // Subtrai o valor total do crédito
                            double novoCredito = creditoAtual - totalCompra;

                            PreparedStatement updateCredito = connection.prepareStatement("UPDATE clientes SET credito = ? WHERE id_cliente = ?");
                            updateCredito.setDouble(1, novoCredito);
                            updateCredito.setFloat(2, idCliente);
                            updateCredito.executeUpdate();

                            // Registra a venda como "paga com crédito"
                            PreparedStatement updateVenda = connection.prepareStatement("UPDATE vendas SET metodo_pagamento = 'Crédito Cliente' WHERE id_venda = ?");
                            updateVenda.setInt(1, idVenda);
                            updateVenda.executeUpdate();

                            new MensagemView("Compra finalizada usando crédito do cliente!",0);
                        } else {
                        	new MensagemView( "Crédito insuficiente! Escolha outro método de pagamento.",0);
                            selecionarMetodoPagamento(idVenda);
                        }
                    }
                } else {
                    // Perguntar qual será o método de pagamento
                    selecionarMetodoPagamento(idVenda);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void selecionarMetodoPagamento(int idVenda) {
        String[] opcoes = {"Dinheiro", "Cartão", "Pix"};
        String metodo = (String) JOptionPane.showInputDialog(null, "Escolha o método de pagamento:", "Pagamento", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (metodo != null) {
            try {
                PreparedStatement stmt = connection.prepareStatement("UPDATE vendas SET metodo_pagamento = ? WHERE id_venda = ?");
                stmt.setString(1, metodo);
                stmt.setInt(2, idVenda);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Compra finalizada com pagamento via " + metodo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
