package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {


	 Connection conexao = null;
	 PreparedStatement pst = null;
	 ResultSet rs = null;


	public Funcionario autenticar(String resCPF, String ResSenha2) throws SQLException {
		String sql = "SELECT * FROM funcionarios WHERE login =? AND senha=?  ";
			conexao = ConexaoBanco.conector();
			pst = conexao.prepareStatement(sql);
			pst.setString(1, resCPF);
			pst.setString(2, ResSenha2);

			rs = pst.executeQuery();
			
			if(rs.next()) {
			
				Funcionario f = new Funcionario();
				f.setNomeFuncionario(rs.getString("Nome"));
				f.setSobrenomeFuncionario(rs.getString("SobreNome"));
				f.setIdFuncionario(rs.getInt("id_funcionario"));
				f.setEndereco(rs.getString("Endereco"));
				f.setSenhaFuncionario(rs.getString("senha"));
				f.setTelefoneFuncionario(rs.getInt("Fone"));
				f.setSalario(rs.getDouble("Salario"));
				return f;
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
