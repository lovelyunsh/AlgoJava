package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976시각덧셈 {
	public static void main(String args[]) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		st = new StringTokenizer(bf.readLine());
		T = Integer.parseInt(st.nextToken());
		

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int hr = h1+h2;
			int mr = m1+m2;
			hr = (hr + mr/60)%12;
			hr = hr == 0 ? 12:hr;
			mr = mr%60;
			
			
			System.out.printf("#%d %d %d\n", tc, hr, mr);
		}
	}
	

}
