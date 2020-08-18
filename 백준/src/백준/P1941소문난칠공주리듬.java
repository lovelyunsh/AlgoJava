package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1941소문난칠공주리듬 {
	static char map[][];
	static boolean visit[][];
	static int result;
	static boolean[][] end;
	static int dr[] = { 1 };
	static int dc[] = { 0 };

	static void dfs(Point p, int selidx, Point sel[]) throws InterruptedException {
		for (int i = 0; i < 30; i++) { // 맵보기
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(visit[i][j])
					System.out.print("O"+" ");
				else
					System.out.print("X"+" ");
			}
			System.out.println();
		}

		Thread.sleep(1000);
		if (selidx == 7) {
			int Y = 0;
			for (Point nn : sel) {
				if (map[nn.x][nn.y] == 'Y')
					Y++;
			}
			if (Y > 3)
				return;
			result++;
			return;
		}
		for (Point n : sel) {
			if (n == null)
				break;
			int row = n.x + dr[0];
			int col = n.y + dc[0];
			if (row < 0 || col < 0 || row >= 5 || col >= 5) // 사실 col은 걱정 안해도 되긴 해
				continue;
			if (visit[row][col])
				continue;
			sel[selidx] = new Point(row, col);
			visit[row][col] = true;
			dfs(new Point(row, col), selidx + 1, sel);
			sel[selidx] = null;
			visit[row][col] = false;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		end = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = j; k < 5; k++) {
					Point sel[] = new Point[7];
					visit = new boolean[5][5];
					int selidx = 0;
					for (int l = 0; j + l <= k; l++) {
						visit[i][j + l] = true;
						sel[l] = new Point(i, j + l);
						selidx++;
					}
					dfs(new Point(i, j), selidx, sel);
				}
			}
		}
		System.out.println(result);
	}
}
