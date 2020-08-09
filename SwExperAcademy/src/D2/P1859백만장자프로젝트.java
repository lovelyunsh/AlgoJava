package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1859백만장자프로젝트 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int money[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			long result = 0;
			for(int i = N -1 ; i >=0 ; i--) {
				int now = money[i];
				if(now < max) {
					result += max - now;
				}
				else if(now > max) {
					max = now;
				}
				
			}
			

			System.out.printf("#%d %d\n", tc,result);
		}
	}
}