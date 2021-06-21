package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class G4_1580위치바꾸기 {
	// 일단 A가 가는 최소 경로 찾아
	// 그다음 B가 그 경로 피해서 갈 수 있는 최소 찾아
	// A가 4 고 B가 6이야
	// 그럼 A가 5로 가는 거 찾고 다시 B로 최소 가는거 찾아서 5 안넘어가 가는지만 찾으면 돼
	static char firstmap[][];
	static int firsttrack[][];
	static class node {
		int x;
		int y;
		int track[][];
		public node(int x, int y, int[][] track) {
			this.x = x;
			this.y = y;
			this.track = track;
		}
		
	}
	static int N,M;
	static Point A,B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		firstmap = new char[N][M];
		firsttrack = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String S = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				firstmap[i][j] = S.charAt(j);
				if(firstmap[i][j] == 'A') {
					A = new Point(i,j);
					firsttrack[i][j] = 1;
				}
				
				else if(firstmap[i][j] == 'B') { 
					B = new Point(i,j);
					firsttrack[i][j] = -1;
				}
			}
		}
	}
	static void simul() {
		findA();
		
	}
	static int dr[] = {-1,-1,-1,0,1,1,1,0,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1,0};
	static void findA() {
		Queue<node> que = new LinkedList<node>();
		que.add(new node(A.x, A.y, clonetrack(firsttrack)));
		int cnt = 0;
		while(!que.isEmpty()) {
			for(int s = que.size() ; s> 0 ; s--) {
				node now = que.poll();
				for(int i = 0 ; i < 9 ; i++) {
					int row = now.x+dr[i];
					int col = now.y+dc[i];
					int nowtrack [][] = clonetrack(now.track);
					if(row<0 || col <0 || row>= N || col >= M)
						continue;
					if(firstmap[row][col] == 'X')
						continue;
					if(i !=8 && nowtrack[row][col] != 0 )
						continue;
					nowtrack[row][col] = 1;
					
				}
			}
			cnt++;
		}
	}
	static int[][] clonetrack(int[][] track) {
		int[][] newtrack = new int[N][M];
		for(int i = 0 ; i < N ; i++)
			newtrack[i] = track[i].clone();
		return newtrack;
	}
}
