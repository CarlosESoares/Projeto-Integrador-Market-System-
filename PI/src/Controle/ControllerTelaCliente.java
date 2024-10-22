package Controle;

import visao.TelaCadastroCliente;
import visao.TelaEstoque;
import visao.telaInicial;

public class ControllerTelaCliente {
	public void AbrirTelaCliente(){
		TelaCadastroCliente Tela = new TelaCadastroCliente();
		
		Tela.setVisible(true);
	}

	public void AbrirTelaEstoque() {
		TelaEstoque Tela = new TelaEstoque();
		
		Tela.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial();
		
		Tela.setVisible(true);
		
	}
		
}
		

