package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P7699수지의수지맞는여행 {
	static char map[][];
	static int R;
	static int C;
	static Stack<Character> check = new Stack<Character>();
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static int max;
	static void dfs(int x, int y, int cnt) {
        if(max == 26)
            return;
        
		max = Math.max(max, cnt);
		for(int i = 0 ; i < 4 ; i++) {
			int row = x + dr[i];
			int col = y+ dc[i];
			if(row< 0 || col <0 || row >= R || col >=C)
				continue;
			if(!check.contains(map[row][col])){
				check.push(map[row][col]);
				dfs(row,col,cnt+1);
				check.pop();
			}
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
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char [R][C];
			max = 0;
			for(int i = 0 ; i < R ; i++) {
				String hi = br.readLine();
				for(int j = 0 ; j < C ; j++) {
					map[i][j] = hi.charAt(j);
				}
			}
			check.push(map[0][0]);
			dfs(0,0,1);
			check.pop();
			
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}

	
	

}
