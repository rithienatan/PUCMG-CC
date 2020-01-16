package builder;

public class ReciboMinas extends ReciboBuilder{

	@Override
	public void paraEmpresa(String empresa) {
		rec.setEmpresa(empresa);
		
	}

	@Override
	public void comValor(Double valor) {
		// TODO Auto-generated method stub
		rec.setValor(valor+valor*0.7);
	}

}
