package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_13398연속합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[][] = new int[2][N + 2];
		int ans = -100000000;
		for (int i = 2; i < N+2; i++) {
			int num = Integer.parseInt(st.nextToken());
				dp[0][i] = Math.max(dp[0][i - 1] + num,num);
				dp[1][i] = Math.max(dp[0][i - 2] + num, dp[1][i - 1] + num);
				ans = Math.max(ans, dp[1][i]);
				ans = Math.max(ans,dp[0][i]);
		}
		System.out.println(ans);

	}

}
