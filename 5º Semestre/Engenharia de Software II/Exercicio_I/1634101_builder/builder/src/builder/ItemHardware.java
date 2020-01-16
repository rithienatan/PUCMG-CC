package builder;

public class ItemHardware extends ItensPrototype {

		
	protected ItemHardware(ItemHardware itemHardware) {
		this.setValor(itemHardware.getValor());
		// TODO Auto-generated constructor stub
	}
	
	public ItemHardware() {
		this.setValor(0.0);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ItensPrototype clonar() {
		// TODO Auto-generated method stub
		return new ItemHardware(this);
	}
	

}
