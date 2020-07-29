package D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P5215햄버거다이어트 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int MaxC = sc.nextInt();
			int input[][] = new int[N][3];
			for (int i = 0; i < N; i++) {

				int score = sc.nextInt();
				int cal = sc.nextInt();
				input[i][0] = cal - score;
				input[i][1] = score;
				input[i][2] = cal;
			}

			Arrays.sort(input, (o1, o2) -> {
				if (o1[0] == o2[0]) {
					return Integer.compare(o2[2], o1[2]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}

			});
			int nowcal = 0;
			int nowscore = 0;
			int maxscore = 0;
			for (int j = 0; j < N; j++) {
				for (int i = j; i < N; i++) {
					if(i>N)
						break;
					if (nowcal + input[i][2] < MaxC) {
						nowscore += input[i][1];
						nowcal += input[i][2];
					}
				}
				if(nowscore > maxscore)
					maxscore = nowscore;
			}

			System.out.printf("#%d %d\n", tc, maxscore);
		}
	}

}
