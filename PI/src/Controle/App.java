package Controle;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Usando SwingUtilities para garantir que a GUI seja criada na thread de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             
            	ControleDeLogin login = new ControleDeLogin();
            	login.iniciar();
            }
        });
    }
}	