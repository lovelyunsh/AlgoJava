package 링크드리스트;

public class SimpleLinkedList {
	private node head;

	public void addFirstNode(String data) {
		node newNode = new node(data, head);
		head = newNode;
	}
	public String pop() {
		String result = head.data;
		head = head.link;
		return result;
	}
	
	public void printList() {
		for (node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data);
		}
		System.out.println();
	}
}
