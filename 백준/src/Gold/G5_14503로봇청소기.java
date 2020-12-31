package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14503로봇청소기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());

		int nowr = Integer.parseInt(st.nextToken());
		int nowc = Integer.parseInt(st.nextToken());
		int nowd = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int dr[] = { -1, 0, 1, 0 };
		int dc[] = { 0, 1, 0, -1 };

		ggg:while (true) {
			map[nowr][nowc] = 2;
			cnt++;
			gg:while (true) {
				for (int i = 1; i <= 4; i++) {
					int tempd = (nowd + 3 * i) % 4;
					int tempr = nowr + dr[tempd];
					int tempc = nowc + dc[tempd];
					if (tempr < 0 || tempc < 0 || tempr > N || tempc > M)
						continue;
					if (map[tempr][tempc] != 0)
						continue;
					nowd = tempd;
					nowr = tempr;
					nowc = tempc;
					break gg;
				}
				nowr = nowr - dr[nowd];
				nowc = nowc - dc[nowd];
				if (nowr < 0 || nowc < 0 || nowr > N || nowc > M || map[nowr][nowc] == 1)
					break ggg;
			}
		}
		System.out.println(cnt);
		
	}

}
