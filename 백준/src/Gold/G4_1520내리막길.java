package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1520내리막길 {

	static class point implements Comparable<point> {
		int x;
		int y;
		int height;

		point(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(point o) {
			return o.height - this.height;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[M][N];
		int count[][] = new int[M][N];
		boolean visit[][] = new boolean[M][N];
		int dr[] = { 1, -1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count[0][0] = 1;
		PriorityQueue<point> que = new PriorityQueue<point>();
		que.add(new point(0, 0, map[0][0]));
		while (!que.isEmpty()) {
			point now = que.poll();

			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (row < 0 || col < 0 || row >= M || col >= N)
					continue;
				if(map[now.x][now.y] <= map[row][col])
					continue;
				count[row][col] += count[now.x][now.y];
				if(visit[row][col])
					continue;
				
				visit[row][col] = true;
				que.offer(new point(row, col, map[row][col]));
			}
		}
		System.out.println(count[M-1][N-1]);

	}

}
