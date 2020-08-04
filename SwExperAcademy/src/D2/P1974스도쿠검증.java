package D2;

import java.util.Scanner;

public class P1974스도쿠검증 {
	public static int check(int[][] map) {

		boolean check1[][] = new boolean[10][10];
		boolean check2[][] = new boolean[10][10];
		boolean check3[][] = new boolean[10][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (check1[i][map[i][j]] == true)
					return 0;
				check1[i][map[i][j]] = true;
			}
		}

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (check2[i][map[j][i]] == true)
					return 0;
				check2[i][map[j][i]] = true;
			}

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (check3[i][map[j][i]] == true)
					return 0;
				check3[i][map[j][i]] = true;
			}
		

		boolean check[] = new boolean[10];

		return 0;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int map[][] = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			System.out.printf("#%d \n", tc);
		}
	}

}
