package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1012유기농배추 {
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int M, N, K, map[][];
	static boolean visit[][];
	static int cnt;
	static void dfs(Point now) {
		visit[now.x][now.y] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int row = now.x + dr[i];
			int col = now.y + dc[i];
			if(row<0 || col <0 || row >= N || col >= M )
				continue;
			if(map[row][col] == 0)
				continue;
			if(visit[row][col])
				continue;
			dfs(new Point(row,col));
			
		}
		
		
	}
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // col
			N = Integer.parseInt(st.nextToken()); // row
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			
			ArrayList<Point> onePoint = new ArrayList<Point>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
				onePoint.add(new Point(row,col));
				cnt = 0;
				
			}
			
			for(Point p : onePoint) {
				if(visit[p.x][p.y])
					continue;
				dfs(p);
				cnt++;
				
			}
			
			System.out.println(cnt);
		}
	}

}
