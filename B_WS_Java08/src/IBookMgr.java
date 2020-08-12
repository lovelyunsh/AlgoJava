import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);
	ArrayList<Book> search();
	void sell(String isbn,int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn,int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	
}
