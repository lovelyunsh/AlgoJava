package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P7562나이트의이동 {

	static class Point {
		int row;
		int col;
		int cnt;
		
		public Point(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			
		}
		
	}
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		int dr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			Point me = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			Queue<Point> que = new LinkedList<Point>();
			que.offer(me);
			int result = 0;
			boolean visit[][] = new boolean[N][N];
			visit[me.row][me.col] = true;
			while (!que.isEmpty()) {
				Point now = que.poll();
				if (now.row == end.row && now.col == end.col) {
					result = now.cnt;
					break;
				}

				for (int i = 0; i < 8; i++) {
					int row = now.row + dr[i];
					int col = now.col + dc[i];
					if (row < 0 || col < 0 || row >= N || col >= N)
						continue;
					if(visit[row][col])
						continue;
					
					visit[row][col] = true;
					que.offer(new Point(row, col, now.cnt+1));

				}

			}
			System.out.printf("%d\n", result);
		}
	}

}
