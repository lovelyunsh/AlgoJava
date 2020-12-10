package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_16236아기상어 {
	static int map[][], time, size, N, sizeup;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;
		sizeup = size;
		Point now = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					now = new Point(i, j);
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			Point food = find(now);
			if (food == null) {
				break;
			}
			map[food.x][food.y] = 0;
			now = food;

			sizeup--;
			if (sizeup == 0) {
				sizeup = ++size;
			}

		}
		System.out.println(time);
	}

	static Point find(Point start) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(start);
		int dr[] = { 1, -1, 0, 0 };
		int dc[] = { 0, 0, 1, -1 };
		boolean visited[][] = new boolean[N][N];
		visited[start.x][start.y] = true;
		List<Point> foodlist = new ArrayList<Point>();
		int dist = 1;
		while (!que.isEmpty()) {
			for (int queSize = que.size(); queSize > 0; queSize--) {
				Point now = que.poll();
				for (int i = 0; i < 4; i++) {
					int row = now.x + dr[i];
					int col = now.y + dc[i];

					if (row < 0 || col < 0 || row >= N || col >= N)
						continue;
					if (map[row][col] > size)
						continue;

					if (visited[row][col])
						continue;
					if (map[row][col] != 0 && map[row][col] < size) {
						foodlist.add(new Point(row, col));
					}
					visited[row][col] = true;
					que.offer(new Point(row, col));

				}
			}
			if (foodlist.size() != 0) {
				Collections.sort(foodlist, new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						if (o1.x == o2.x)
							return o1.y - o2.y;
						return o1.x - o2.x;
					}
				});
				time += dist;

				return foodlist.get(0);
			}
			dist++;
		}

		return null;
	}

}
