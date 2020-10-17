package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15683감시 {
	
	static int N,M,map[][];
	//1 왼 2 위 3 오 4 밑
	static ArrayList<int []>[] cctv = new ArrayList [6];
	static ArrayList<Point> cctvPoint = new ArrayList<Point>();
	static int zerosize = 0;
	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws Exception {
		for(int i =1 ; i < 6 ; i++) {
			cctv[i] = new ArrayList<int []>();
		}
		cctv[1].add(new int[] {1});cctv[1].add(new int[] {2});cctv[1].add(new int[] {3});cctv[1].add(new int[] {4});
		cctv[2].add(new int[] {1,3});cctv[2].add(new int[] {2,4});
		cctv[3].add(new int[] {1,2});cctv[3].add(new int[] {2,3});cctv[3].add(new int[] {3,4});cctv[3].add(new int[] {4,1});
		cctv[4].add(new int[] {1,2,3});cctv[4].add(new int[] {2,3,4});cctv[4].add(new int[] {3,4,1});cctv[4].add(new int[] {4,1,2});
		cctv[5].add(new int[] {1,2,3,4});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zerosize++;
				if(map[i][j] != 0 && map[i][j] != 6)
					cctvPoint.add(new Point(i,j));
			}
		}
		dfs(0);
		System.out.println(min);
	}
	
	static void dfs(int order) {
		if(order == cctvPoint.size()) {
			min = Math.min(min, zerosize);
			return;
		}
		Point now = cctvPoint.get(order);
		int cctvNum = map[now.x][now.y];
		int[][] myMap = cloneMap(map);
		int nowzerosize = zerosize;
		for(int i = 0 ; i<cctv[cctvNum].size() ; i++) {
			int a [] = cctv[cctvNum].get(i);
			for(int j = 0 ; j < a.length ; j++) {
				spread(a[j],now);
			}
			dfs(order+1);
			zerosize = nowzerosize;
			map = cloneMap(myMap);
		}
		
		
		
	}
	static int dr[] = {0,0,-1,0,1};
	static int dc[] = {0,-1,0,1,0};
	static void spread(int dir,Point p) {
		int row = p.x;
		int col = p.y;
		while(true) {
			row = row+dr[dir];
			col = col+dc[dir];
			if(row<0 || col < 0 || row>= N || col >= M)
				break;
			if(map[row][col] == 6)
				break;
			if(map[row][col]>0)
				continue;
			if(map[row][col] == -1)
				continue;
			zerosize--;
			map[row][col] = -1;
		}
	}
	static int[][] cloneMap(int [][] a){
		int [][] b = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j< M ; j++) {
				b[i][j] = a[i][j];
			}
		}
		return b;
	}

}
