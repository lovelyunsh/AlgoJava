package product;


public class Refrigerator extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int volume;
	public Refrigerator(int price, int no, String name, int stock, int volume) {
		super(price, no, name, stock);
		this.volume = volume;
		
	}
	
	
	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public Refrigerator() {
		super();
	}


	@Override
	public String toString() {
		return "Refrigerator [volume=" + volume + ", price=" + price + ", No=" + No + ", Name=" + Name + ", Stock="
				+ Stock + "]";
	}
	
	

	
	
}
