package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class P1288새로운불면증치료법 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			ArrayList<Integer> numarray = new ArrayList<Integer>();
			int N = sc.nextInt();
			int cnt = 1;
			int num = N;
			while (true) {
				while (num != 0) {
					if (!numarray.contains(num % 10))
						numarray.add(num % 10);
					num = num / 10;
				}
				if (numarray.size() == 10)
					break;
				num = N * ++cnt;
			}
			System.out.printf("#%d %d", tc, N * cnt);
			System.out.println();
		}
	}

}
