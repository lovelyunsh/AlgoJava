package product;


public class CodeNotFoundException extends RuntimeException {
	public CodeNotFoundException(int No) {
		super(No + "에 해당하는 상품이 없습니다.");
	}
}
