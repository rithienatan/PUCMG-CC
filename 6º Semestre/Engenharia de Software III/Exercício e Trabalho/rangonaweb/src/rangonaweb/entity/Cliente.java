package rangonaweb.entity;

public class Cliente {
	
	private String nome, cpf;
	private Endereco endereco;
	
	
	public Cliente() {
		
		
	}
	
	public Cliente(String cpf, String nome, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	
}
