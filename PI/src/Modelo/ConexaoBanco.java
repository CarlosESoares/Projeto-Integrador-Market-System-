package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
	public static Connection conector() {
		Connection conexao = null;
		// chamar o driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// Armazenando infos do banco
		String url = "jdbc:mysql://localhost:3306/mercado";
		String user = "root";
		String password = "Aluno";
		// Estabelecer a conexao com o DB
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			System.out.println(" conectado");
			return conexao;
		} catch (Exception e) {
			System.out.println(" nao conectado");
			return null;
		}
	
	
	
	}

}
