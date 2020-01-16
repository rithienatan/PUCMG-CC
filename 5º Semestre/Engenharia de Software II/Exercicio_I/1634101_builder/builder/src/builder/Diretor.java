package builder;

import java.util.ArrayList;



public class Diretor {
	
	protected ReciboBuilder recibo;
	
	public Diretor(ReciboBuilder recibo) {
		this.recibo = recibo;
	}
	
	public void constroi(String empresa, Double valor, ArrayList<ItensPrototype> lista) {
		recibo.comValor(valor);
		recibo.paraEmpresa(empresa);
		recibo.geraIdentificador();
		recibo.adicionaItens(lista);
	}
	
	
	public Recibo getRecibo() {
		return recibo.getRecibo();
	}
	
	

}
