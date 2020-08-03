package 링크드리스트;

public class Node {
	
	String data;
	Node link; // node link = new node() 노드의 레퍼런스 가져야하니깐
	
	


	public Node(String data) {
		super();
		this.data = data;
	}




	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	
	

}
