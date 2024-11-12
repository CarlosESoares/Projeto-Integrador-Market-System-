package Modelo;

import visao.TelasErro.ErroDeValidacao;

public class Erro {
	
	public Erro(String mensagem) {
		ErroDeValidacao tela = new ErroDeValidacao();
		tela.setVisible(true);
	}
}
