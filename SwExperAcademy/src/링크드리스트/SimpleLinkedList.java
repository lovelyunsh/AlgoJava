package 링크드리스트;

public class SimpleLinkedList {
	private Node head;

	public void addFirstNode(String data) {
		Node newNode = new Node(data, head);
		head = newNode;
	}
	public String pop() {
		String result = head.data;
		head = head.link;
		return result;
	}
	
	public void printList() {
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data);
		}
		System.out.println();
	}
}
