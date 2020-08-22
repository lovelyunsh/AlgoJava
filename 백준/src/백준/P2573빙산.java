package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573빙산 {
	static int ice, N, M, year, map[][], max;
	static Point maxp = new Point();
	static boolean visit[][];
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	/**
	 * 1. 총 얼음의 갯수를 세어둔다. 2. 1년 뒤의 변화를 위해 bfs로 어느 한 얼음부터 얼음 하나하나 방문 3. 몇번 방문한지 세고 얼음
	 * 갯수랑 비교 4. 총 얼음갯수와 방문수가 다르면 다른위치에도 얼음이 있으니 분리 되어진것이므로 year출력
	 */
	public static int oneyear(int map[][]) { // 다음년도꺼 빙산 만들기와 올해 빙산 몇개인지 검사 동시에
		int[][] c_map = map.clone();
		visit = new boolean[N][M];
		int nowice = ice; // 올해 검사용
		Queue<Point> que = new LinkedList<Point>();
		que.offer(maxp);
		int cnt = 1; // 연결된 ice갯수
		visit[maxp.x][maxp.y] = true;
		max = 0;
		while (!que.isEmpty()) {

			Point now = que.poll(); // 검사할 점
			int zero = 0; // 현재 점 주변 0
			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (visit[row][col] == true)
					continue;

				if (map[row][col] == 0)
					zero++;
				else {
					que.offer(new Point(row, col));
					visit[row][col] = true;
					cnt++;
				}
			}
			c_map[now.x][now.y] -= zero;
			if (max < c_map[now.x][now.y]) {
				max = c_map[now.x][now.y];
				maxp.setLocation(now.x, now.y);
			}
			if (c_map[now.x][now.y] <= 0) {
				c_map[now.x][now.y] = 0;
				ice--; // 다음 년 검사를 위한 ice;
			}
		}
		if (nowice != cnt)
			return year;

		year++;
		if (ice == 0)
			return 0;
		map = c_map;
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					ice++;
					if (max < map[i][j]) {
						max = map[i][j];
						maxp.setLocation(i, j);
					}
				}
			}
		}
		int result = 0;
		while (true) {
			result = oneyear(map);
			if (result != -1)
				break;
		}
		System.out.println(result);

	}

}
