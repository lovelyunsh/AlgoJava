package D2;

import java.util.Scanner;

public class P1945간단한소인수분해 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int nanu[] = { 2, 3, 5, 7, 11 };

		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			int result[] = new int[5];

			for (int i = 0; i < nanu.length; i++) {
				int cnt = 0;
				while (true) {
					if (num % nanu[i] != 0) {
						result[i] = cnt;
						break;
					} else {
						cnt++;
						num = num / nanu[i];
					}

				}
			}
			System.out.print("#"+tc);
			for(int i = 0 ; i<5 ; i++)
				System.out.print(" "+result[i]);
			System.out.println();
		}
	}
}
