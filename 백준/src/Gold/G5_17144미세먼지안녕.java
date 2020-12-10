package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17144미세먼지안녕 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Point airCleaner = null;
		int map[][] = new int [R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)
					airCleaner = new Point(i,j);
			}
		}
		for(int i = 0 ; i < T ; i++) {
			map = spread(map, R, C);
			map = windStorm(map, R, C, airCleaner);
		}
		int result = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				result += map[i][j];
			}
		}
		result += 2;
		System.out.println(result);
		
	}
	
	static int[][] spread(int map[][], int R , int C){
		int spreadMap[][] = new int [R][C];
		int dr[] = {1,-1,0,0};
		int dc[] = {0,0,1,-1};
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 0 )
					continue;
				if(map[i][j] == -1)
					continue;
				int spreadCnt = 0 ;
				int dust = map[i][j] /5;
				for(int d = 0 ; d < 4 ; d++) {
					int row = i+dr[d];
					int col = j+dc[d];
					if(row<0 || col <0 || row>= R || col >= C)
						continue;
					if(map[row][col] == -1)
						continue;
					spreadMap[row][col] += dust;
					spreadCnt++;
				}
				map[i][j] -= dust*spreadCnt;
			}
		}
		for(int i = 0 ; i < R ; i++)
			for(int j = 0 ; j < C ; j++)
				map[i][j] += spreadMap[i][j];
		return map;
	}
	static int[][] windStorm(int map[][], int R , int C, Point air){
		int upDr[] = {0,-1,0,1};
		int upDc[] = {1,0,-1,0};
		int downDr[] = {0,1,0,-1};
		int downDc[] = {1,0,-1,0};
		Point upair = new Point(air.x-1,air.y);
		int pre = 0;
		int d = 0;
		int row = upair.x;
		int col = upair.y;
		
		while(true) {
			row = row + upDr[d];
			col = col + upDc[d];
			
			if(row <0 || col <0 || row>= R || col >= C) {
				row -= upDr[d];
				col -= upDc[d];
				d++;
				continue;
			}
			int temp = map[row][col];
			if(temp == -1)
				break;
			map[row][col] = pre;
			pre = temp;
			
		}
		d = 0;
		pre = 0;
		row = air.x;
		col = air.y;
		while(true) {
			row = row + downDr[d];
			col = col + downDc[d];
			if(row <0 || col <0 || row>= R || col >= C) {
				row -= downDr[d];
				col -= downDc[d];
				d++;
				continue;
			}
			int temp = map[row][col];
			if(temp == -1)
				break;
			map[row][col] = pre;
			pre = temp;
		}
		return map;
	}
}
