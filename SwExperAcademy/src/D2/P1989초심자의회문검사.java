package D2;

import java.util.Scanner;

public class P1989초심자의회문검사 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int result = 0;
		for (int tc = 1; tc <= T; tc++) {
			String input = sc.next();

			char[] a = input.toCharArray();
			
			for (int i = 0; i < a.length / 2; i++) {
				if (a[i] == a[a.length - i - 1]) {
					result = 1;
				} else {
					result = 0;
					break;
				}
			}
			// solving

			System.out.printf("#%d %d\n", tc,result);
		}
	}
}
