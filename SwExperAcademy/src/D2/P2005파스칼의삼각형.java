package D2;

import java.util.Scanner;

public class P2005파스칼의삼각형 {
	
	public static int comb(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return comb(n - 1, r - 1) + comb(n - 1, r);
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append(1 + "\n");
			for (int i = 1; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(comb(i,j) + " ");
				}
				sb.append("\n");
			}
			System.out.printf("#%d\n", tc);
			System.out.print(sb);
		}
	}

}
