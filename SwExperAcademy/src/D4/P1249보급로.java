package D4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1249보급로 {

	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };
	static boolean visited[][];
	static int map[][],N;
	static boolean findG;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			findG = false;
			for (int i = 0; i < N; i++) {
				String S = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(S.charAt(j) + "");
				}
			}

			Queue<Point> que = new LinkedList<Point>();
			que.offer(new Point(0, 0));
			visited[0][0] = true;
			int time = 0;
			gg:while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					Point now = que.poll();
					if (map[now.x][now.y] > 0) {
						map[now.x][now.y]--;
						que.offer(new Point(now.x, now.y));
						continue;
					}
					if (map[now.x][now.y] == 0) {
						for (int d = 0; d < 4; d++) {
							int row = now.x + dr[d];
							int col = now.y + dc[d];
							if(row<0 || col < 0 || row>=N || col >= N) 
								continue;
							if(visited[row][col])
								continue;
							visited[row][col] = true;
							if(row == N-1 && col == N-1) {
								break gg;
							}
							if(map[row][col]== 0) {
								find_zero(que,row,col);
								if(findG)
									break gg;
							}
							map[row][col]--;
							que.offer(new Point(row,col));
							
							
						}
					}
				}
				time++;
			}
			System.out.println("#"+tc+" "+time);
		}
	}
	static void find_zero(Queue<Point> que, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int row = x + dr[d];
			int col = y + dc[d];
			if(row<0 || col < 0 || row>=N || col >= N) 
				continue;
			if(visited[row][col])
				continue;
			if(row == N-1 && col == N-1) {
				findG = true;
				return;
			}
			if(map[row][col]== 0) {
				visited[row][col] = true;
				find_zero(que,row,col);
				if(findG)
					return;
			}
			visited[row][col] = true;
			map[row][col]--;
			que.offer(new Point(row,col));
		}
		
		
	}

}
