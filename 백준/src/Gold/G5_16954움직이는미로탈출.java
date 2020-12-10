package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_16954움직이는미로탈출 {
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];
		for (int i = 0; i < 8; i++)
			map[i] = br.readLine().toCharArray();
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(7, 0));

		int dr[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int dc[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int ans = 0;
		gg: while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Point now = que.poll();

				if (map[now.x][now.y] == '#')
					continue;
				for (int i = 0; i < 8; i++) {
					int row = now.x + dr[i];
					int col = now.y + dc[i];
					if (row < 0 || col < 0 || row >= 8 || col >= 8)
						continue;
					if (map[row][col] == '#')
						continue;
					if (row == 0 && col == 7) {
						ans = 1;
						break gg;
					}
					que.offer(new Point(row,col));
				}
				que.offer(new Point(now.x,now.y));
				
			}
			move();
		}

		System.out.println(ans);
	}

	static void move() {
		for (int i = 6; i >= 0; i--)
			for (int j = 0; j < 8; j++)
				map[i+1][j] = map[i][j];
		for (int i = 0; i < 8; i++) {
			map[0][i] = '.';
		}

	}
}
