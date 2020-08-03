package D2;

import java.util.Scanner;

public class P1979어디에단어가들어갈수있을까 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int Narr[][] = new int[N][N];
			int cnt = 0;
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Narr[i][j] = sc.nextInt();
					if (Narr[i][j] == 1) {
						cnt++;
					}
					if (Narr[i][j] == 0) {
						if (cnt == K)
							result++;
						cnt = 0;
					}

				}
				if (cnt == K)
					result++;
				cnt = 0;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Narr[j][i] == 1) {
						cnt++;
					}
					if (Narr[j][i] == 0) {
						if (cnt == K)
							result++;
						cnt = 0;
					}
					
				}
				if (cnt == K)
					result++;
				cnt = 0;
			}

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
