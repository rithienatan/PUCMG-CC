package builder;

import java.util.Random;

public class GeraIdentificador {
	
	private static GeraIdentificador instance = null;
	
	private GeraIdentificador() {
		
	}
	
	public static GeraIdentificador getInstance() {
		
		if(instance==null) {
			instance = new GeraIdentificador();
		}
			
		return instance;
	}
	
	public int getNumeroIdentificador() {
		return new Random().nextInt();
	}

}
