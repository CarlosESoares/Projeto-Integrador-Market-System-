package modelo;

public class ControleVendas {
private int IdVendas;
private int QtdVendas;
private String NomeCliente;
private String SobrenomeCliente;
private String TelefoneCliente;
private Double Credito;
private String CpfFuncionario;
public int getIdVendas() {
	return IdVendas;
}
public void setIdVendas(int idVendas) {
	IdVendas = idVendas;
}
public int getQtdVendas() {
	return QtdVendas;
}
public void setQtdVendas(int qtdVendas) {
	QtdVendas = qtdVendas;
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
public String getTelefoneCliente() {
	return TelefoneCliente;
}
public void setTelefoneCliente(String telefoneCliente) {
	TelefoneCliente = telefoneCliente;
}
public Double getCredito() {
	return Credito;
}
public void setCredito(Double credito) {
	Credito = credito;
}
public String getCpfFuncionario() {
	return CpfFuncionario;
}
public void setCpfFuncionario(String cpfFuncionario) {
	CpfFuncionario = cpfFuncionario;
}

}

