package Controle;

import Modelo.VendaDAO;
import visao.RelatorioVenda;
import visao.TelaVendas;


public class ControllerTelaVendas {
	VendaDAO dao = new VendaDAO();
	
	public void AbrirTelaVendas(){

		TelaVendas tela = new TelaVendas();
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	
		
	}
	public void Relatorio(){
		RelatorioVenda abrir = new RelatorioVenda();
		abrir.setLocationRelativeTo(null);
		abrir.setVisible(true);
	}
}
