package Controle;

import javax.swing.SwingUtilities;

import visao.Login;

public class App {
    public static void main(String[] args) {
        // Usando SwingUtilities para garantir que a GUI seja criada na thread de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Criar e exibir a tela de Login
                //Login login = new Login();
                //login.setVisible(true);
            	ControleDeLogin login = new ControleDeLogin();
            	login.iniciar();
            }
        });
    }
}