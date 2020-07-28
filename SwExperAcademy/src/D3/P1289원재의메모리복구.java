package D3;

import java.util.Scanner;

public class P1289원재의메모리복구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			char flag = '1';
			String num = sc.next();
			for (char ch : num.toCharArray()) {
				if (ch == flag) {
					count++;
					flag = flag == '0' ? '1' : '0';
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}

	}

}
