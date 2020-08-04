package 그래프;

public class 서로소그래프 {
	static int[] parent;
	static int[] rank;
	static int find(int x) {
		if( parent[x] == x )
			return x;
		parent[x] = find(parent[x]);
		return find(parent[x]);
	}
	static void union(int x , int y) {
		int px = find(x);
		int py = find(y);
		
		if(rank[px] > rank[py])
			parent[py] = px;
		else if(rank[px] < rank[py])
			parent[px] = py;
		else {
			parent[px] = py;
			rank[py]++;
		}
	}
	
	public static void main(String[] args) {
		//원소는 7개가 있다고 하자. 첫번째 원소는 0이고 일곱번째 원소는 6이다.
		parent = new int[7];
		//parnt[0]은 원소 0의 부모의 번호가 저장될 곳
		
		// 처음엔. 모두가 각자가 혼자로서의 집합으로 스스로가 대표자인 상황,
		for(int i = 0 ; i < 7 ; i++)
			parent[i] = i;
		union(1,3);
		System.out.println(find(3));
		union(6,1);
		System.out.println(find(3));
		union(3,4);
		System.out.println(find(4));
	}
}
