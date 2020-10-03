package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P19952인성문제있어 {
	static class node{
		int row;
		int col;
		int power;
		public node(int row, int col, int power) {
			super();
			this.row = row;
			this.col = col;
			this.power = power;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc  = 1 ; tc <= testcase ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int O = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			int SX = Integer.parseInt(st.nextToken())-1;
			int SY = Integer.parseInt(st.nextToken())-1;
			int GX = Integer.parseInt(st.nextToken())-1;
			int GY = Integer.parseInt(st.nextToken())-1;
			int [][] map = new int[H][W];
			boolean [][] visited = new boolean[H][W];
			map[GX][GY] = -1;
			for(int i = 0 ; i < O ; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int L = Integer.parseInt(st.nextToken());
				map[x][y] = L;
			}
			Queue<node> que = new LinkedList<node>();
			que.offer(new node(SX, SY, F));
			visited[SX][SY] = true;
			int dr[] = {1,-1,0,0};
			int dc[] = {0,0,1,-1};
			boolean flag = false;
			gg:while(!que.isEmpty()){
				node now = que.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int row = now.row + dr[i];
					int col = now.col + dc[i];
					
					int power = now.power;
					if(row<0 || col < 0 || row>= H || col>= W)
						continue;
					if(map[row][col] - map[now.row][now.col] >= power )
						continue;
					if(visited[row][col])
						continue;
					if(map[row][col] == -1) {
						flag = true;
						break gg;
					}
					visited[row][col] = true;
					que.offer(new node(row, col, power-1));
				}
			}
			System.out.println(flag? "잘했어!!":"인성 문제있어??");
			
			
			
			
			
		}
		
		
	}

}
