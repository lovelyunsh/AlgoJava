package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16987계란으로계란치기 {
	static Point egg[];
	static int N, cnt, max;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		egg = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		dfs(0);
		System.out.println(max);

	}

	static void dfs(int idx) {
		if (idx == N) {
			max = Math.max(cnt, max);
			if (max == N)
				flag = true;
			return;
		}
		if (flag)
			return;
		if (egg[idx].x <= 0) {
			dfs(idx+1);
			return;
		}
		int broken = 0;
		for (int i = 0; i < N; i++) {
			if (i == idx) 
				continue;
			
			if (egg[i].x <= 0) {
				broken++;
				continue;
			}
			egg[idx].x -= egg[i].y;
			egg[i].x -= egg[idx].y;
			if (egg[idx].x <= 0)
				cnt++;

			if (egg[i].x <= 0)
				cnt++;

			dfs(idx + 1);

			if (egg[idx].x <= 0)
				cnt--;

			if (egg[i].x <= 0)
				cnt--;

			egg[idx].x += egg[i].y;
			egg[i].x += egg[idx].y;

		}
		if(broken == N-1) {
			dfs(idx+1);
		}

	}

}
