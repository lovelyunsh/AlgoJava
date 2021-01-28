package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_4179불 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		Queue<Point> fire = new LinkedList<Point>();
		Queue<Point> jihun = new LinkedList<>();
		boolean visitF[][] = new boolean[R][C];
		boolean visitJ[][] = new boolean[R][C];
		char map[][] = new char[R][C];
		for (int i = 0; i < R; i++) {
			String S = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j);
				if (map[i][j] == 'J') {
					jihun.add(new Point(i, j));
					visitJ[i][j] = true;
				}
				if (map[i][j] == 'F') {
					fire.add(new Point(i, j));
					visitF[i][j] = true;
				}
			}
		}
		int dr[] = { 0, 0, 1, -1 };
		int dc[] = { 1, -1, 0, 0 };
		int cnt = 1;
		boolean flag = false;
		gg: while (!jihun.isEmpty()) {
			int size = fire.size();
			for (int s = 0; s < size; s++) {
				Point now = fire.poll();
				for (int i = 0; i < 4; i++) {
					int row = now.x + dr[i];
					int col = now.y + dc[i];
					if (row < 0 || col < 0 || row >= R || col >= C)
						continue;
					if (map[row][col] == '#')
						continue;
					if (visitF[row][col])
						continue;
					visitF[row][col] = true;
					fire.add(new Point(row, col));
				}
			}
			size = jihun.size();
			for (int s = 0; s < size; s++) {
				Point now = jihun.poll();
				if (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1) {
					flag = true;
					break gg;
				}
				for (int i = 0; i < 4; i++) {
					int row = now.x+dr[i];
					int col = now.y+dc[i];
					if (row < 0 || col < 0 || row >= R || col >= C)
						continue;
					if (map[row][col] == '#' || visitF[row][col])
						continue;
					
					if (visitJ[row][col])
						continue;
					visitJ[row][col] = true;
					jihun.add(new Point(row, col));
				}
			}
			cnt++;
		}
		System.out.println(flag? cnt : "IMPOSSIBLE ");
	}
}