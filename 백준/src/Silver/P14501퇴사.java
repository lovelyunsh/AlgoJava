package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501퇴사 {
	static int N,len[],val[];
	static int max = 0;
	static void dfs(int now, int sum) {
		for(int i = now ; i < N ; i++) {
			if(i+len[i] >N) {
				max = Math.max(max, sum);
				continue;
			}
			if(i+len[i] == N) {
				max = Math.max(max, sum+val[i]);
				continue;
			}
			dfs(i+len[i],sum+val[i]);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		len = new int [N];
		val =new int [N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			len[i] = Integer.parseInt(st.nextToken());
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		System.out.println(max);
	}
}
