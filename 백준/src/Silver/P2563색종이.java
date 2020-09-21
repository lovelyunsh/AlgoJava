package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563색종이 {
	
	public static void main(String[] args) throws Exception {
		int map[][] = new int [101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			for(int j = 0; j<10 ;j++) {
				for(int k = 0 ; k < 10 ;k++) {
					if(map[row+j][col+k] == 0) {
						cnt++;
						map[row+j][col+k] = 1;
					}
				}
			}
		}
		System.out.println(cnt);
				
		
	}

}
