package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3019테트리스 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()) - 1;
		int shape[][][] = { { { 0 }, { 0, 0, 0, 0 } }, { { 0, 0 } }, { { 0, 0, 1 }, { 1, 0 } },
				{ { 1, 0, 0 }, { 0, 1 } }, { { 0, 0, 0 }, { 0, 1 }, { 1, 0, 1 }, { 1, 0 } },
				{ { 0, 0, 0 }, { 0, 0 }, { 0, 1, 1 }, { 2, 0 } }, { { 0, 0, 0 }, { 0, 0 }, { 1, 1, 0 }, { 0, 2 } } };
		st = new StringTokenizer(br.readLine());
		int map[] = new int[C];
		for (int i = 0; i < C; i++)
			map[i] = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < shape[P].length; i++)
			for (int j = 0; j < C - shape[P][i].length + 1; j++) {
				int diff = map[j] - shape[P][i][0];
				boolean ok = true;
				for (int k = 1; k < shape[P][i].length; k++)
					if (diff != map[j + k] - shape[P][i][k]) {
						ok = false;
						break;
					}
				if (ok)
					cnt++;
			}
		System.out.println(cnt);
	}

}
