package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1946신입사원 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int score[] = new int [N+1];
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				int docu = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				score[docu] = inter;
			}
			int min = score[1];
			int cnt = 1;
			for(int i =2 ; i < N+1 ; i++) {
				if(score[i] < min) { 
					cnt++;
					min = score[i];
				}
			}
			System.out.println(cnt);
		}
	}
}
