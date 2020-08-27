package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class room1{
	int row;
	int col;
	int cnt;
	int one;
	public room1(int row, int col, int cnt, int one) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.one = one;
	}
	
	
}
public class P14442벽부수고이동하기2 {
	static char map[][];
	static int M,N,K;
	static boolean visit[][][];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static int min = 123456789;
	static void bfs(room1 r) {
		
		Queue<room1> que = new LinkedList<room1>();
		que.offer(r);
		while(!que.isEmpty()) {
			room1 now = que.poll();
			if(now.row == M-1 && now.col == N-1) {
				min = Math.min(min, now.cnt);
				return;
			}
			
			g:for(int i = 0 ; i < 4 ; i++) {
				int row = now.row+dr[i];
				int col = now.col+dc[i];
				
				if(row<0 || col<0 || row>=M || col>=N)
					continue;
				
				for(int j = 0 ; j <= now.one ; j++)
					if(visit[j][row][col]) 
						continue g;
					
				
				
				if(map[row][col] == '0') {
					visit[now.one][row][col] = true;
					que.offer(new room1(row, col, now.cnt+1, now.one));
					
				}
				
				
				if(map[row][col] == '1') {
					if(now.one == K)
						continue;
					visit[now.one+1][row][col] = true;
					que.offer(new room1(row, col, now.cnt+1, now.one+1));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[K+1][M][N];
		for(int i = 0 ; i < M ; i++ ) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		visit[0][0][0] = true;
		bfs(new room1(0, 0, 1, 0));
		if(min == 123456789)
			min = -1;
		System.out.println(min);
		
		
	}

}
