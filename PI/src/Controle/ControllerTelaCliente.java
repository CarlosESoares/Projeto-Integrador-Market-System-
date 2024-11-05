package Controle;

import visao.TelaCadastroCliente;
import visao.TelaEstoque;
import visao.telaInicial;

public class ControllerTelaCliente {
	public void AbrirTelaCliente(){
		TelaCadastroCliente Tela = new TelaCadastroCliente();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
	}

	public void AbrirTelaEstoque() {
		TelaEstoque Tela = new TelaEstoque();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}
		
}
		

