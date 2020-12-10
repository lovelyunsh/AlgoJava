package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_17136색종이붙이기 {

	static int paper[] = { 0, 5, 5, 5, 5, 5 };
	static int map[][];
	static int cnt, one;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		map = new int[10][10];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					one++;
			}
		}

		dfs(0, 0, 0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	public static void dfs(int r, int c, int cnt) {

		if (r == 9 && c > 9) {
			result = Math.min(result, cnt);
			return;
		}

		if (result <= cnt)
			return;

		if (c > 9) {
			dfs(r + 1, 0, cnt);
			return;
		}

		if (map[r][c] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (paper[i] > 0 && check(r, c, i)) {
					cutpaste(r, c, i, 0);
					paper[i]--;
					dfs(r, c + 1, cnt + 1);
					cutpaste(r, c, i, 1);
					paper[i]++;
				}
			}
		} else
			dfs(r, c + 1, cnt);
	}

	public static void cutpaste(int x, int y, int size, int zeone) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = zeone;
			}
		}
	}

	public static boolean check(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || j < 0 || i >= 10 || j >= 10)
					return false;
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
