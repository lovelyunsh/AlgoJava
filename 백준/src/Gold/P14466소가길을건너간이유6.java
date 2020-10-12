package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14466소가길을건너간이유6 {

	static int map[][],N,K,R;
	static HashMap<String, List<Point>> roadmap = new HashMap<String, List<Point>>();
	static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//맵크기
		K = Integer.parseInt(st.nextToken());//소 개수
		R = Integer.parseInt(st.nextToken());//길 개수
		map = new int[N][N];
		visit = new boolean[N][N];
		List<Integer> cownum = new ArrayList<Integer>();
		//소는 -1
		//길은 -2~
		//맵은 0
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(st.nextToken())-1;
			int col1 = Integer.parseInt(st.nextToken())-1;
			int row2 = Integer.parseInt(st.nextToken())-1;
			int col2 = Integer.parseInt(st.nextToken())-1;
			if(roadmap.get(row1+""+col1) == null)
				roadmap.put(row1+""+col1,new ArrayList<Point>()); 
			if(roadmap.get(row2+""+col2) == null)
				roadmap.put(row2+""+col2,new ArrayList<Point>()); 
			roadmap.get(row1+""+col1).add(new Point(row2,col2));
			roadmap.get(row2+""+col2).add(new Point(row1,col1));
		}
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int col = Integer.parseInt(st.nextToken())-1;
			map[row][col] = -1;
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(visit[i][j])
					continue;
				cownum.add(bfs(i,j));
			}
		}
		int result = 0;
		for(int i = 0 ; i < cownum.size()-1 ; i++) {
			for(int j = i+1 ; j <cownum.size() ; j++ ) {
				result += cownum.get(i) * cownum.get(j);
			}
		}
		
		System.out.println(result);
		
	}
	
	static int bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		int dr[] = {1,-1,0,0};
		int dc[] = {0,0,1,-1};
		que.offer(new Point(x,y));
		visit[x][y] = true;
		int cow = 0;
		if(map[x][y] == -1)
			cow++;
		while(!que.isEmpty()) {
			Point now = que.poll();
			gg:for(int i = 0 ; i < 4 ; i++) {
				int row = now.x+ dr[i];
				int col = now.y + dc[i];
				if(row<0|| col<0 ||row>=N || col >= N )
					continue;
				if(visit[row][col])
					continue;
				if(roadmap.get(now.x+""+now.y) != null) {
					for(Point k : roadmap.get(now.x+""+now.y) ) {
						if(k.x == row && k.y == col)
							continue gg;
					}
				}
				if(map[row][col] == -1)
					cow++;
				visit[row][col] = true;
				que.offer(new Point(row,col));
			}
		}
		return cow;
	}
}
