package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import visao.MensagemView;

public class ConexaoBanco {
	public static Connection conector() {
		Connection conexao = null;
		// chamar o driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// Armazenando infos do banco
		String url = "jdbc:mysql://localhost:3306/mercado";
		String user = "root";
		String password = "aluno";
		// Estabelecer a conexao com o DB
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			new MensagemView(" nao conectado ao banco de dados",1);
			return null;
		}
	
	
	
	}

}
