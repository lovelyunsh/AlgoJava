package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1861정사각형방 {
	static int cnt;
	static int [][]map;
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static int N;
	public static void dfs(int x, int y) {
		
		
		
		for(int i = 0 ; i < 4 ;i++) {
			int row = x + dr[i];
			int col = y + dc[i];
			if(row< 0 || col <0 || row >= N || col >=N)
				continue;
			if(map[row][col] == map[x][y]+1) {
				cnt ++;
				dfs(row,col);
				break;
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
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			ArrayList<Integer> maxlist= new ArrayList<>();
			
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++) {
					cnt = 1;
					dfs(i,j);
					if(cnt > max) {
						max = cnt;
						maxlist.clear();
					}
					if(cnt == max) {
						maxlist.add(map[i][j]);
					}
				}
			
			Collections.sort(maxlist);
			int maxidx = maxlist.get(0);  
			System.out.printf("#%d %d %d\n", tc,maxidx,max);
		}
	}

}
