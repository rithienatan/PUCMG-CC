package builder;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ItensPrototype> lista = new ArrayList<ItensPrototype>();
		
		ItemHardware item = new ItemHardware();
		
		ItensPrototype item1 = item.clonar();
		item1.setValor(350.0);
		lista.add(item1);
		ItensPrototype item2 = item.clonar();
		item1.setValor(450.0);
		lista.add(item2);
		
		
		
		
		Diretor x = new Diretor(new ReciboMinas());
		
		x.constroi("Delta", 500.0,lista);
		
		Recibo rec = x.getRecibo();
		
		System.out.println(rec.getEmpresa()+rec.getValor());
		
		
		
		
	}

}
