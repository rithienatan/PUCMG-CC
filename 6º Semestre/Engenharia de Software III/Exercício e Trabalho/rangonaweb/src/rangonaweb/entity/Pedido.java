package rangonaweb.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import rangonaweb.enumerations.MenuBebidas;
import rangonaweb.enumerations.MenuQuentinha;

public class Pedido {
	
	private Cliente cliente;
	private MenuQuentinha quentinha;
	private MenuBebidas bebida;
	private LocalDateTime horaEntrega;
	private Integer quantidade; 
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public MenuQuentinha getQuentinha() {
		return quentinha;
	}
	public void setQuentinha(MenuQuentinha quentinha) {
		this.quentinha = quentinha;
	}
	public MenuBebidas getBebida() {
		return bebida;
	}
	public void setBebida(MenuBebidas bebida) {
		this.bebida = bebida;
	}
	public LocalDateTime getHoraEntrega() {
		return horaEntrega;
	}
	public void setHoraEntrega(LocalDateTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	public Pedido() {
	}
	public Pedido(Cliente cliente , MenuQuentinha quentinha , MenuBebidas bebida, LocalDateTime horaEntrega, Integer quantidade) {
		setBebida(bebida);
		setCliente(cliente);
		setHoraEntrega(horaEntrega);
		setQuentinha(quentinha);	
		setQuantidade(null); //erro proposital
		
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return ""+
				getCliente().getNome() + "\n" +
				getCliente().getCpf() + "\n" +
				getCliente().getEndereco().getRua()+ ", " + getCliente().getEndereco().getBairro()+ ", " + getCliente().getEndereco().getCidade()+
				", " + getCliente().getEndereco().getNumero()+ "\n" + 
				getQuentinha() + " \n"+
				getBebida() + " \n" +
				getHoraEntrega().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n"+
				getQuantidade();
	}
}
