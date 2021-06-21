package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_19236청소년상어 {
	static int map[][] = new int[4][4];
	static int dir[][] = new int[4][4];
	static int dr[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = 0;

	static class fish implements Comparable<fish> {
		int x;
		int y;
		int num;

		public fish(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(fish o) {
			return this.num - o.num;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dir[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int Sum = map[0][0];
		map[0][0] = -1;
		go(0,0,Sum);
		System.out.println(max);
	}

	static void go(int x, int y, int Sum) { // x,y 상어 위치
		// 물고기이동 상어이동
		move(); // 물고기 이동
		int[][] tempMap = copyMap(map);
		int[][] tempDir = copyMap(dir);
		int row = x;
		int col = y;
		while (true) {// 먹으러 가자
			row = row + dr[dir[x][y]];
			col = col + dc[dir[x][y]];
			if (row < 0 || col < 0 || row >= 4 || col >= 4)
				break;
			if (map[row][col] == 0)
				continue;
			Sum += map[row][col];
			map[row][col] = -1;
			map[x][y] = 0;
			go(row,col,Sum);
			map = copyMap(tempMap);
			dir = copyMap(tempDir);
			Sum-= map[row][col];
		}
			max = Math.max(max, Sum);
	}

	static int[][] copyMap(int [][] map) {
		int[][] copyMap = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	static void move() {
		for(int i = 1 ; i <= 16 ; i++) {
			fish now = findTarget(i);
			if(now == null)
				continue;
			int d = dir[now.x][now.y];
			do {
				int row = now.x + dr[d];
				int col = now.y + dc[d];
				if (row < 0 || col < 0 || row >= 4 || col >= 4 || map[row][col] == -1) {
					d = d == 8 ? 1 : d + 1;
					continue;
				}
				map[now.x][now.y] = map[row][col] ^ map[now.x][now.y] ^ (map[row][col] = map[now.x][now.y]);
				dir[now.x][now.y] = dir[row][col];
				dir[row][col] = d;
				break;
			} while (d != dir[now.x][now.y]);
		}
	}
	static fish findTarget(int num) {
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				if(map[i][j] == num)
					return new fish(i, j, num);
			}
		}
		return null;
	}
}
