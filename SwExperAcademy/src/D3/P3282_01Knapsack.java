package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3282_01Knapsack {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int dp[][] = new int[N+1][K+1];
			int max = 0;
			for(int i = 1 ; i < N+1 ; i++) { //j는 남은 
				st= new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				for(int j = 1 ; j < K+1 ; j++) {
					max = dp[i-1][j];
					if(v<=j) {
						max = Math.max(dp[i-1][j-v]+c, max);
					}
					
					dp[i][j]= max;
					
				}
				
			}
			
			System.out.printf("#%d %d\n", tc,max);
		}
	}


}
