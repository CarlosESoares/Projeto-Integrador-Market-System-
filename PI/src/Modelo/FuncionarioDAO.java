package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import Controle.Funcionario;

public class FuncionarioDAO {

		 Connection conexao = null;
		 PreparedStatement pst = null;
		 ResultSet rs = null;


		public String autenticar(String Login, String senha2) {
			String sql = "SELECT * FROM usuarios WHERE login =? AND senha=?";
			
			try {
				String Login2 = Login;
				String senha = senha2;
				
				pst = conexao.prepareStatement(sql);
				pst.setString(1, Login2);
				pst.setString(2, senha);

				rs = pst.executeQuery();
				
				if(rs.next()) {
					String perfil = rs.getString("perfil");
					
					return perfil;
				}else {
					return null;
				}
				
			}catch(Exception e) {
				
			
			JOptionPane.showMessageDialog(null, e);
				
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

