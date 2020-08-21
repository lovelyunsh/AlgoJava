package product;


public class DuplicateException extends RuntimeException{
	public DuplicateException(String name) {
		super(name +"(은)는 이미 존재합니다.");
	}
}
