package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class room{
	int row;
	int col;
	int cnt;
	int one;
	public room(int row, int col, int cnt, int one) {
		super();
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.one = one;
	}
	
	
}
public class P2206벽부수고이동하기 {
	static char map[][];
	static int M,N;
	static boolean visit[][][];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static int min = 123456789;
	static void bfs(room r) {
		
		Queue<room> que = new LinkedList<room>();
		que.offer(r);
		while(!que.isEmpty()) {
			room now = que.poll();
			if(now.row == M-1 && now.col == N-1) {
				min = Math.min(min, now.cnt);
				return;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int row = now.row+dr[i];
				int col = now.col+dc[i];
				
				if(row<0 || col<0 || row>=M || col>=N)
					continue;
				if(now.one == 0) {
					if(visit[row][col][0])
						continue;
					if(map[row][col] == '1' ) {
						que.offer(new room(row, col, now.cnt+1, now.one+1));
						continue;
					}
					visit[row][col][0] = true;
					que.offer(new room(row, col, now.cnt+1, now.one));
					
				}
				
				
				if(now.one == 1) {
					if(visit[row][col][1] || visit[row][col][0])
						continue;
					if(map[row][col] == '1')
						continue;
					visit[row][col][1] = true;
					que.offer(new room(row, col, now.cnt+1, now.one));
					
				}
				
				
			}
			
			
			
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[M][N][2];
		for(int i = 0 ; i < M ; i++ ) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		visit[0][0][0] = true;
		bfs(new room(0, 0, 1, 0));
		if(min == 123456789)
			min = -1;
		System.out.println(min);
		
		
	}

}
