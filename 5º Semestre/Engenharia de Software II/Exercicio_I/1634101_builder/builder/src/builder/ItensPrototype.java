package builder;

public abstract class ItensPrototype {

	private Double valor;

	public abstract ItensPrototype clonar();
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
