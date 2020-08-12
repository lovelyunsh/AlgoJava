
public class Book {
	String isbn;
	String title;
	int price;
	int quantity;
	



	public Book(String isbn, String title, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}





	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity=" + quantity;
	}





	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getYear() {
		return 0;
	}
	
	public int getMonth() {
		return 0;
	}
	

}
