package product;


public class TV extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int inch;
	public TV(int price, int no, String name, int stock, int inch) {
		super(price, no, name, stock);
		this.inch = inch;
	}
	
	
	public int getInch() {
		return inch;
	}


	public TV() {
		super();
	}


	public void setInch(int inch) {
		this.inch = inch;
	}


	public TV(int price, int no, String name, int stock) {
		super(price, no, name, stock);
	}


	@Override
	public String toString() {
		return "TV [inch=" + inch + ", price=" + price + ", No=" + No + ", Name=" + Name + ", Stock=" + Stock + "]";
	}
	
	
	
	
}
