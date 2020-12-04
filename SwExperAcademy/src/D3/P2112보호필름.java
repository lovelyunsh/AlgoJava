package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2112보호필름 {
	static int D, W, K;
	static int map[][];
	static int min;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	static void dfs(int selidx, int pill) { // D줄에 대해서 0이거나 1이거나 -1이거나
		if (pill >= min)
			return;

		if (selidx == D) {
			check(pill);
			return;
		}
		int temp[] = map[selidx].clone();

		dfs(selidx + 1, pill);

		Arrays.fill(map[selidx], 0);
		dfs(selidx + 1, pill + 1);

		Arrays.fill(map[selidx], 1);
		dfs(selidx + 1, pill + 1);

		map[selidx] = temp;
	}

	static void check(int pill) {
		for (int i = 0; i < W; i++) {
			boolean isOk = false;
			int zero = 0;
			int one = 0;
			for (int j = 0; j < D; j++) {
				if (map[j][i] == 0) {
					zero++;
					one = 0;
				} else {
					one++;
					zero = 0;
				}
				if (zero == K || one == K) {
					isOk = true;
					continue;
				}
			}
			if (!isOk)
				return;
		}
		min = Math.min(min, pill);
	}
}
