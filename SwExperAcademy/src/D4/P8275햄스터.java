package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P8275햄스터 {
	static int N,X,M,con[][];
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 케이지 갯수
			X = Integer.parseInt(st.nextToken()); // 햄스터 최대 수
			M = Integer.parseInt(st.nextToken()); // 조건 갯수
			cage = new int[N];
			maxsel = new int[N];
			con = new int[M][3];
			max = -1;
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken())-1;
				con[i][1] = Integer.parseInt(st.nextToken())-1;
				con[i][2] = Integer.parseInt(st.nextToken());
			}
			
			makeHam(0);
			String ans = "";
			if(max == -1) {
				ans += -1;
			}else {
				for(int i = 0 ; i < N ; i++)
					ans = ans + maxsel[i] + " ";
			}
			
			System.out.printf("#%d "+ans+"\n", tc);
		}
	}
	static int [] cage;
	static int max;
	static int maxsel[];
	static void makeHam(int selidx) {
		if(selidx == N) {
			if(check()) {
				int sum = 0;
				for(int i = 0 ; i < N ; i++) {
					sum += cage[i];
				}
				if(sum > max) {
					max = sum;
					for(int i = 0 ; i < N ; i++)
						maxsel[i] = cage[i];
				}
				
			}
			
			return;
		}
		
		for(int i = 0 ; i <= X ; i++) {
			cage[selidx] = i;
			makeHam(selidx+1);
		}
		
	}
	static boolean check() {
		for(int i = 0 ; i < M ; i++) {
			int sum = 0;
			for(int j = con[i][0]; j <= con[i][1]; j++) {
				sum += cage[j];
			}
			if(con[i][2] != sum)
				return false;
		}
		
		return true;
	}


}
