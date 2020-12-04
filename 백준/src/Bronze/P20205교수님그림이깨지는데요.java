package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20205교수님그림이깨지는데요 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int map[][] = new int [N*K][N*K];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int num = Integer.parseInt(st.nextToken());
				for(int k = i*K ; k < i*K+K ; k++) {
					for(int l = j*K ; l < j*K+K ; l++) {
						map[k][l] = num;
					}
				}
			}
		}
		
		for(int i = 0 ; i < N*K ; i++) {
			for(int j = 0 ; j < N*K ; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
	}

}
