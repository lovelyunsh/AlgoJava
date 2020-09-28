package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2116주사위쌓기 {
	static int N, dice[][], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				if (j == 3)
					dice[i][4] = Integer.parseInt(st.nextToken());
				else if (j == 4)
					dice[i][3] = Integer.parseInt(st.nextToken());
				else
					dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// AFBDCE
		// 051324
		for (int i = 0; i < 6; i++)
			dfs(dice[0][i], 0, 0);
		System.out.println(max);
	}

	static void dfs(int down, int index, int sum) {
		if (index == N) {
			max = Math.max(sum, max);
			return;
		}
		if (sum + (N - index) * 6 <= max) {
			return;
		}
		int up = 0;
		for (int i = 0; i < 6; i++) {
			if (dice[index][i] == down) {
				up = dice[index][5 - i];
				break;
			}
		}
		int maxside = 0;
		for (int i = 0; i < 6; i++) {
			if (dice[index][i] == down || dice[index][i] == up) {
				continue;
			}
			maxside = Math.max(maxside, dice[index][i]);
		}
		dfs(up, index + 1, sum + maxside);

	}

}
