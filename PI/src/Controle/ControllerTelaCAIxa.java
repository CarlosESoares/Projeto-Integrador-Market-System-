package Controle;

import visao.TelaDoCaixa;
import visao.telaInicial;

public class ControllerTelaCAIxa {

	public void AbrirTelaCaixa(){

		telaInicial tela = new telaInicial();
		
		tela.setVisible(true);
	
	}

	public void AbrirCaixa() {
		// TODO Auto-generated method stub
		TelaDoCaixa tela = new TelaDoCaixa();
		tela.setVisible(true);
		
	}
}
