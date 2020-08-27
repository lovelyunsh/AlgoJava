package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178미로탐색 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int [N][M];
		boolean visted[][] = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			char[] a = br.readLine().toCharArray();
			for(int j = 0 ; j< M ; j++) {
				map[i][j] = (int) (a[j]- '0');
			}
		}
		Queue<Integer> que = new LinkedList();
		int row_dirt[] = {1,0,-1,0};
		int col_dirt[] = {0,-1,0,1};
		que.offer(0);
		que.offer(0);
		que.offer(-1);
		int dist = 1;
		int result = 0;
		gg:while(true) {
			int nrow = que.poll();
			int ncol = que.poll();
			int temp_row;
			int temp_col;
			for(int i = 0 ; i < 4 ; i++) {
				temp_row = nrow+ row_dirt[i];
				temp_col = ncol+ col_dirt[i];
				if(temp_row>=0 && temp_col>=0 && temp_row <N && temp_col < M 
						&& !visted[temp_row][temp_col] && map[temp_row][temp_col] == 1) {
					que.offer(temp_row);
					que.offer(temp_col);
					visted[temp_row][temp_col] = true;
				}
				if(temp_row == N-1 && temp_col == M-1) {
					result = dist+1;
					break gg;
				}
					
			}
			if(que.peek() == -1) {
				que.poll();
				if(que.isEmpty())
					break;
				dist++;
				que.offer(-1);
			}			
			
		}
		System.out.println(result);
	}

}
