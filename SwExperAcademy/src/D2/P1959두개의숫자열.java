package D2;

import java.util.Scanner;

public class P1959두개의숫자열 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int Narr[] = new int[N];
			int Marr[] = new int[M];

			for (int i = 0; i < N; i++)
				Narr[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				Marr[i] = sc.nextInt();

			int result;
			if (Narr.length > Marr.length)
				result = Max(Narr, Marr);
			else
				result = Max(Marr, Narr);
			System.out.printf("#%d %d\n", tc, result);
		}
	}

	static int Max(int[] a, int[] b) {
		// a>b
		int max = 0;
		for (int i = 0; i <= a.length - b.length; i++) {
			int sum = 0;
			for (int j = 0; j < b.length; j++) {
				sum += b[j] * a[i + j];
			}
			if (sum > max)
				max = sum;

		}

		return max;
	}
}
