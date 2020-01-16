package builder;

import java.util.ArrayList;

public class Recibo {
	
	private ArrayList<ItensPrototype> listaItens;
	private int identificador;
	private double valor;
	private String empresa;
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public ArrayList<ItensPrototype> getListaItens() {
		return listaItens;
	}
	public void setListaItens(ArrayList<ItensPrototype> listaItens) {
		this.listaItens = listaItens;
	}

}
