package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1983조교의성적매기기 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			float scoreboard[] = new float [N];
			float kscore = 0;
			for(int i = 0 ; i < N ; i ++) {
				st = new StringTokenizer(br.readLine());
				float a = Integer.parseInt(st.nextToken());
				float b = Integer.parseInt(st.nextToken());
				float c = Integer.parseInt(st.nextToken());
				float d = a*35/100 + b*45/100 + c*20/100;
				scoreboard[i] = d;
				if(i == K-1)
					kscore = d;
			}
			String [] scorechar = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			Arrays.sort(scoreboard);
			int nn = N/10;
			String result= "";
			for(int i = 0 ; i < N ; i++) {
				if(scoreboard[N-1-i] == kscore) {
					result = scorechar[i/nn];
					break;
				}
				
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
