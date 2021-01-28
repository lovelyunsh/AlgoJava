package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15661링크와스타트 {
	
	static boolean sel[];
	static int map [][],N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sel = new boolean[N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		powerset(0);
		System.out.println(ans);
		
	}
	static int ans = Integer.MAX_VALUE;
	static void powerset(int idx) {
		if(idx == N) {
			int diff = calc();
			ans = Math.min(diff, ans);
			return;
		}
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		
	}
	
	static int calc() {
		int linksum = 0,startsum = 0;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(sel[i] && sel[j]) linksum += map[i][j];
				if(!sel[i] && !sel[j]) startsum += map[i][j];
			}
		}
		return Math.abs(linksum-startsum);
	}

}
