package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P19542전단지돌리기 {

	static boolean visited[];
	static ArrayList<Integer> list[];
	static int parents[];
	static boolean leaf[];
	static int cnt;
	static int unvisit;
	static void set(int x) {
		parents[x] = x;
	}
	static void union(int x , int y) {
		parents[y] = x;
	}
	static int find(int x) {	
		if(parents[x] == x)
			return cnt;
		if(visited[x]) {
			return cnt-1;
		}
		cnt++;
		if(unvisit < cnt)
			visited[x] = true;
		return find(parents[x]);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		ArrayList<Point> node = new ArrayList<Point>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			node.add(new Point(x, y));
		}
		list = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();

		visited = new boolean[N + 1];
		leaf = new boolean[N + 1];
		Arrays.fill(leaf, true);
		for (Point p : node) {
			list[p.x].add(p.y);
			list[p.y].add(p.x);
		}
		
		parents = new int [N+1];
		for(int i = 1 ; i <= N ; i++) 
			parents[i] = i;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(S);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i = 0 ; i < list[now].size() ; i++) {
				if(parents[now] != list[now].get(i)) {
					leaf[now] = false; 
					que.add(list[now].get(i));
					union(now, list[now].get(i));
				}
			}
		}
		unvisit = D;
		int result = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(leaf[i]) {
				cnt = 0 ;
				find(i);
				if(cnt-D > 0)
					result+= (cnt-D)*2;
			}
		}
		
		System.out.println(result);

	}

}
