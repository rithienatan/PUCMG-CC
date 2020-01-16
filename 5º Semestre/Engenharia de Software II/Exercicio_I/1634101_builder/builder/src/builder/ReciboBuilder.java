package builder;

import java.util.ArrayList;

public abstract class ReciboBuilder {
	
	protected Recibo rec;
	
	public ReciboBuilder() {
		rec = new Recibo();
	}
	
	public abstract void paraEmpresa(String empresa);
	public abstract void comValor(Double valor);
	
	public void geraIdentificador() {
		GeraIdentificador num = GeraIdentificador.getInstance();
		rec.setIdentificador(num.getNumeroIdentificador());
	}

	public Recibo getRecibo() {
		return rec;
	}
	
	public final void adicionaItens(ArrayList<ItensPrototype> lista) {
		rec.setListaItens(lista);
	}
	
	
}
