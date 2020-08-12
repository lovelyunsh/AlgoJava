import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	ArrayList<Book> booklist = new ArrayList<>();
	private BookMgrImpl() {}
	static BookMgrImpl mgr;
	static public BookMgrImpl make_BookMgr() {
		if(mgr == null)
			mgr = new BookMgrImpl();
		return mgr;
	}
	
	@Override
	public void add(Book b) {
		booklist.add(b);
	}

	@Override
	public ArrayList<Book> search() {
		return booklist;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		for(Book b :booklist) {
			if(b.getIsbn().equals(isbn)) {
				if(b.getQuantity() < quantity)throw new QuantityException("책 부족해");
				b.setQuantity(b.getQuantity() - quantity);
				return;
			}
		}
		throw new ISBNNotFoundException("책 찾을 수 없어");
		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for(Book b :booklist) {
			if(b.getIsbn().equals(isbn)) {
				b.setQuantity(b.getQuantity() + quantity);
				return;
			}
		}
		throw new ISBNNotFoundException("책 찾을 수 없어");
				
	}

	@Override
	public int getTotalAmount() {
		

		return booklist.size();
	}


}
