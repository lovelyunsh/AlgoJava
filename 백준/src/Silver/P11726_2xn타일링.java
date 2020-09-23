package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11726_2xn타일링 {
	public static void main(String[] args) throws Exception {
		int ppre = 1;
		int pre = 1;
		int now = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 2 ; i <= N ; i++ ) {
			now = (pre + ppre)%10007;
			ppre = pre;
			pre = now;
			
		}
		System.out.println(now);
	}
}
