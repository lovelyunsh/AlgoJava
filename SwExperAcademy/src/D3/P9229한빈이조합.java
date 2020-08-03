package D3;

import java.util.Scanner;

public class P9229한빈이조합 {
	static int N;
	static int M;
	static int Narr[];
	static int max;

	static void comb(int idx, int s_idx, int sum) {
		if (sum > M)
			return;
		if (s_idx == 2) {
			max = Math.max(max, sum);
			return;
		}
		if (idx == N)
			return;
		comb(idx + 1, s_idx + 1, sum + Narr[idx]);
		comb(idx + 1, s_idx, sum);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			Narr = new int[N];
			for (int i = 0; i < N; i++) {
				Narr[i] = sc.nextInt();
			}
			max = -1;
			comb(0, 0, 0);

			System.out.printf("#%d %d\n", tc, max);
		}

	}

}
