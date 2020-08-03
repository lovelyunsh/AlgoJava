package D2;

import java.util.Scanner;

public class P1948날짜계산기 {
	public static void main(String args[]) throws Exception {

		int a[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int fmon = sc.nextInt();
			int fday = sc.nextInt();
			int bmon = sc.nextInt();
			int bday = sc.nextInt();

			int cnt = 0;
			while (true) {
				if (fmon == bmon && fday == bday) {
					cnt++;
					break;
				}
				cnt++;
				fday++;
				if (fday == a[fmon] + 1) {
					fmon++;
					fday = 1;

				}

			}

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
