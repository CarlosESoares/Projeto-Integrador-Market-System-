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
		    String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";
		    
		    try (Connection conexao = ConexaoBanco.conector();
		         PreparedStatement pst = conexao.prepareStatement(sql)) {
		        
		        pst.setString(1, resCPF);
		        pst.setString(2, ResSenha2);
		        
		        try (ResultSet rs = pst.executeQuery()) {
		            if (rs.next()) {
		                Funcionario f = new Funcionario();
		                f.setNomeFuncionario(rs.getString("NomeFuncionario"));
		                f.setSobrenomeFuncionario(rs.getString("SobreNome"));
		                f.setIdFuncionario(rs.getInt("id_funcionario"));
		                f.setTipoFucionario(rs.getString("tipo_funcionario")); // corrigido
		                f.setLoginFuncionari(rs.getString("login"));
		                f.setSenhaFuncionario(rs.getString("senha"));
		                f.setTelefoneFuncionario(rs.getInt("Telefone")); // corrigido
		                f.setSalario(rs.getFloat("Salario"));
		                f.setEndereco(rs.getString("Endereco"));
		                
		                return f;
		            }
		        }
		    }
		    return null; // Retorna null se não encontrar
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
