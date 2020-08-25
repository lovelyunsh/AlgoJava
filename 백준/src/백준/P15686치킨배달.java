package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P15686치킨배달 {
	static int N, M, map[][], sel[], countOne;
	static boolean visit[][];
	static List<Point> parr;
	static int min = 123456789;
	static int dr[] = {1,0,-1,0};
	static int dc[] = {0,-1,0,1};

	static void comb(int idx, int selidx) {
		if (selidx == M) {
			visit = new boolean[N][N];
			BFS();
			return;
		}
		if (idx == parr.size())
			return;

		sel[selidx] = idx;
		comb(idx + 1, selidx + 1);
		comb(idx + 1, selidx);

	}

	static void BFS() {
		Queue<Point> que = new LinkedList<Point>();
		int one = 0;
		int dist = 0;
		int fullDistance = 0;
		for(int i : sel) {
			Point p = parr.get(i);
			que.offer(p);
			visit[p.x][p.y]= true;
		}
		que.offer(new Point(-1,-1));
		while(true) {
			Point p = que.poll();
			
			if(p.x == -1) {
				if(que.isEmpty())
					break;
				dist++;
				que.offer(new Point(-1,-1));
				continue;
			}
			
			if(map[p.x][p.y] == 1) { 
				one++;
				fullDistance += dist;
			}
			
			if(one == countOne) {
				min = Math.min(min, fullDistance);
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				int row = p.x+dr[i];
				int col = p.y+dc[i];
				if(row<0 || col<0 || row>=N || col >= N)
					continue;
				if(visit[row][col])
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
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		sel = new int[M];
		parr = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					parr.add(new Point(i, j));
				if (map[i][j] == 1)
					countOne++;
			}

		}
		comb(0, 0);
		System.out.println(min);

	}

}
