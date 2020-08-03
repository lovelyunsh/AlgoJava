package 링크드리스트;

public class node {
	
	String data;
	node link; // node link = new node() 노드의 레퍼런스 가져야하니깐
	
	


	public node(String data) {
		super();
		this.data = data;
	}




	public node(String data, node link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	
	

}
