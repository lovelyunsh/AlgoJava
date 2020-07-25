package D3;

import java.util.Scanner;

public class 오셀로 {
	static int[] move_x = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] move_y = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int[][] putRock(int board[][], int x, int y, int color) {
		board[x][y] = color;
		int opp_color = (color == 1) ? 2 : 1;
		for (int i = 0; i < move_x.length; i++) {
			if (x + move_x[i] >= 0 && y + move_y[i] >= 0 && x + move_x[i] < board.length && y + move_y[i] < board.length) { // 8방향 검사
				if (board[x + move_x[i]][y + move_y[i]] == opp_color) {
					int cnt = 2;
					boolean flag = false;
					while (true) {
						if (x + move_x[i] * cnt >= 0 && y + move_y[i] * cnt >= 0 && x + move_x[i] * cnt < board.length && y + move_y[i] * cnt < board.length) {
							if (board[x + move_x[i] * cnt][y + move_y[i] * cnt] == color) {
								flag = true;
								break;
							} else if (board[x + move_x[i] * cnt][y + move_y[i] * cnt] == 0) {
								flag = false;
								break;
							}

						} else {
							flag = false;
							break;
						}
						cnt++;
					}
					if (flag) {
						for (int k = 1; k < cnt; k++) {
							int x1 = x + move_x[i] * k;
							int y1 = y + move_y[i] * k;
							board[x1][y1] = color;
						}
					}

				}

			}

		}
		return board;
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int board[][] = new int[N][N];
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2] = 2;

			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int color = sc.nextInt();
				board = putRock(board, x, y, color);
			}
			int black = 0;
			int white = 0;
			for (int i[] : board)
				for (int j : i) {
					if (j == 1)
						black++;
					else if (j == 2)
						white++;
				}

			System.out.printf("#%d %d %d", tc, black, white);
			System.out.println();
		}

	}

}
