package controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String url = "jdbc:mysql://localhost:3306/mercado";
 String user = "root";
 String password = "aluno";

 try (Connection connection = DriverManager.getConnection(url, user, password)){
	 System.out.println("Conectado!");
 }catch(SQLException e) {
	 e.printStackTrace();
	 System.out.println("falha na conexão");

 }

	}

}

