package D4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1953탈주범검거 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	static int shape[][] = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 크기
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken()); // row
			int C = Integer.parseInt(st.nextToken()); // col
			int L = Integer.parseInt(st.nextToken()); // 시간
			int map[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Point> que = new LinkedList<Point>();
			que.offer(new Point(R, C));
			boolean visited[][] = new boolean[N][M];

			visited[R][C] = true;
			int cnt = 1;
			int time = 1;
			while (!que.isEmpty()) {
				int size = que.size();
				if(time == L)
					break;
				for (int s = 0; s < size; s++) {
					Point now = que.poll();
					int sh = map[now.x][now.y];
					for (int i = 0; i < shape[sh].length; i++) {
						int row = now.x + dr[shape[sh][i]];
						int col = now.y + dc[shape[sh][i]];
						if (row < 0 || col < 0 || row >= N || col >= M)
							continue;
						if (map[row][col] == 0)
							continue;
						if (visited[row][col])
							continue;
						if(!check(shape[sh][i],map[row][col]))
							continue;
						cnt++;
						visited[row][col] = true;
						que.offer(new Point(row, col));
					}
				}
				time++;
			}
			System.out.println("#"+tc+" "+cnt);
		}

	}
	static boolean check(int dir , int sh) {
		int checkdir = (dir+2)%4;
		
		for(int i : shape[sh]) {
			if(i == checkdir)
				return true;
		}
		return false;
	}

}
