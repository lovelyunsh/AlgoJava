package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class monkey {
	int row;
	int col;
	int cnt;
	int jump;

	public monkey(int row, int col, int cnt, int jump) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.jump = jump;
	}

}

public class G5_1600말이되고픈원숭이 {
	static char map[][];
	static int M, N, K;
	static boolean visit[][][];
	static int dr[] = { 1, 0, -1, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dc[] = { 0, -1, 0, 1, 1, 2, 2, 1, -1, -2, -2, -1 };
	static int min = 123456789;

	static void bfs(monkey r) {

		Queue<monkey> que = new LinkedList<monkey>();
		que.offer(r);
		while (!que.isEmpty()) {
			monkey now = que.poll();
			if (now.row == M - 1 && now.col == N - 1) {
				min = Math.min(min, now.cnt);
				return;
			}
			g: for (int i = 0; i < 12; i++) {

				if (now.jump == K && i >= 4)
					break;
				int row = now.row + dr[i];
				int col = now.col + dc[i];

				if (row < 0 || col < 0 || row >= M || col >= N)
					continue;
				if (map[row][col] == '1')
					continue;


				if (i < 4) {
					for (int j = 0; j <= now.jump; j++)
						if (visit[j][row][col])
							continue g;
					visit[now.jump][row][col] = true;
					que.offer(new monkey(row, col, now.cnt + 1, now.jump));
				}

				if (i >= 4) {
					for (int j = 0; j <= now.jump+1; j++)
						if (visit[j][row][col])
							continue g;
					visit[now.jump+1][row][col] = true;
					que.offer(new monkey(row, col, now.cnt + 1, now.jump + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[K + 1][M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		visit[0][0][0] = true;
		bfs(new monkey(0, 0, 0, 0));
		if (min == 123456789)
			min = -1;
		System.out.println(min);

	}

}
