package D2;

import java.util.Scanner;

public class P1284수도요금경쟁 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int A = P * W;
			int B = Q + ((W > R) ? (W - R) * S : 0);
			System.out.printf("#%d %d", tc, A > B ? B : A);
			System.out.println();
		}
	}

}
