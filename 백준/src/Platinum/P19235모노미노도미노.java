package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19235모노미노도미노 {
	// 모양 3개
	// 빨간거에 두면아래 오른쪽 이동
	// 한줄 채우면 사라지고 1점획득
	// 특수칸 들어가면 그 행수만큼 아래 행 삭제
	static int bluemap[][] = new int[6][4];
	static int greenmap[][] = new int[6][4];
	static int score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 1 : 1*1 , 2 : 1*2 , 3 : 2*1
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boolean isblue = true;
			for (int k = 0; k < 2; k++) {
				dropblock(t, x, y, isblue);
				boolean pung = true;
				while(pung) {
					pung = oneline(isblue);
					fillblank(isblue);
				}
				specialline(isblue);
				fillblank(isblue);
				isblue = false;
			}
		}
		int cnt = count(true) + count(false);
		System.out.println(score);
		System.out.println(cnt);

	}

	static void dropblock(int t, int x, int y, boolean isblue) {
		int map[][];
		if (isblue) {
			map = bluemap;
			x = y ^ x ^ (y = x);
			t = t == 1 ? 1 : t == 2 ? 3 : 2;
		} else
			map = greenmap;

		int row = 0;
		for (int i = 2; i <= 6; i++) {
			if (i == 6) {
				row = i - 1;
				break;
			}
			if (map[i][y] != 0) {
				row = i - 1;
				break;
			}
			if (t == 2 && map[i][y + 1] != 0) {
				row = i - 1;
				break;
			}
		}
		map[row][y] = 1;
		if (t == 2) {
			map[row][y] = 2;
			map[row][y + 1] = 3;
		} else if (t == 3)
			map[row - 1][y] = 1;
	}

	static void dropblank(int t, int x, int y, boolean isblue) {
		int[][] map = isblue ? bluemap : greenmap;
		int row = 0;
		for (int i = x + 1; i <= 6; i++) {
			if (i == 6) {
				row = i - 1;
				break;
			}
			if (map[i][y] != 0 ) {
				row = i - 1;
				break;
			}
			if (t == 2 && map[i][y + 1] != 0 ) {
				row = i - 1;
				break;
			}
		}
		map[row][y] = 1;
		if (t == 2) {
			map[row][y] = 2;
			map[row][y + 1] = 3;
		}

	}

	static void fillblank(boolean isblue) {
		int[][] map = isblue ? bluemap : greenmap;
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 0) {
					map[i][j] = 0;
					dropblank(1,i,j,isblue);
				}
				if (map[i][j] == 2 && map[i + 1][j+1] == 0 && map[i + 1][j] == 0) {
					map[i][j] = 0;
					map[i][j+1] = 0;
					dropblank(2,i,j,isblue);
				}
			}
		}
	}

	static boolean oneline(boolean isblue) {
		int[][] map = isblue ? bluemap : greenmap;
		boolean pung = false;
		for (int i = 2; i < 6; i++) {
			boolean fill = true;
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 0) {
					fill = false;
					break;
				}
			}
			if (fill) {
				score++;
				for (int j = 0; j < 4; j++)
					map[i][j] = 0;
				pung = true;
			}
		}
		return pung;
	}

	static void specialline(boolean isblue) {
		int[][] map = isblue ? bluemap : greenmap;
		int dline = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1 || map[i][j] == 2) {
					dline++;
					break;
				}
			}
		}
		for (int i = 5; i > 5 - dline; i--) {
			for (int j = 0; j < 4; j++)
				map[i][j] = 0;
		}
	}

	static int count(boolean isblue) {
		int[][] map = isblue ? bluemap : greenmap;
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3)
					cnt++;
			}
		}
		return cnt;
	}
}