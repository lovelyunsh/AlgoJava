package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1034램프 {
	static int map[][];
	static int N, M, K, max;

	public static void main(String[] args) throws Exception {
		// 바꾸고 가고 안 바꾸고 가고 바꾼게 K 넘어가면 끝내고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(a.charAt(j) + "");
		}
		K = Math.min(Integer.parseInt(br.readLine()),M);
		dfs(0, 0);
		System.out.println(max);
	}

	static void dfs(int col, int usek) {
		if (usek % 2 == K % 2)
			max = Math.max(max, getcnt());

		if (usek == K || col == M)
			return;

		dfs(col + 1, usek);
		change(col);
		dfs(col + 1, usek + 1);
		change(col);
	}

	static void change(int col) {
		for (int i = 0; i < N; i++)
			map[i][col] = map[i][col] == 0 ? 1 : 0;
	}

	static int getcnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 1) {
					check = false;
					break;
				}
			}
			if (check)
				cnt++;
		}

		return cnt;
	}
}