package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1868파핑파핑지뢰찾기 {
	
	static char map[][];
	static int mine,dot,N,click;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			mine = 0;
			dot = 0;
			click = 0;
			for(int i = 0 ; i < N ; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] == '.')
						dot++;
					else
						mine++;
				}
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(map[i][j] == '*')
						continue;
					if(count(i,j) == 0) {
						click++;
						spread(i,j);
					}
				}
			}
			System.out.println("#"+tc+" "+ (dot+click));
			
		}
	}
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	
	static int count(int x, int y) {
		int mymine = 0;
		for(int i = 0 ; i < 8 ; i++) {
			int row = x+dr[i];
			int col = y+dc[i];
			if(row<0 || col<0 || row>=N || col>= N)
				continue;
			if(map[row][col] == '*')
				mymine++;
		}
		
		return mymine;
	}
	static void spread(int x , int y) {
		int cnt = count(x,y);
		dot--;
		if(cnt == 0) {
			map[x][y] = '-';
			for(int i = 0 ; i < 8 ; i++) {
				int row = x+dr[i];
				int col = y+dc[i];
				if(row<0 || col<0 || row>=N || col>= N)
					continue;
				if(map[row][col] != '.')
					continue;
				spread(row,col);
			}
		}else {
			map[x][y] = '-';
		}
		
	}
}