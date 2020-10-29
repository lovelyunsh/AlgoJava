package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4014 {

	static int[][] map;
	static int N, X, T, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			answer = 0;

			for (int r = 0; r < N; ++r) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < N; ++r) {
				if (isAble(r, true)) {
					answer++;
				} else {
					if (check(r, true)) {
						answer++;
					}
				}
			}

			for (int c = 0; c < N; ++c) {
				if (isAble(c, false)) {
					answer++;
				} else {
					if (check(c, false)) {
						answer++;
					}
				}
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	private static boolean check(int idx, boolean isRow) {
		boolean[] visited = new boolean[N];
		int cnt = 0;
		int before = -1;

		if (isRow) {
			before = map[idx][0];

			for (int c = 0; c < N; ++c) {
				int cur = map[idx][c];

				if (cur == before) {
					cnt++;
				} else {
					if (cur == before + 1) {
						if (cnt >= X) {
							for (int i = c - X; i < c; ++i) {
								if (visited[i])
									return false;
								visited[i] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if (cur == before - 1) {
						if (c + X - 1 < N) {
							for (int i = c; i < c + X; ++i) {
								if (visited[i] || map[idx][i] != cur)
									return false;
								visited[i] = true;
							}
							cnt = 0;
							c = c + X - 1;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		} else {
			before = map[0][idx];

			for (int r = 0; r < N; ++r) {
				int cur = map[r][idx];

				if (cur == before) {
					cnt++;
				} else {
					if (cur == before + 1) {
						if (cnt >= X) {
							for (int i = r - X; i < r; ++i) {
								if (visited[i])
									return false;
								visited[i] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if (cur == before - 1) {
						if (r + X - 1 < N) {
							for (int i = r; i < r + X; ++i) {
								if (visited[i] || map[i][idx] != cur)
									return false;
								visited[i] = true;
							}
							r = r + X - 1;
							cnt = 0;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		}

		return true;
	}

	private static boolean isAble(int idx, boolean isRow) {
		int start = -1;

		if (isRow) {
			start = map[idx][0];
			for (int c = 1; c < N; ++c) {
				if (map[idx][c] != start)
					return false;
			}
		} else {
			start = map[0][idx];
			for (int r = 1; r < N; ++r) {
				if (map[r][idx] != start)
					return false;
			}
		}

		return true;
	}
}