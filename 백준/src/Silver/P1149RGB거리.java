package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149RGB거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][3];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1] + red , dp[i-1][2]+red) ;
			dp[i][1] = Math.min(dp[i-1][0] + green , dp[i-1][2]+green);
			dp[i][2] = Math.min(dp[i-1][0] + blue , dp[i-1][1]+blue);
		}
		int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

		System.out.println(result);
	}
}
