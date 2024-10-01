package Controle;

import java.time.LocalDate;
import java.util.Date;

public class Produto {
private int IdProduto;
private String Nome;
private String tipoProduto;
private LocalDate dataValidade;
private int qntd;
private Double preco;
public int getIdProduto() {
	return IdProduto;
}
public void setIdProduto(int idProduto) {
	IdProduto = idProduto;
}
public String getNome() {
	return Nome;
}
public void setNome(String nome) {
	Nome = nome;
}
public String getTipoProduto() {
	return tipoProduto;
}
public void setTipoProduto(String tipoProduto) {
	this.tipoProduto = tipoProduto;
}
public LocalDate getDataValidade() {
	return dataValidade;
}
public void setDataValidade(LocalDate dataValidade) {
	this.dataValidade = dataValidade;
}
public int getQntd() {
	return qntd;
}
public void setQntd(int qntd) {
	this.qntd = qntd;
}
public Double getPreco() {
	return preco;
}
public void setPreco(Double preco) {
	this.preco = preco;
}

}
