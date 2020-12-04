package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8382방향전환 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int num1 = Math.abs(x1 - x2);
			int num2 = Math.abs(y1 - y2);
			if (num1 > num2)
				num1 = num2 ^ num1 ^ (num2 = num1);
			int ans = num1 * 2;
			num2 = num2 - num1;
			if (num2 % 2 == 0)
				ans += num2 * 2;
			else
				ans += num2 * 2 - 1;

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

}
