package rangonaweb.entity;

public class Endereco {
	
	private String rua, cep, cidade, bairro, estado, numero;
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Endereco() {
		
		
	}
	
	public Endereco(String rua, String cep, String cidade, String bairro, String estado, String numero) {
		setBairro(bairro);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setNumero(numero);
		setRua(rua);
	}
}
