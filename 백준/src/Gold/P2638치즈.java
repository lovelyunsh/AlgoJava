package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2638치즈 {
	static int map[][], M, N, size;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int time = 0;
		while (true) {
			fillair();
			if (size == 0)
				break;
			time++;
		}
		System.out.println(time);
	}

	static void fillair() {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(0, 0));
		boolean visit[][] = new boolean[M][N];
		visit[0][0] = true;
		int clonemap[][] = new int[M][N];
		size = 0;
		for (int i = 0; i < M; i++)
			clonemap[i] = map[i].clone();

		while (!que.isEmpty()) {
			Point now = que.poll();
			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (row < 0 || col < 0 || row >= M || col >= N)
					continue;
				if (map[row][col] == 1) {
					if(visit[row][col] && clonemap[row][col] != 0) {
						clonemap[row][col] = 0;
						size++;
						continue;
					}
					visit[row][col] = true;
					continue;
				}
				if (visit[row][col])
					continue;
				visit[row][col] = true;
				que.offer(new Point(row, col));
			}
		}
		map = clonemap;
	}
}
