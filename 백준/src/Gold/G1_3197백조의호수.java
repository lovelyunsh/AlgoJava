package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_3197백조의호수 {
	static char map[][];

	static Queue<Point> water = new LinkedList<Point>();
	static int R, C;
	static Point bird;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.')
					water.add(new Point(i, j));
				if (map[i][j] == 'L')
					bird = new Point(i, j);
			}
		}
		int day = 0;
		while(!check()) {
			melt();
			day++;
		}
		System.out.println(day);
		
		

	}

	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	static boolean check() {
		boolean visit[][] = new boolean[R][C];
		Queue<Point> fly = new LinkedList<Point>();
		fly.add(bird);
		visit[bird.x][bird.y] = true;
		while (!fly.isEmpty()) {
			Point now = fly.poll();
			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (row < 0 || col < 0 || row >= R || col >= C)
					continue;
				if (visit[row][col])
					continue;
				if (map[row][col] == 'L')
					return true;
				if (map[row][col] != '.')
					continue;
				visit[row][col] = true;
				fly.add(new Point(row, col));
			}
		}
		return false;
	}

	static void melt() {
		int size = water.size();
		for (int s = 0; s < size; s++) {
			Point now = water.poll();
			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (row < 0 || col < 0 || row >= R || col >= C)
					continue;
				if (map[row][col] != 'X')
					continue;
				map[row][col] = '.';
				water.add(new Point(row, col));
			}
		}
	}

}
