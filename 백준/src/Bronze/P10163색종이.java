package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10163색종이 {
	
	public static void main(String[] args) throws Exception {
		int map[][] = new int [101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st [] = new StringTokenizer[N];
		for(int i = 0 ; i < N ; i++) {
			st[i] = new StringTokenizer(br.readLine());
		}
		int result[] = new int[N];
		for(int i = N-1 ; i >=0  ; i--) {
			
			int row1 = Integer.parseInt(st[i].nextToken());
			int col1 = Integer.parseInt(st[i].nextToken());
			int row2 = Integer.parseInt(st[i].nextToken());
			int col2 = Integer.parseInt(st[i].nextToken());
			int cnt = 0;
			for(int j = 0; j<row2 ;j++) {
				for(int k = 0 ; k < col2 ;k++) {
					if(map[row1+j][col1+k] == 0) {
						cnt++;
						map[row1+j][col1+k] = i+1;
					}
				}
			}
			result[i] = cnt;
		}
		for(int i = 0 ; i < N ; i++) {
			System.out.println(result[i]);
		}
				
		
	}

}
