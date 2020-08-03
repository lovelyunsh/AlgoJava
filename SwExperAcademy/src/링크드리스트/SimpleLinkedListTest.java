package 링크드리스트;

public class SimpleLinkedListTest {

	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		
		
		list.addFirstNode("안녕1");
		list.addFirstNode("안녕2");
		list.addFirstNode("안녕3");
		list.addFirstNode("안녕4");
		list.addFirstNode("안녕5");
		list.addFirstNode("안녕6");
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list.pop());
	}

}
