package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import visao.Login;

public class ProcessoDeLogin {
    Connection conn = ConexaoBanco.getConexaoMySQL();
    String sql = "SELECT * FROM funcionarios WHERE cpf = ? AND senha = ?";
    ResultSet rs = null;

    public boolean verificarLogin(String cpf, String senha) {
        PreparedStatement stmt = null;

        try {
            // Usa PreparedStatement para prevenir SQL injection e definir os parâmetros
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);   // Primeiro parâmetro (CPF)
            stmt.setString(2, senha); // Segundo parâmetro (senha)

            // Executa a query e armazena o resultado no ResultSet
            rs = stmt.executeQuery();

            // Verifica se existe uma linha no resultado (login correto)
            if (rs.next()) {
                return true; // Login correto
            } else {
                return false; // Login incorreto
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fechando recursos para evitar vazamento de memória
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void login(String cpf, String senha) {
        if (verificarLogin(cpf, senha)) {
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            // Redirecionar para outra tela ou ação
        } else {
            JOptionPane.showMessageDialog(null, "CPF ou senha incorretos.");
        }
    }
}
