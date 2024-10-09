package Modelo;

import java.time.LocalDate;
import java.util.Date;

public class Produto {
private int IdProduto;
private String Nome;
private String Data;
private String DataValidade;
private int Qntd;
private Double Preco;
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
public String getData() {
	return Data;
}
public void setData(String data) {
	Data = data;
}
public String getDataValidade() {
	return DataValidade;
}
public void setDataValidade(String dataValidade) {
	DataValidade = dataValidade;
}
public int getQntd() {
	return Qntd;
}
public void setQntd(int qntd) {
	Qntd = qntd;
}
public Double getPreco() {
	return Preco;
}
public void setPreco(Double preco) {
	Preco = preco;
}}
