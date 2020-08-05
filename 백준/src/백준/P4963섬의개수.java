package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963섬의개수 {
	static int map[][];
	static boolean visited[][];
	static int dr[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int H;
	static int W;

	static int dfs(int r, int c) {
		if (visited[r][c])
			return 0;
		visited[r][c] = true;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= H || nc >= W)
				continue;
			if (map[nr][nc] == 0)
				continue;
			if (visited[nr][nc])
				continue;
			dfs(nr, nc);

		}

		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0)
				break;
			// 1 땅 2 바다
			map = new int[H][W];
			visited = new boolean[H][W];
			Queue<Point> land = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						land.offer(new Point(i, j));
					}
				}
			}
			int result = 0;
			while (!land.isEmpty()) {
				Point p = land.poll();
				result += dfs(p.x, p.y);
			}
			System.out.println(result);
		}

	}

}
