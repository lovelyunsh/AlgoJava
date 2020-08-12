package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2206벽부수고이동하기 {
	static char map[][];
	static int M,N;
	static boolean visit[][];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static int min = 123456789;
	static void dfs(Point p , int cnt, int one ) {
		if(p.x == M-1 && p.y == N-1) {
			min = Math.min(min, cnt);
			return;
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			int newone = one;
			int row = p.x+dr[i];
			int col = p.y+dc[i];
			
			if(row<0 || col<0 || row>=M || col>=N)
				continue;
			if(visit[row][col])
				continue;
			if(map[row][col] == '1' ) {
				if(newone == 1)
					continue;
				
				newone = 1;
			}
			visit[row][col] = true;
			dfs(new Point(row,col),cnt+1,newone);
			visit[row][col] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[M][N];
		for(int i = 0 ; i < M ; i++ ) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		visit[0][0] = true;
		dfs(new Point(0,0),1,0);
		if(min == 123456789)
			min = -1;
		System.out.println(min);
		
		
	}

}
