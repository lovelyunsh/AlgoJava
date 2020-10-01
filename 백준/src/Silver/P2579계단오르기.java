package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579계단오르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[N + 1];
		dp[0] = 0;
		dp[1] = Integer.parseInt(br.readLine());
		int pre = 0;
		if (N != 1) {
			pre = Integer.parseInt(br.readLine());
			dp[2] = dp[1] + pre;
		}
		for (int i = 3; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			dp[i] = Math.max(num + dp[i - 2], num + pre + dp[i - 3]);

			pre = num;
		}
		System.out.println(dp[N]);
	}

}
