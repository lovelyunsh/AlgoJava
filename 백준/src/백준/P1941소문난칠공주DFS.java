package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1941소문난칠공주DFS {
	static char map[][]; 
	static int result;
	static boolean[][] visit, end;
	static Point sel[];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static void dfs(Point p,int selidx) {
		if(selidx == 7) {
			int Y = 0;
			for(Point nn : sel) {
				if(map[nn.x][nn.y] == 'Y')
					Y++;
			}
			if(Y <= 3)
				result++;
			return;
		}
		if(sel[0].x == 3 && sel[0].y == 4) {
			System.out.println("hello");
		}
			
		
		for(Point n : sel) {
			for(int i = 0 ; i < 4 ; i++) {
				int row = n.x+dr[i];
				int col = n.y+dc[i];
				
				if(row < 0 || col <0 || row>= 5 || col >= 5)
					continue;
				if(visit[row][col])
					continue;
				if(end[row][col])
					continue;
				sel[selidx] = new Point(row,col);
				visit[row][col] = true;
				dfs(new Point(row,col),selidx+1);
				visit[row][col] = false;
				
			}
			
		}
		
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char [5][5];
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		end = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("123");
				visit = new boolean[5][5];
				sel = new Point[7];
				sel[0] = new Point(i,j);
				visit[i][j] = true;
				System.out.println(Arrays.toString(sel));
				dfs(new Point(i, j),1);
				end[i][j] = true;
			}
		}
		System.out.println(result);
	}
}
