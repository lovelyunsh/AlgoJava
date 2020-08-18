package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1941소문난칠공주DFS {
	static char map[][]; 
	static boolean visit[][];
	static int result;
	static boolean[][]  end;
	static int dr[] = {1,0};
	static int dc[] = {0,1};
	static void dfs(Point p,int selidx , Point sel []) {
		if(selidx == 7) {
			int Y = 0;
			for(Point nn : sel) {
				if(map[nn.x][nn.y] == 'Y')
					Y++;
			}
			if(Y > 3)
				return;
			System.out.println(Arrays.toString(sel));
			result++;
			return;
		}	
		for(Point n : sel) {
			if(n == null)
				break;
			boolean flag = false; // 역 ㄱ자 모양 중복 제거용
			
			for(Point a : sel) {
				if(a == null)
					break;
				if(n.x-1 == a.x && n.y +1 == a.y) {
					flag = true;
					break;
				}
			}
			for(int i = 0 ; i < 2 ; i++) {
				int row = n.x+dr[i];
				int col = n.y+dc[i];
				
				if(row < 0 || col <0 || row>= 5 || col >= 5)
					continue;
				if(end[row][col])
					continue;
				if(visit[row][col])
					continue;
				sel[selidx] = new Point(row,col);
				visit[row][col] = true;
				dfs(new Point(row,col),selidx+1, sel);
				visit[row][col] = false;
				if(flag) //역 ㄱ자 모양이면 밑에만 검사 오른쪽 검사 ㄴㄴ
					break;
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
				visit = new boolean[5][5];
				Point sel [] = new Point[7];
				sel[0] = new Point(i,j);
				dfs(new Point(i, j),1,sel);
				end[i][j] = true;
			}
		}
		System.out.println(result);
	}
}
