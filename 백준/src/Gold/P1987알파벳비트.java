package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1987알파벳비트 {
	static char map[][];
	static int R;
	static int C;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int max;
	static int bit;
	static void dfs(Point p , int bit, int cnt) {
		bit = bit | (1 << ('Z' - (map[p.x][p.y])));
		boolean flag = false;
		for(int i = 0 ; i < 4 ; i++) {
			int row = p.x + dr[i];
			int col = p.y + dc[i];
			if(row<0 || col < 0 || row>=R || col >=C)
				continue;
			if((bit & (1 << ('Z' - map[row][col]))) != 0) 
				continue;
			flag = true;
			dfs(new Point(row,col), bit, cnt+1);
		}
		if(!flag)
			max = Math.max(cnt, max);
		
	}
	

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		max = 0;
		for (int i = 0; i < R; i++) {
			String hi = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = hi.charAt(j);
			}
		}
		dfs(new Point(0,0), 0,1);
		System.out.println(max);
	}

}
