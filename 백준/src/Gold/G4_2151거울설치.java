package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class G4_2151거울설치 {
	static class light implements Comparable<light> {
		int x;
		int y;
		int mirror;
		int dir;

		public light(int x, int y, int mirror, int dir) {
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.dir = dir;
		}

		@Override
		public int compareTo(light o) {
			return this.mirror - o.mirror;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char map[][] = new char[N][N];
		light start = null;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '#')
					start = new light(i, j, 0, 0);
			}
		}
		PriorityQueue<light> pq = new PriorityQueue<light>();
		boolean visit[][][] = new boolean[4][N][N];
		for (int i = 0; i < 4; i++) {
			pq.add(new light(start.x, start.y, 0, i));
			visit[i][start.x][start.y] = true;
		}

		int dr[] = { -1, 0, 1, 0 };
		int dc[] = { 0, 1, 0, -1 };
		int ans = 0;
		gg: while (!pq.isEmpty()) {
			light now = pq.poll();
			for (int i : new int[] { -1, 1,0 }) {
				if(map[now.x][now.y]!= '!' && i != 0  )
					continue;
				int dir = (now.dir + i + 4) % 4;
				int row = now.x + dr[dir];
				int col = now.y + dc[dir];
				int mirror = i == 0 ? now.mirror : now.mirror + 1;
				if (row < 0 || col < 0 || row >= N || col >= N || map[row][col] == '*')
					continue;
				if (visit[dir][row][col])
					continue;
				if (map[row][col] == '#') {
					ans = mirror;
					break gg;
				}
				visit[dir][row][col] = true;
				pq.add(new light(row, col, mirror, dir));
			}

		}
		System.out.println(ans);

	}

}
