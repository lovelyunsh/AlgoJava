package D3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1949등산로조성 {
	static class node{
		int x;
		int y;
		int cnt;
		int num;
		boolean use;
		boolean visit[][]; //이렇게 까지 해야하나 자괴감이 든다.
		public node(int x, int y, int cnt, int num, boolean use,boolean visit[][]) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.num = num;
			this.use = use;
			this.visit = visit;
		}
		
	}
	
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			int maxnum = 0;
			List<Point> maxfriend = new ArrayList<Point>();
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > maxnum) {
						maxfriend.clear();
						maxfriend.add(new Point(i,j));
						maxnum = map[i][j];
					}else if(map[i][j] == maxnum) {
						maxfriend.add(new Point(i,j));
					}
				}
			}
			Queue<node> que = new LinkedList<node>();
			
			for(int i = 0 ; i < maxfriend.size() ; i++) {
				Point p = maxfriend.get(i);
				boolean visit[][] = new boolean[N][N]; 
				visit[p.x][p.y] = true;
				que.offer(new node(p.x, p.y, 1, maxnum, false,visit));
			}
			
			
			int max = 0;
			int dr[] = {-1,1,0,0};
			int dc[] = {0,0,1,-1};
			while(!que.isEmpty()) {
				node now = que.poll();
				max = Math.max(max, now.cnt);
				for(int d = 0 ; d < 4 ; d++) {
					
					int row = now.x + dr[d];
					int col = now.y + dc[d];
					if(row < 0 || col < 0 || row >= N || col >= N)
						continue;
					if(now.visit[row][col])
						continue;
					
					boolean[][] myvisit = new boolean[N][N]; 
					for(int i = 0 ; i < N ; i++) 
						myvisit[i] = now.visit[i].clone();
					myvisit[row][col] = true;
					
					if(map[row][col] >= now.num ) {
						if( now.use|| map[row][col] - K >= now.num)
							continue;
						que.offer(new node(row, col, now.cnt+1,now.num-1 ,true,myvisit));
						continue;
					}
					que.offer(new node(row,col,now.cnt+1,map[row][col],now.use,myvisit));
				}
			}
			System.out.printf("#%d %d\n", tc,max);
		}
	}

}
