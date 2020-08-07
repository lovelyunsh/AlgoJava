package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1204최빈수구하기 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			Integer[] numarr = new Integer[1000];
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				numarr[j++] = Integer.parseInt(st.nextToken());
			Arrays.sort(numarr,Collections.reverseOrder());
			int nownum = 0;
			int max = 0;
			int cnt = 0;
			int result = 0;
			for (int i = 0; i < 1000; i++) {
				if (nownum != numarr[i]) {
					nownum = numarr[i];
					if(cnt > max) {
						result = nownum;
						max = cnt;
					}
					if (max > 1000 - i)
						break;
					cnt = 0;
				}
				cnt++;
			}

			System.out.printf("#%d %d\n", tc, result+1);
		}
	}

}
