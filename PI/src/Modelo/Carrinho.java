package Modelo;

public class Carrinho {
private int IdCarrinho;
private int IdProduto;
private int Quantidade;
private Double PrecoTotal;
private String CpfCliente;
public int getIdCarrinho() {
	return IdCarrinho;
}
public void setIdCarrinho(int idCarrinho) {
	IdCarrinho = idCarrinho;
}
public int getIdProduto() {
	return IdProduto;
}
public void setIdProduto(int idProduto) {
	IdProduto = idProduto;
}
public int getQuantidade() {
	return Quantidade;
}
public void setQuantidade(int quantidade) {
	Quantidade = quantidade;
}
public Double getPrecoTotal() {
	return PrecoTotal;
}
public void setPrecoTotal(Double precoTotal) {
	PrecoTotal = precoTotal;
}
public String getCpfCliente() {
	return CpfCliente;
}
public void setCpfCliente(String cpfCliente) {
	CpfCliente = cpfCliente;
}

}
