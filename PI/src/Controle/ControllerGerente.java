package Controle;

import visao.Cadastro_Gerente;
import visao.TelaGeFunci;
import visao.telaInicial;

public class ControllerGerente {

	public void TelaInicial() {

		telaInicial tela = new telaInicial();
		
		tela.setVisible(true);
		
	}
	public void FUnfo() {

		TelaGeFunci Abrir = new TelaGeFunci();
		Abrir.setVisible(true);

	}
	public void TelaCadastro() {
		Cadastro_Gerente abrir = new Cadastro_Gerente();
		abrir.setVisible(true);
	}
	

}
