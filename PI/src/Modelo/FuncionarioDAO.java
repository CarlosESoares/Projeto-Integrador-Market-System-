package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controle.ControleDeLogin;

public class FuncionarioDAO {

	ControleDeLogin telas = new ControleDelogin();

	 Connection conexao = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;


	public String autenticar(String resCPF, String ResSenha2) throws SQLException {
		String sql = "SELECT * FROM funcionarios WHERE login =? AND senha=?  ";
			conexao = ConexaoBanco.conector();
			pst = conexao.prepareStatement(sql);
			pst.setString(1, resCPF);
			pst.setString(2, ResSenha2);

			rs = pst.executeQuery();
			
			if(rs.next()) {
				String perfil = rs.getString("Caixa");
				telas.ChamarTelas();
				//chamar a função Abrir tela caixa
				
				return perfil;
			}else {
				return null;
			}
			

		
		
	}
	
	public void FecharConexao() {
		if (conexao != null){
			try {
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
	
}
