package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2468안전영역 {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int dept;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	static boolean dfs(Point p) {
		if (visited[p.x][p.y])
			return false;
		visited[p.x][p.y]= true; 
		for (int i = 0; i < 4; i++) {
			int row = p.x + dr[i];
			int col = p.y + dc[i];
			if (row < 0 || row >= N || col < 0 || col >= N)
				continue;
			if (map[row][col] <= dept)
				continue;
			if (visited[row][col])
				continue;
			dfs(new Point(row, col));
		}

		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		int max = 0;
		int min = 9919121;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
				min = Math.min(map[i][j], min);
			}
		}
		int result = 1;
		for (dept = min; dept < max; dept++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					if (map[i][j] > dept) {
						Point p = new Point(i, j);
						if (dfs(p))
							cnt++;
					}
				}
			result = Math.max(cnt, result);
		}

		System.out.println(result);

	}

}
