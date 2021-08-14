package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_21610마법사상어와비바라기 {
	static int dr[] = { 100, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dc[] = { 100, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		Queue<Point> cloud = new LinkedList<Point>();
		Queue<Point> Scloud = new LinkedList<Point>();
		cloud.add(new Point(N - 1, 0));
		cloud.add(new Point(N - 1, 1));
		cloud.add(new Point(N - 2, 0));
		cloud.add(new Point(N - 2, 1));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int info = 0; info < M; info++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			while (!cloud.isEmpty()) { // 이동 비내리기
				Point now = cloud.poll();
				int row = now.x + dr[d] * s;
				int col = now.y + dc[d] * s;
				row = row%N<0 ? row%N+N : row%N;
				col = col%N<0 ? col%N+N : col%N;
				visit[row][col] = true;
				map[row][col]++;
				Scloud.add(new Point(row, col));
			}
			while (!Scloud.isEmpty()) {
				Point now = Scloud.poll();
				int water = 0;
				for (int i = 2; i <= 8; i += 2) {
					try {
						if (map[now.x + dr[i]][now.y + dc[i]] != 0)
							water++;
					} catch (Exception e) {
					}
				}
				map[now.x][now.y] += water;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j]) {
						visit[i][j] = false;
						continue;
					}
					if (map[i][j] >= 2) {
						map[i][j] -= 2;
						cloud.add(new Point(i, j));
					}
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				answer += map[i][j];
		System.out.println(answer);

	}

}
