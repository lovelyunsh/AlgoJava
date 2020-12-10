package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2589보물섬 {



	static int findMax(int N, int M, int i, int j, char map[][]) {
		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };
		boolean visited[][] = new boolean[N][M];
		visited[i][j] = true;
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(i, j));
		int dist = -1;
		while (!que.isEmpty()) {
			int size = que.size();
			dist++;
			for (int k = 0; k < size; k++) {
				Point now = que.poll();
				for (int a = 0; a < 4; a++) {
					int row = now.x + dr[a];
					int col = now.y + dc[a];
					if (row < 0 || col < 0 || row >= N || col >= M)
						continue;
					if (map[row][col] == 'W')
						continue;
					if (visited[row][col])
						continue;
					visited[row][col] = true;
					que.offer(new Point(row,col));
				}
			}
		}

		return dist;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {// 최악 13750000
				if (map[i][j] == 'L') {
					max = Math.max(max, findMax(N, M, i, j, map));
				}
			}
		}

		// 구현하세요.

		System.out.println(max);

	}
} // end of class
