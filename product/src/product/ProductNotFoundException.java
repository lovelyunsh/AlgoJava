package product;


public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String target) {
		super(target +"이 존재하지 않습니다.");
	}
	
}
