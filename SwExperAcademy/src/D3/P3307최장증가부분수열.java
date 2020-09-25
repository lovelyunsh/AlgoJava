package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3307최장증가부분수열 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int dp [][] = new int [2][N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i < N+1 ; i++) {
				dp[0][i] = Integer.parseInt(st.nextToken());
				int max = 0;
				for(int j = 0 ; j < i ; j++) {
					if(dp[0][j] <dp[0][i])
						max = Math.max(max, dp[1][j]);
				}
				dp[1][i] = max+1;
			}
			int max = 0;
			for(int i = 0 ; i < N+1 ; i++) {
				max = Math.max(dp[1][i], max);
			}
			
			System.out.printf("#%d %d\n", tc,max);
		}
	}

}
