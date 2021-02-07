package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G2_13460구슬탈출2 {
	static int N, M;
	static Queue<maps> que;
	static char map[][];
	static boolean theend = false;

	static class maps {
		Point red;
		Point blue;
		int cnt;

		public maps(Point red, Point blue, int cnt) {
			this.red = red;
			this.blue = blue;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Point fred = null;
		Point fblue = null;
		que = new LinkedList<maps>();
		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j);
				if (map[i][j] == 'R')
					fred = new Point(i, j);
				else if (map[i][j] == 'B')
					fblue = new Point(i, j);
			}
		}
		que.add(new maps(fred, fblue, 0));
		System.out.println(bfs());

	}

	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	static int bfs() {

		while (!que.isEmpty()) {
			maps ori = que.poll();
			if (ori.cnt == 10)
				continue;
			for (int i = 0; i < 4; i++) {
				maps now = new maps((Point) ori.red.clone(), (Point) ori.blue.clone(), ori.cnt);
				if (move(now, i)) {
					que.offer(now);
				}
				if (theend)
					return now.cnt;
			}
		}
		return -1;
	}

	static boolean move(maps now, int d) {
		now.cnt++;
		Point first = null;
		Point second = null;
		boolean firstO = false;
		boolean secondO = false;
		if (d == 0) {
			first = now.blue.x > now.red.x ? now.blue : now.red;
			second = now.blue.x <= now.red.x ? now.blue : now.red;
		} else if (d == 1) {
			first = now.blue.x < now.red.x ? now.blue : now.red;
			second = now.blue.x >= now.red.x ? now.blue : now.red;
		} else if (d == 2) {
			first = now.blue.y > now.red.y ? now.blue : now.red;
			second = now.blue.y <= now.red.y ? now.blue : now.red;
		} else if (d == 3) {
			first = now.blue.y < now.red.y ? now.blue : now.red;
			second = now.blue.y >= now.red.y ? now.blue : now.red;
		}
		boolean fcheck = true;
		boolean scheck = true;

		while (fcheck || scheck) {
			int row = first.x + dr[d];
			int col = first.y + dc[d];
			if (fcheck)
				if (map[row][col] == '#')
					fcheck = false;
				else if (map[row][col] == 'O') {
					firstO = true;
					fcheck = false;
					first.x = 0;
					first.y = 0;
				} else {
					first.x = row;
					first.y = col;
				}
			row = second.x + dr[d];
			col = second.y + dc[d];
			if (scheck)
				if (map[row][col] == '#' || (row == first.x && col == first.y))
					scheck = false;
				else if (map[row][col] == 'O') {
					secondO = true;
					scheck = false;
					second.x = 0;
					second.y = 0;
				} else {
					second.x = row;
					second.y = col;
				}
		}
		if (firstO && secondO)
			return false;
		else if (firstO && first == now.red)
			theend = true;
		else if (secondO && second == now.red)
			theend = true;
		else if (firstO || secondO)
			return false;

		return true;
	}

}
