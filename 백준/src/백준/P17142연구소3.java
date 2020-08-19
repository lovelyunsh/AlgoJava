package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//조합 bfs 날짜세기 짬뽕문제
public class P17142연구소3 {
	static boolean visit[][];
	static ArrayList<Point> virus = new ArrayList<Point>();
	static int N, V, zeroCnt, map[][];
	static int min = 123456789;
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};
	static void comb(int[] sel, int sidx, int idx) {
		if(sidx == V) {
			visit = new boolean[N][N];
			BFS(sel);
			return;
		}
		if(idx == virus.size())
			return;
		
		sel[sidx] = idx;
		comb(sel,sidx+1,idx+1);
		comb(sel,sidx,idx+1);
		
	}
	
	static void BFS(int sel[]) {
		Queue<Point> que = new LinkedList<Point>();
		for(int i : sel) {
			Point v = virus.get(i);
			que.offer(v);
			visit[v.x][v.y] = true;
		}
		que.offer(new Point(-1,-1));
		int cnt = 0;
		int time = 0;
		while(true) {
			Point p = que.poll();
			if(p.x == -1) {
				if(que.isEmpty())
					break;
				time++;
				que.offer(new Point(-1,-1));
				continue;
			}
			if(map[p.x][p.y] == 0) { 
				cnt++;
			}
			if(cnt == zeroCnt) {
				min = Math.min(min, time);
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int row = p.x+dr[i];
				int col = p.y+dc[i];
				if(row<0 || col<0 || row>=N || col >= N)
					continue;
				if(visit[row][col])
					continue;
				if(map[row][col] == 1)
					continue;
				
				visit[row][col] = true;
				que.offer(new Point(row,col));
			}
			
				
			
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visit = new boolean[N][N];
		zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zeroCnt++; //0의 갯수 세어 놓기
				if (map[i][j] == 2)
					virus.add(new Point(i, j)); //바이러스의 위치
			}
		}
		
		comb(new int[V], 0, 0);
		if(min == 123456789)
			min = -1;
		
		System.out.println(min);
		
	}

}
