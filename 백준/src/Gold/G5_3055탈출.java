package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_3055탈출 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean visit[][] = new boolean[R][C];
		Queue<Point> water = new LinkedList<Point>();
		Queue<Point> go = new LinkedList<Point>();
		char map[][] = new char[R][C];
		for (int i = 0; i < R; i++) {
			String S = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j);
				if (map[i][j] == '*')
					water.add(new Point(i, j));
				if (map[i][j] == 'S') {
					go.add(new Point(i, j));
					visit[i][j] = true;
				}
			}
		}
		int dr[] = { 1, -1, 0, 0 };
		int dc[] = { 0, 0, 1, -1 };
		int time = 0;
		boolean flag = false;

		gg: while (!go.isEmpty()) {
			time++;
			for (int s = water.size(); s > 0; s--) {
				Point now = water.poll();
				for (int i = 0; i < 4; i++) {
					int row = now.x + dr[i];
					int col = now.y + dc[i];
					if (row < 0 || col < 0 || row >= R || col >= C)
						continue;
					if (map[row][col] == 'X' || map[row][col] == '*' || map[row][col] == 'D')
						continue;
					map[row][col] = '*';
					water.offer(new Point(row, col));

				}
			}

			for (int s = go.size(); s > 0; s--) {
				Point now = go.poll();
				for (int i = 0; i < 4; i++) {
					int row = now.x + dr[i];
					int col = now.y + dc[i];
					if (row < 0 || col < 0 || row >= R || col >= C)
						continue;
					if (map[row][col] == 'X' || map[row][col] == '*')
						continue;
					if (visit[row][col])
						continue;
					if (map[row][col] == 'D') {
						flag = true;
						break gg;
					}

					visit[row][col] = true;
					go.offer(new Point(row, col));
				}
			}

		}
		System.out.println(flag ? time : "KAKTUS");
	}

}
