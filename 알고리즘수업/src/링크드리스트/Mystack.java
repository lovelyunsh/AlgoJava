package 링크드리스트;

class mynode {
	String data;
	mynode link;

	public mynode(String data, mynode link) {
		super();
		this.data = data;
		this.link = link;
	}

}

public class Mystack {
	private mynode head;

	void push(String data) {
		mynode newnode = new mynode(data, head);
		head = newnode;
	}

	String pop() {
		if (head == null) return null;
		String data = head.data;
		head = head.link;
		return data;
	}

	String peek() {
		return head == null ? null : head.data;
	}

	boolean isEmplty() {
		return head == null;
	}

}
