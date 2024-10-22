package Controle;

import visao.TelaCadastroCliente;
import visao.TelaEstoque;

public class ControllerTelaCliente {
	public void AbrirTelaCliente(){
		TelaCadastroCliente Tela = new TelaCadastroCliente();
		
		Tela.setVisible(true);
	}

	public void AbrirTelaEstoque() {
		TelaEstoque Tela = new TelaEstoque();
		
		Tela.setVisible(true);
		
	}
		
}
