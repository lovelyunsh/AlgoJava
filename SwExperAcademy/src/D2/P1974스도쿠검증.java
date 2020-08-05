package D2;

import java.util.Scanner;

public class P1974스도쿠검증 {
	public static int check(int[][] map) {

		boolean check1[][] = new boolean[10][10];
		boolean check2[][] = new boolean[10][10];
		boolean check3[][] = new boolean[10][10];
		int check_col[] = {0,3,6,0,3,6,0,3,6}; 
		int check_row[] = {0,0,0,3,3,3,6,6,6}; 
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
		for (int k = 0; k < 9; k++) {
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					if (check3[k][map[i+check_row[k]][j+check_col[k]]] == true)
						return 0;
					check3[k][map[i+check_row[k]][j+check_col[k]]] = true;
				}
		}


		return 1;
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
			int result = check(map);

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
