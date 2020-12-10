package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_1194달이차오른다 {
	static int N,M;
	static char [][]map;
	static boolean visit[][][];
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static class minsik{
		int row;
		int col;
		int keyS;
		int cnt;
		public minsik(int row, int col, int keyS, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.keyS = keyS;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][1<<6];
		
		Queue<minsik> que = new LinkedList<minsik>();
		
		
		for(int i = 0 ; i < N ; i++) {
			String a = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = a.charAt(j);
				if(map[i][j] == '0') {
					que.offer(new minsik(i, j, 0, 0));
					visit[i][j][0] = true;
				}
			}
		}
		while(!que.isEmpty()) {
			
			minsik now = que.poll();
			if(map[now.row][now.col] == '1') {
				System.out.println(now.cnt);
				return;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int row = now.row + dr[i];
				int col = now.col + dc[i];
				int keyS = now.keyS;
				int cnt = now.cnt+1;
				if(row < 0 || col < 0 || row>= N || col >= M) 
					continue;
				if(map[row][col] == '#')
					continue;
				
				if(map[row][col] >='a' &&map[row][col] <= 'z') {
					keyS = keyS|(1 << (map[row][col] - 'a'));
				}
				if(visit[row][col][keyS])
					continue;
				if(map[row][col] >='A' &&map[row][col] <= 'Z') {
					if((keyS & (1 << (map[row][col] - 'A')))== 0) 
						continue;
				}
				visit[row][col][keyS] = true;
				que.offer(new minsik(row, col, keyS, cnt));
			}
		}
		System.out.println(-1);
		
	}

}
