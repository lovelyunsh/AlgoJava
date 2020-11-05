package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P2115벌꿀채취 {

	static class range implements Comparable<range> {
		int x;
		int y;
		int sum;

		public range(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(range o) {
			// TODO Auto-generated method stub
			return o.sum - this.sum;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<range> a = new ArrayList<range>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					a.add(new range(i, j, calc(map, i, j, C, M)));
				}
			}
			Collections.sort(a);
			range first = null;
			range second = null;
			int max = 0;
			for (int i = 0; i < a.size(); i++) {
				first = a.get(i);
				for (int j = i + 1; j < a.size(); j++) {
					second = a.get(j);
					if (second.x == first.x && first.y < second.y && second.y < first.y + M)
						continue;
					if (second.x == first.x && second.y < first.y && first.y < second.y + M)
						continue;
					if(first.sum + second.sum < max)
						break;
					max = Math.max(max, first.sum+second.sum);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	static int calc(int map[][], int x, int y, int C, int M) {
		int nums[] = new int[M];
		int dp[][] = new int[M + 1][C + 1];
		for (int i = y; i < y + M; i++) {
			nums[i - y] = map[x][i];
		}
		for (int i = 1; i <= M; i++) {
			int num = nums[i - 1];
			for (int j = 1; j <= C; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= num) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - num] + num * num);
				}
			}
		}
		return dp[M][C];
	}

}
