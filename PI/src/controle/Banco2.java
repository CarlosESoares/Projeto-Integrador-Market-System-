package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco2 {
	public static void main(String[] args) {
		//executa operações no banco de dados
		Statement stml = null;
		
		// faz conexão com banco de dados
		Connection conn = ConexaoBanco.getConexaoMySQL();
		
		try {
			stml = (Statement) conn.createStatement();
			//Traz os resultados da consulta SQL
			ResultSet resl = null;
			resl = stml.executeQuery("SELECT * FROM carrinho");
			System.out.println("\nTABELA CARRINHO:\n");
			System.out.println("id_venda            produtos_Id_produto         quantidade");
			while(resl.next()) {
				System.out.println(resl.getInt("id_venda") +     "           " + resl.getString("produtos_Id_produto") +    "             "  + resl.getString("quantidade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			stml = (Statement) conn.createStatement();
			//Traz os resultados da consulta SQL
			ResultSet resl = null;
			resl = stml.executeQuery("SELECT * FROM clientes");
			System.out.println("\nTABELA CLIENTES:\n");
			System.out.println("id_cliente            nome         sobrenome          cpf_cliente       ");
			while(resl.next()) {
				System.out.println(resl.getInt("id_cliente") +     "           " + resl.getString("nome") +    "             "  + resl.getString("sobrenome")+     "             "  + resl.getString("cpf_cliente"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			stml = (Statement) conn.createStatement();
			//Traz os resultados da consulta SQL
			ResultSet resl = null;
			resl = stml.executeQuery("SELECT * FROM creditos");
			System.out.println("\nTABELA CREDITOS:\n");
			System.out.println("id_credito            num_total_parcelas         preco_parcela          vendas_Id_venda        limite_divida    qtd_parcelas_pagas     ");
			while(resl.next()) {
				System.out.println(resl.getInt("id_credito") +     "           " + resl.getString("num_total_parcelas") +    "             "  + resl.getString("preco_parcela")+     "             "  + resl.getString("vendas_Id_venda")+    "             "  + resl.getString("limite_divida")+     "             "  + resl.getString("qtd_parcelas_pagas"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}



