package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1970쉬운거스름돈 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int money[] = new int[8];

			st = new StringTokenizer(br.readLine());
			int change = Integer.parseInt(st.nextToken());
			for (int i = 0; change > 0; i += 2) {
				change /= 10;
				int temp = change % 10;
				if (temp >= 5) {
					money[i + 1] = 1;
					change -= 5;
					temp -= 5;
				}
				money[i] = temp;
				if (i == 6) {
					money[7] = money[7] + change / 5;
					break;
				}

			}

			System.out.printf("#%d\n", tc);
			for (int i = 7; i >= 0; i--) {
				System.out.print(money[i] + " ");
			}
			System.out.println();
		}
	}
}
