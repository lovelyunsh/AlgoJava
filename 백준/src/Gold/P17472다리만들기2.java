package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P17472다리만들기2 {

	static int N, M, Map[][];
	static int groupNum = 1;
	static boolean visit[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int Matrix[][];

	public static void main(String[] args) throws Exception {

		// 일단 bfs로 모든 땅 그룹화
		// 땅에서 갈수 있는 모든길 탐색?
		// 끝에 도달하면 길 삭제 다른 땅 만나면 인접행렬에 거리랑 땅 추가
		// 같은 땅이면 거리 더 작은걸로 추가
		// 크루스칼 고고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) { // 모든점 검사해서 bfs로 그룹핑 해보자
			for (int j = 0; j < M; j++) {
				if (Map[i][j] == 0)
					continue;
				if (visit[i][j])
					continue;
				grouping(i, j);
				groupNum++;
			}
		}
		
		Matrix = new int[groupNum][groupNum]; // 인접 행렬 마지막 그룹숫자 +1 되어있음
		// 각 땅에서 갈 수 있는 방향으로 다 펼쳐서 인접행렬 완성하자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { // 땅이라면 모든 방향으로 펼쳐보자
				if (Map[i][j] == 0)
					continue;
				spread(i, j);

			}
		}
		//크루스칼 귀찮다아아아
		ArrayList<Node> nodelist = new ArrayList<Node>();
		//인접행렬 꺼내다 노드리스트에 ㄱㄱ 안겹치게 넣어야지
		for(int i = 1 ; i < groupNum ; i++) {
			for(int j = i+1 ; j < groupNum ; j++) {
				if(Matrix[i][j] == 0)
					continue;
				nodelist.add(new Node(i, j, Matrix[i][j]));
			}
		}
		
		Collections.sort(nodelist);
		int result = 0;
		parents = new int [groupNum];
		for(int i = 0 ; i < groupNum ; i++)
			parents[i] = i;
		int cnt = 0;
		for(Node node : nodelist) {
			if(find(node.from) == find(node.to))
				continue;
			union(node.from,node.to);
			cnt++;
			result += node.dist;
			if(cnt == groupNum -2)
				break;
		}
		if(cnt < groupNum -2)
			result = -1;
		System.out.println(result);
		


	}
	static int parents[];
	static void union(int i, int j) {
		int px = find(i);
		int py = find(j);
		
		parents[px] = py;
		
	}
	static int find(int i) {
		
		if(i == parents[i])
			return i;
		
		return parents[i] = find(parents[i]);
	}
	
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int dist;
		public Node(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
		
	}

	static void grouping(int i, int j) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(i, j));
		visit[i][j] = true;
		Map[i][j] = groupNum;
		while (!que.isEmpty()) {
			Point now = que.poll();
			for (int d = 0; d < 4; d++) {
				int row = now.x + dr[d];
				int col = now.y + dc[d];
				if (row < 0 || col < 0 || row >= N || col >= M)
					continue;
				if (Map[row][col] == 0)
					continue;
				if (visit[row][col])
					continue;
				visit[row][col] = true;
				Map[row][col] = groupNum;
				que.offer(new Point(row, col));
			}
		}
	}

	static void spread(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int row = i;
			int col = j;
			int me = Map[i][j];
			int dist = 0;
			while (true) {
				row = row + dr[d];
				col = col + dc[d];
				if (row < 0 || col < 0 || row >= N || col >= M)
					break;
				if (Map[row][col] == me)
					break;
				if (Map[row][col] != 0) {
					if(dist == 1)
						break;
					int target = Map[row][col];
					
					if (Matrix[me][target] == 0 || Matrix[me][target] > dist) { //안채워 졌거나 원래 거리보다 더 짧은 다리 일때만
						Matrix[me][target] = Matrix[target][me] = dist;
					}
					break;
				}
				dist++;
			}

		}

	}
}
