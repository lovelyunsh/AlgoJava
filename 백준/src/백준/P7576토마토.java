package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int map[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer> que = new LinkedList();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 1) {
					que.offer(i);
					que.offer(j);
				}
			}
		}
		que.offer(-1);
		int row_dirt[] = {1,0,-1,0};
		int col_dirt[] = {0,-1,0,1};
		int day = 0;
		while(true) {
			
			int nrow = que.poll();
			int ncol = que.poll();
			int temp_row;
			int temp_col;
			for(int i = 0 ; i < 4 ; i++) {
				temp_row = nrow+ row_dirt[i];
				temp_col = ncol+ col_dirt[i];
				if(temp_row>=0 && temp_col>=0 && temp_row <row && temp_col < col 
						&& map[temp_row][temp_col] == 0) {
					map[temp_row][temp_col] = 1;
					que.offer(temp_row);
					que.offer(temp_col);
					
				}
			}
			
			if(que.peek() == -1) {
				que.poll();
				if(que.isEmpty())
					break;
				day++;
				que.offer(-1);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(map[i][j] == 0)
					day = -1;
			}
		}
		System.out.println(day);
		
		
		

	}

}
