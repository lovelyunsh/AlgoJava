package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5656벽돌깨기 {
	
	static int map[][],N,W,H,result,max,rock;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			result = 0;
			max = 0;
			rock = 0;
			for(int i = 0 ; i < H ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)
						rock++;
				}
			}
		
			go(0);
			System.out.println("#"+tc+" "+ (rock - max));
		}
	}
	static void go(int cnt) {
		if(cnt == N) {
			max = Math.max(max, result);
			return;
		}
		int tempmap[][] = new int[H][W];
		for(int j = 0 ; j < H ; j++)
			tempmap[j]  = map[j].clone();
		int tempresult = result;
		for(int i = 0 ; i < W ; i++) {
			dropRock(i);
			go(cnt+1);
			result = tempresult;
			for(int j = 0 ; j < H ; j++)
				map[j]  = tempmap[j].clone();
		}
		
		
		
	}
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static void dropRock(int w) {
		for(int i = 0 ; i < H ; i++) {
			if(map[i][w] != 0) {
				pung(i,w);
				drop();
				break;
			}
		}
	}
	static void pung(int x, int y) {
		int size = map[x][y];
		map[x][y] = 0;
		result++;
		for(int d = 0 ; d < 4 ; d++) {
			int row = x;
			int col = y;
			for(int s = 1 ; s< size; s++) {
				row = row+dr[d];
				col = col+dc[d];
				
				if( row < 0 || col < 0 || row>= H ||col>=W)
					break;
				if(map[row][col] == 0)
					continue;
				if(map[row][col] > 1) {
					pung(row,col);
					continue;
				}
				result++;
				map[row][col] = 0;
			}
		}
	}
	static void drop() {
		for(int i = 0 ; i < W ; i++) {
			for(int j = H-1 ; j >=0 ; j--) {
				if(map[j][i] == 0) {
					for(int k = j-1 ; k >= 0 ; k--) {
						if(map[k][i] != 0) {
							map[j][i] = map[k][i];
							map[k][i] = 0; 
							break;
						}
					}
				}
			}
		}
	}
	
	

}
