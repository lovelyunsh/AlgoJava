package 링크드리스트;

public class MystackTest {

	public static void main(String[] args) {
		Mystack test = new Mystack();
		test.push("hello");
		System.out.println(test.peek());
		System.out.println(test.isEmplty());
		System.out.println(test.pop());
		System.out.println(test.isEmplty());
	}

}
