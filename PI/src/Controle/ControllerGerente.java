package Controle;

import visao.Cadastro_Gerente;
import visao.TelaGerente;
import visao.telaInicial;

public class ControllerGerente {

	public void TelaInicial() {

		telaInicial tela = new telaInicial();
		
		tela.setVisible(true);
		
	}
	public void AbrirTelaFunfionario() {
		//Abrindo tela do funcionario
		Cadastro_Gerente tela = new Cadastro_Gerente();
		tela.setVisible(true);
		
	}
	public void TelaCadastro() {
		//abrindo tela do Cadastro
		Cadastro_Gerente abrir = new Cadastro_Gerente();
		abrir.setVisible(true);
	}
	public void TelaGerent() {
		//Abrindo tela do gerente
		TelaGerente abrir = new TelaGerente();
		abrir.setVisible(true);
		Cadastro_Gerente fechar = new Cadastro_Gerente();
		fechar.setVisible(false);
	}
	

}
