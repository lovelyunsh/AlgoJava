import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P81304미로탈출 {
	// visit 2개
	// 1번길 2번길
	// 노드마다 현재 몇번길인지 가지고 다녀
	// pq로 다익스트라를 하는데 길을 가지고 다니는것
	static class node implements Comparable<node> {
		int num;
		int cost;
		int roadnum;

		public node(int num, int cost, int roadnum) {
			super();
			this.num = num;
			this.cost = cost;
			this.roadnum = roadnum;
		}

		@Override
		public int compareTo(node o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) {
		solution(4, 1, 4,new int [][] {{1, 2,1},{3,2,1},{2,4,1}},new int []{2,3});
	}
	static public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;
		boolean[] trap = new boolean[n + 1];
		ArrayList<Point>[] road0 = new ArrayList[n + 1];
		ArrayList<Point>[] road1 = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			road0[i] = new ArrayList<Point>();
			road1[i] = new ArrayList<Point>();
		}

		for (int i : traps)
			trap[i] = true;
		for (int i = 0; i < roads.length; i++) {
			road0[roads[i][0]].add(new Point(roads[i][1], roads[i][2]));
			road1[roads[i][1]].add(new Point(roads[i][0], roads[i][2]));
		}
		answer = dij(n, road0, road1, start, end, trap);
		return answer;
	}

	static int dij(int n, List<Point>[] road0, List<Point>[] road1, int start, int end, boolean[] trap) {
		int visit[][] = new int[2][n + 1];
		for (int i = 0; i < 2; i++)
			Arrays.fill(visit[i], 987654321);
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.add(new node(start, 0, 0));
		while (!pq.isEmpty()) {
			node now = pq.poll();
			if(visit[now.roadnum][now.num] <now.cost)
				continue;
			List<Point> [] road = now.roadnum == 0 ? road0 : road1;
			for(Point p : road[now.num]) {
				int nowroad =  trap[p.x] ? (now.roadnum+1)%2 : now.roadnum;
				if(visit[nowroad][p.x] <now.cost+p.y)
					continue;
				visit[nowroad][p.x] = now.cost+p.y;
				pq.add(new node(p.x,now.cost+p.y , nowroad));
			}
		}
		return Math.min(visit[0][end], visit[1][end]);
	}
}
