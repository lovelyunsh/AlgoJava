package D2;

import java.util.Scanner;

public class P2007패턴마디의길이 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String input = sc.next();

			String first = "";
			String end = "";
			Boolean check = false;
			int idx = 0;
			gg: for (char i : input.toCharArray()) {
				if (first == "") {
					first += i;
					continue;
				}
				if (i == first.charAt(0)) { // 첫번째 글자랑 같으면 마디인지 검사시작
					check = true;
				}
				if (!check) {
					first += i;
				}
				if (check) { //
					end += i;
					if (first.charAt(idx++) != i) {
						idx = 0;
						first += end;
						end = "";
						check = false;
					}
					if (first.length() == end.length()) {
						for (int j = 0; j < 30; j++) {
							if (input.charAt(j) != first.charAt(j % first.length())) {
								check = false;
								idx = 0;
								first += end;
								end = "";
								break;
							}
							if (j == 29)
								break gg;

						}
					}

				}

			}

			System.out.printf("#%d %d\n", tc, first.length());
		}
	}

}
