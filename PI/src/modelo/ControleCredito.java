package modelo;

public class ControleCredito {
private String Parcela;
private String Cpf;
private String NomeCliente;
private String SobrenomeCliente;
private float PagamentoPendente;
private Double ValorParcela;
public String getParcela() {
	return Parcela;
}
public void setParcela(String parcela) {
	Parcela = parcela;
}
public String getCpf() {
	return Cpf;
}
public void setCpf(String cpf) {
	Cpf = cpf;
}
public String getNomeCliente() {
	return NomeCliente;
}
public void setNomeCliente(String nomeCliente) {
	NomeCliente = nomeCliente;
}
public String getSobrenomeCliente() {
	return SobrenomeCliente;
}
public void setSobrenomeCliente(String sobrenomeCliente) {
	SobrenomeCliente = sobrenomeCliente;
}
public float getPagamentoPendente() {
	return PagamentoPendente;
}
public void setPagamentoPendente(float pagamentoPendente) {
	PagamentoPendente = pagamentoPendente;
}
public Double getValorParcela() {
	return ValorParcela;
}
public void setValorParcela(Double valorParcela) {
	ValorParcela = valorParcela;
}
}
