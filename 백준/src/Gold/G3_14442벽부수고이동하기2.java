package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class room1 {
	int row;
	int col;
	int cnt;
	int one;

	public room1(int row, int col, int cnt, int one) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.one = one;
	}

}

public class G3_14442벽부수고이동하기2 {
	static char map[][];
	static int N, M, K;
	static int visit[][];
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int min = 123456789;

	static void bfs(room1 r) {

		Queue<room1> que = new LinkedList<room1>();
		que.offer(r);
		while (!que.isEmpty()) {
			room1 now = que.poll();
			if (now.row == N - 1 && now.col == M - 1) {
				min = Math.min(min, now.cnt);
				return;
			}

			g: for (int i = 0; i < 4; i++) {
				int row = now.row + dr[i];
				int col = now.col + dc[i];

				if (row < 0 || col < 0 || row >= N || col >= M)
					continue;

				if (visit[row][col] <= now.one)
					continue g;

				if (map[row][col] == '0') {
					visit[row][col] = now.one;
					que.offer(new room1(row, col, now.cnt + 1, now.one));

				}

				if (map[row][col] == '1') {
					if (now.one == K)
						continue;
					visit[row][col] = now.one;
					que.offer(new room1(row, col, now.cnt + 1, now.one + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i = 0 ; i < N ; i++)
			Arrays.fill(visit[i], 11);
		visit[0][0] = 0;
		
		bfs(new room1(0, 0, 1, 0));
		if (min == 123456789)
			min = -1;
		System.out.println(min);

	}

}
