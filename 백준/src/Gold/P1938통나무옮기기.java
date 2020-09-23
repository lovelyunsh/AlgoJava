package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1938통나무옮기기 {

	static int N, garosero;
	static char map[][];
	static boolean visit[][][];
	static Point center;

	static class Point {
		int x;
		int y;
		boolean garo;

		public Point(int x, int y, boolean garo) {
			super();
			this.x = x;
			this.y = y;
			this.garo = garo;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N + 2][N + 2];
		List<Point> wood = new ArrayList<Point>();
		List<Point> goal = new ArrayList<Point>();
		visit = new boolean[N + 2][N + 2][2]; // 0은 세로 1은 가로

		for (int i = 0; i < N + 2; i++) { // 테두리 1로 채우기
			Arrays.fill(map[i], '1');
		}
		for (int i = 1; i <= N; i++) { // 맵 만들기
			String st = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = st.charAt(j - 1);
				if (map[i][j] == 'B') {
					wood.add(new Point(i, j, true));
				}
				if (map[i][j] == 'E') {
					goal.add(new Point(i, j, true));
				}
			}
		}

		wood.get(1).garo = wood.get(0).x == wood.get(1).x ? true : false;
		goal.get(1).garo = goal.get(0).x == goal.get(1).x ? true : false;

		Queue<Point> que = new LinkedList<Point>();
		que.offer(wood.get(1));
		que.offer(new Point(-1, -1, true));
		int turn = 0;

		while (true) {
			Point now = que.poll();

			if (now.x == -1) {
				turn++;
				if (que.isEmpty()) {
					turn = 0;
					break;
				}
				que.offer(new Point(-1, -1, true));
				continue;
			}
			if (now.x == goal.get(1).x && now.y == goal.get(1).y && now.garo == goal.get(1).garo) {
				break;
			}
			if (U(now))
				que.offer(new Point(now.x - 1, now.y, now.garo));

			if (D(now))
				que.offer(new Point(now.x + 1, now.y, now.garo));

			if (L(now))
				que.offer(new Point(now.x, now.y - 1, now.garo));

			if (R(now))
				que.offer(new Point(now.x, now.y + 1, now.garo));

			if (T(now))
				que.offer(new Point(now.x, now.y, !now.garo));
		}
		System.out.println(turn);
	}

	static boolean U(Point now) {
		if (now.garo) {
			if (map[now.x - 1][now.y] == '1' || map[now.x - 1][now.y - 1] == '1' || map[now.x - 1][now.y + 1] == '1')
				return false;
			if (visit[now.x - 1][now.y][0])
				return false;
			visit[now.x - 1][now.y][0] = true;
			
		} else {
			if (map[now.x - 2][now.y] == '1')
				return false;
			if (visit[now.x - 1][now.y][1])
				return false;
			visit[now.x - 1][now.y][1] = true;
		}

		return true;
	}

	static boolean D(Point now) {
		if (now.garo) {
			if (map[now.x + 1][now.y] == '1' || map[now.x + 1][now.y - 1] == '1' || map[now.x + 1][now.y + 1] == '1')
				return false;
			if (visit[now.x + 1][now.y][0])
				return false;
			visit[now.x + 1][now.y][0] = true;
		} else {
			if (map[now.x + 2][now.y] == '1')
				return false;
			if (visit[now.x + 1][now.y][1])
				return false;
			visit[now.x + 1][now.y][1] = true;
		}

		return true;
	}

	static boolean L(Point now) {
		if (now.garo) {
			if (map[now.x][now.y - 2] == '1')
				return false;
			if (visit[now.x][now.y - 1][0])
				return false;
			visit[now.x][now.y - 1][0] = true;
		} else {
			if (map[now.x][now.y - 1] == '1' || map[now.x - 1][now.y - 1] == '1' || map[now.x + 1][now.y - 1] == '1')
				return false;
			if (visit[now.x][now.y - 1][1])
				return false;
			visit[now.x][now.y - 1][1] = true;
		}

		return true;
	}

	static boolean R(Point now) {
		if (now.garo) {
			if (map[now.x][now.y + 2] == '1')
				return false;
			if (visit[now.x][now.y + 1][0])
				return false;
			visit[now.x][now.y + 1][0] = true;
		} else {
			if (map[now.x][now.y + 1] == '1' || map[now.x - 1][now.y + 1] == '1' || map[now.x + 1][now.y + 1] == '1')
				return false;
			if (visit[now.x][now.y + 1][1])
				return false;
			visit[now.x][now.y + 1][1] = true;
		}

		return true;
	}

	static boolean T(Point now) {
		for (int i = now.x - 1; i <= now.x + 1; i++) {
			for (int j = now.y - 1; j <= now.y + 1; j++) {
				if (map[i][j] == '1')
					return false;
			}
		}
		if (!now.garo) {
			if (visit[now.x][now.y][0])
				return false;
		} else {
			if (visit[now.x][now.y][1])
				return false;
		}
		visit[now.x][now.y][1] = true;
		return true;
	}
}
