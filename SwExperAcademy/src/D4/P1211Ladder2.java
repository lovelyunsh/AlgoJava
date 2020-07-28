package D4;

import java.util.Scanner;

public class P1211Ladder2 {
	static int ladderdown(int ladder[][]) {
		int min_idx = 0;
		int min_cnt = 9999;
		for (int i = 0; i < 100; i++) { // i 시작위치
			if (ladder[0][i] == 1) {
				int cnt = 0;
				int nowi = i;
				int j = 1;
				boolean left = true;
				boolean right = true;

				while (true) {
					cnt++;
					if (right && nowi - 1 >= 0 && ladder[j][nowi - 1] == 1) { // 왼쪽으로 이동
						nowi = nowi - 1;
						left = false;
						continue;
					}
					if (left && nowi + 1 < 100 && ladder[j][nowi + 1] == 1) { // 오른쪽 이동
						nowi = nowi + 1;
						right = false;
						continue;
					}
					left = true;
					right = true;
					j++;
					if (j == 99) {
						if (min_cnt > cnt) {
							min_cnt = cnt;
							min_idx = i;
						}
						break;

					}

				}
			}
		}
		return min_idx;

	}

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			int[][] ladder = new int[100][100];
			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++)
					ladder[i][j] = sc.nextInt();
			int result = ladderdown(ladder);

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
