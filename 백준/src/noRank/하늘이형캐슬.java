package noRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 하늘이형캐슬 {
	static int N, M, D, die, ans, map[][], cpymap[][];
	static boolean archor[], visited[][][];
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> kill = new LinkedList<>();
	static List<Point> archorlist = new LinkedList<>();
	static int dr[] = { -1, 0, 0 };
	static int dc[] = { 0, -1, 1 };
	// 궁수들은 동시에 활을 쏜다 메모

	static class Point {
		int r, c, d, a;

		public Point(int r, int c, int d, int a) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.a = a;
		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Point np = queue.poll();
			// 적이야? 죽일놈 담기
			if (map[np.r][np.c] == 1) {
				int dist = 0;
				// dist 계산
				// List0 1 2 3명이니까
				// np.a는 큐에 담겨져잇는데 0 1 2 중에 누군지를 구분하는 거
				// list.get(np.a).r - kp.r
				dist = Math.abs(np.r - archorlist.get(np.a).r) + Math.abs(np.c - archorlist.get(np.a).c);
				kill.offer(new Point(np.r, np.c, dist, np.a));
			}

			for (int d = 0; d < 3; d++) {
				int nr = np.r + dr[d];
				int nc = np.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (np.d > 0 && !visited[nr][nc][np.a]) {
					visited[nr][nc][np.a] = true;
					queue.offer(new Point(nr, nc, np.d - 1, np.a));
				}
			}
		}
	}

	static void combine(int idx, int start, int selidx) {

		if (selidx == 3) {
			// 나온 조합에서 로직을 돌려보면 되겟네
			copycopymap();
			// 조합 반복 시작
			die = 0;
			for (int i = 0; i < N; i++) {
				// 궁수 위치 삽입
				visited = new boolean[N + 1][M][3];
				archorlist = new LinkedList<>();
				int ar = 0;
				for (int j = 0; j < M; j++) {
					if (archor[j]) {
						// 넣었어
						visited[N][j][ar] = true;
						archorlist.add(new Point(N, j, D, ar));
						queue.offer(new Point(N, j, D, ar++));
						// 쏠놈 정해
						bfs();
					}
				}
				// 쏠놈 쏴
				int nearR[] = new int[3];
				int nearC[] = new int[3];
				int nearD[] = new int[3];
				for (int j = 0; j < 3; j++) {
					nearR[j] = Integer.MAX_VALUE;
					nearC[j] = Integer.MAX_VALUE;
					nearD[j] = Integer.MAX_VALUE;
				}
				// 죽일놈 찾자
				while (!kill.isEmpty()) {
					Point kp = kill.poll();
					// 죽일놈의 현 포인트
					if (nearD[kp.a] > kp.d) {
						nearR[kp.a] = kp.r;
						nearC[kp.a] = kp.c;
						nearD[kp.a] = kp.d;
					} else if (nearD[kp.a] == kp.d) {
						if (nearC[kp.a] > kp.c) {
							nearR[kp.a] = kp.r;
							nearC[kp.a] = kp.c;
							nearD[kp.a] = kp.d;
						}
					}
				}
				// 죽이는 코드
				for (int j = 0; j < 3; j++) {
					if (nearR[j] != Integer.MAX_VALUE && map[nearR[j]][nearC[j]] == 1) {
						map[nearR[j]][nearC[j]] = 0;
						die++;
					}
				}
				// 한줄씩 내려오기
				mapdown();
			}
			// 최대값
			ans = Math.max(ans, die);
			return;
		}
		if (idx == M)
			return;
		archor[idx] = true;
		combine(idx + 1, start + 1, selidx + 1);
		archor[idx] = false;
		combine(idx + 1, start + 1, selidx);
	}

	private static void mapdown() {
		for (int j = N - 2; j >= 0; j--)
			for (int k = 0; k < M; k++)
				map[j + 1][k] = map[j][k];
		for (int k = 0; k < M; k++) {
			map[0][k] = 0;
			map[N][k] = 0;
		}
	}

	private static void copycopymap() {
		for (int i = 0; i < N + 1; i++) {
			map[i] = cpymap[i].clone();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		cpymap = new int[N + 1][M];
		archor = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cpymap[i][j] = map[i][j];

			}
		}
		combine(0, 0, 0);
		System.out.println(ans);
	}
}