package Controle;

import visao.TelaEstoque;
import visao.telaInicial;

public class ControllerEstoquista {
	public void AbrirTelaEstoquista() {
		
		
		TelaEstoque tela = new TelaEstoque();
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		
	}

	public void AbrirTelaEstoque() {
		TelaEstoque tela2 = new TelaEstoque();
		tela2.setLocationRelativeTo(null);
		tela2.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial();
		Tela.setLocationRelativeTo(null);
		Tela.setVisible(true);
		
	}

}
