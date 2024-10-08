package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDAO {
		private Connection conexao;

		// Protected pois pertencem a esta classe, somente podem ser usadas por classes
		// que herdam desta
		protected GenericDAO() {
			this.conexao = ConexaoBanco.conector();
		}

		//Método que retorna a conexaao
		protected Connection conectarDAO() {
			return conexao;
		}

		// Método para salvar
		protected void save(String insertSql, Object... parametros) throws SQLException {
			PreparedStatement pstmt = conectarDAO().prepareStatement(insertSql);

			for (int i = 0; i < parametros.length; i++) {
				pstmt.setObject(i + 1, parametros[i]);
			}

			pstmt.execute();
			pstmt.close();
			conexao.close();
		}

		// Método para atualizar
		protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
			PreparedStatement pstmt = conectarDAO().prepareStatement(updateSql);
			for (int i = 0; i < parametros.length; i++) {
				pstmt.setObject(i + 1, parametros[i]);
			}
			pstmt.setObject(parametros.length + 1, id);
			pstmt.execute();
			pstmt.close();
			conexao.close();
		}

		// Método para deletar
		protected void delete(String deleteSql, Object... parametros) throws SQLException {
			PreparedStatement pstmt = conectarDAO().prepareStatement(deleteSql);

			for (int i = 0; i < parametros.length; i++) {
				pstmt.setObject(i + 1, parametros[i]);
			}

			pstmt.execute();
			pstmt.close();
			conexao.close();
		}
	}
