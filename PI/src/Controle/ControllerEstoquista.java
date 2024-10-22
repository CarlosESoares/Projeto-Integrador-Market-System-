package Controle;

import visao.Login;
import visao.TelaEstoque;
import visao.telaInicial;

public class ControllerEstoquista {
	public void AbrirTelaEstoquista() {
		

		telaInicial tela = new telaInicial();
		
		tela.setVisible(true);

	}

	public void AbrirTelaEstoque() {
		TelaEstoque tela2 = new TelaEstoque();
		tela2.setVisible(true);
		
	}
	public void AbrirTelaInicial() {
		telaInicial Tela = new telaInicial();
		
		Tela.setVisible(true);
		
	}

}
