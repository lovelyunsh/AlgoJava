package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_16988Baaaaaaaaaduk2 {
	static int N,M;
	static int map[][];
	static boolean visit[][];
	static boolean zerovisit[][];
	static List<Integer> candiarr;
	static HashSet<Integer> candiset = new HashSet<>();
	static int ans = 0;
	public static void main(String[	] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N ; i++) { //findcandi
			for(int j = 0 ; j < M ; j++) 
				if(map[i][j] == 2 && !visit[i][j]) 
					findcandi(i, j);
		}
		candiarr = new ArrayList<>(candiset);
		if(candiarr.size() == 1) 
			ans = finddead();
		
		
		comb(0, 0);
		System.out.println(ans);
	}
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1}; 
	static void findcandi(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(x,y));
		
		visit[x][y] = true;
		zerovisit = new boolean [N][M];
		ArrayList<Integer> arr = new ArrayList<>();
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if(row < 0 || col <0 || row>= N || col >= M || map[row][col] == 1)
					continue;
				if(map[row][col] == 0) {
					if(zerovisit[row][col])
						continue;
					zerovisit[row][col] = true;
					if(arr.size() == 2)
						return;
					else
						arr.add(row*100+col);
					continue;
				}
				if(visit[row][col])
					continue;
				visit[row][col] = true;
				que.add(new Point(row,col));
			}
		}
		candiset.addAll(arr);
	}
	static int [] sel = new int[2];
	static void comb(int num, int selcnt) {
		if(selcnt == 2) {
			ans = Math.max(ans, finddead());
			return;
		}
		if(num == candiarr.size())
			return;
		
		sel[selcnt] = num;
		comb(num+1,selcnt+1);
		comb(num+1,selcnt);
	}
	static int finddead() {
		visit = new boolean [N][M];
		int zero1 = candiarr.get(sel[0]);
		int zero2 = candiarr.get(sel[1]);
		int cnt = 0;
		map[zero1/100][zero1%100] = 1;
		map[zero2/100][zero2%100] = 1;
		for(int s = 0 ; s < 2 ; s++) {
			int zero = candiarr.get(sel[s]);
			for(int i = 0 ; i < 4 ; i++) {
				int row = zero/100 + dr[i];
				int col = zero%100 + dc[i];
				if(row < 0 || col <0 || row>= N || col >= M || visit[row][col])
					continue;
				if(map[row][col] == 2) 
					cnt += bfs(row,col);
			}
		}
		map[zero1/100][zero1%100] = 0;
		map[zero2/100][zero2%100] = 0;
		return cnt;
	}
	static int bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(x,y));
		visit[x][y] = true;
		int cnt = 0;
		boolean isdead = true;
		while(!que.isEmpty()) {
			Point now = que.poll();
			cnt++;
			for(int i = 0 ; i < 4 ; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if(row < 0 || col <0 || row>= N || col >= M || map[row][col] == 1)
					continue;
				if(visit[row][col])
					continue;
				if(map[row][col] == 0) {
					isdead = false;
					continue;
				}
				visit[row][col] = true;
				que.add(new Point(row,col));
			}
		}
		if(!isdead)
			return 0;
		else
			return cnt;
	}
}
