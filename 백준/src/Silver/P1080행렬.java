package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1080행렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][][] = new int[2][N][M];
		for (int n = 0; n < 2; n++)
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[n][i][j] = Integer.parseInt(s.charAt(j) + "");
				}
			}
		int cnt = 0;
		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (map[0][i][j] != map[1][i][j]) {
					change(map, i, j);
					cnt++;
				}
			}
		}
		boolean ok = true;
		gg: for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[0][i][j] != map[1][i][j]) {
					ok = false;
					break gg;
				}
		System.out.println(ok ? cnt : -1);
	}

	static void change(int map[][][], int row, int col) {
		for (int i = row; i < row + 3; i++)
			for (int j = col; j < col + 3; j++)
				map[0][i][j] = map[0][i][j] == 0 ? 1 : 0;

	}

}
