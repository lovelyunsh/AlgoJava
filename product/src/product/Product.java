package product;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int price;
	int No;
	String Name;
	int Stock;
	
	public Product(int price, int no, String name, int stock) {
		super();
		this.price = price;
		No = no;
		Name = name;
		Stock = stock;
	}

	
	public Product() {
		super();
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getNo() {
		return No;
	}


	public void setNo(int no) {
		No = no;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public int getInch() {
		return 0;
		};
	public int getVolume() {
		return 0;
	}
	@Override
	public String toString() {
		return "product [price=" + price + ", No=" + No + ", Name=" + Name + ", Stock=" + Stock + "]";
	}

	
	

}
