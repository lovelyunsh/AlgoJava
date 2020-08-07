package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1946간단한압축풀기 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			for(int i = 0 ; i<N ; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				int m = Integer.parseInt(st.nextToken());
				for(int j = 0 ; j < m ; j++) {
					sb.append(ch);
					cnt++;
					if(cnt %10 == 0)
						sb.append("\n");
				}
			}
			System.out.printf("#%d\n", tc);
			System.out.println(sb);
		}
	}


}
