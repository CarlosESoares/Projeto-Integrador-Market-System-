package Controle;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Funcionario;
import Modelo.FuncionarioDAO;
import visao.Cadastro_Gerente;

public class ControllerLogin {

    public void realizarLogin(String resCPF, String ResSenha2) {
        try {
            // Chama o método de autenticação da classe FuncionarioDAO
            Funcionario funcionario = FuncionarioDAO.autenticar(resCPF, ResSenha2);
            
            if (funcionario != null) {
                // Login bem-sucedido, agora buscamos o tipo de funcionário
                int idFuncionarioLogado = funcionario.getIdFuncionario();
                String tipoFuncionario = FuncionarioDAO.buscarTipoFuncionarioDoUsuarioLogado(idFuncionarioLogado);
                
                // Exemplo: Ajusta os botões com base no tipo de funcionário
                if ("Gerente".equals(tipoFuncionario)) {
                    // Supondo que você tenha um botão chamado BtnGerente
                    Cadastro_Gerente.BtnGerente.setEnabled(true); // Habilita o botão para gerentes
                } else {
                    Cadastro_Gerente.BtnGerente.setEnabled(false); // Desabilita para outros tipos
                }

                // Exibe mensagem de boas-vindas ou outra lógica de interface
                JOptionPane.showMessageDialog(null, "Bem-vindo, " + funcionario.getNomeFuncionario());

                // Aqui você pode redirecionar para a tela principal ou outro painel
                // Exemplo: abrirTelaPrincipal();
                
            } else {
                // Se o login falhar
                JOptionPane.showMessageDialog(null, "Login ou senha inválidos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
        }
    }
}
