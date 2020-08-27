package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class rooom implements Comparable<rooom> {
	int row;
	int col;
	int wall;

	public rooom(int row, int col, int wall) {
		this.row = row;
		this.col = col;
		this.wall = wall;
	}

	@Override
	public int compareTo(rooom o) {
		return this.wall - o.wall;
	}
}

public class P1261알고스팟 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		PriorityQueue<rooom> que = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char map[][] = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String oneline = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = oneline.charAt(j);
			}
		}
		que.offer(new rooom(0, 0, 0));
		visit[0][0] = true;
		gg: while (!que.isEmpty()) {
			rooom myroom = que.poll();
			if (myroom.row == N - 1 && myroom.col == M - 1) {
				System.out.println(myroom.wall);
				break gg;
			}

			for (int i = 0; i < 4; i++) {
				int row = myroom.row + dr[i];
				int col = myroom.col + dc[i];
				int wall = myroom.wall;


				if (row < 0 || col < 0 || row >= N || col >= M)
					continue;
				if(visit[row][col])
					continue;
				
				if (map[row][col] == '1')
					wall = wall + 1;
				
				que.offer(new rooom(row, col, wall));
				visit[row][col] = true;

			}

		}
	}
}
