package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1954달팽이숫자 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(bf.readLine());
		
		int move_row[] = {0,1,0,-1};
		int move_col[] = {1,0,-1,0};
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int snail[][] = new int [N][N];
			boolean check[][] = new boolean[N][N];
			int cnt = 0;
			int row = 0;
			int col = 0;
			int dir = 0;
			while(true) {
				snail[row][col]  = ++cnt;
				check[row][col] = true;
				row+= move_row[dir];
				col+= move_col[dir];
				if(cnt == N*N)
					break;
				if(row <0 || col <0 || row >= N || col >= N || check[row][col]) {
					row-= move_row[dir];
					col-= move_col[dir];
					dir = dir == 3 ? 0 : dir+1;
					row+= move_row[dir];
					col+= move_col[dir];
				}
			}
			
			
			System.out.printf("#%d\n", tc);
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					System.out.print(snail[i][j]+ " ");
				}
				System.out.println();
			}
		}
	}
}
