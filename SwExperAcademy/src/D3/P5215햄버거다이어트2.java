package D3;

import java.util.Scanner;

public class P5215햄버거다이어트2 {
	static int cal = 0;
	static int maxcal = 0;
	static int[][] numArr;
	static int maxScore = 0;
	static int N;

	static void powerSet(int idx, int score, int cal) {

		if (maxcal < cal)
			return;
		if (idx >= N) {
			if (maxScore < score) {
				maxScore = score;
			}
			return;
		}

		powerSet(idx + 1, score + numArr[idx][0], cal + numArr[idx][1]);

		powerSet(idx + 1, score, cal);

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			maxcal = sc.nextInt();
			numArr = new int[N][2];

			for (int i = 0; i < N; i++) {
				numArr[i][0] = sc.nextInt();// score
				numArr[i][1] = sc.nextInt(); // cal
			}
			powerSet(0, 0, 0);

			System.out.printf("#%d %d\n", tc, maxScore);
		}
	}

}
