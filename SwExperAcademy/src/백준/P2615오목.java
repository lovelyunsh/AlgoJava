package 백준;

import java.util.Scanner;

public class P2615오목 {
	static int[] move_x = { 0, 1, 1, -1 };
	static int[] move_y = { 1, 1, 0, 1 };

	static String checkFive(int[][] board, int nowx, int nowy) {

		if (board[nowx][nowy] != 0) {
			int color = board[nowx][nowy];
			for (int k = 0; k < move_x.length; k++) {
				int x = nowx;
				int y = nowy;
				int cnt = 0;
				int prex = x - move_x[k];
				int prey = y - move_y[k];
				if (prex >= 0 && prey >= 0 && prex < 19 && prey < 19)
					if (board[prex][prey] == color)
						continue;
				if (board[x][y] != color)
					break;
				while (true) {

					x = x + move_x[k];
					y = y + move_y[k];
					if (x < 0 || y < 0 || x >= 19 || y >= 19)
						break;
					if (board[x][y] != color)
						break;

					cnt++;
				}
				if (cnt == 4) {
					String result = color + "\n" + (nowx + 1) + " " + (nowy + 1);
					return result;
					
				}

			}
		}
		return null;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int board[][] = new int[19][19];
		// 흑돌 백돌 넣기
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board.length; j++)
				board[i][j] = sc.nextInt();
		boolean find_5 = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				String result = checkFive(board, i, j);
				if (result != null) {
					System.out.println(result);
					find_5 = true;
					break;
				} else if (i == 18 && j == 18) {
					System.out.println("0");
				}
			}
			if (find_5)
				break;

		}

	}
}
