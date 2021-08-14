package Platinum;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13907세금 {
	//bfs 돌면서 
	//최소값 이었던 얘랑 같은 값이 나오면
	static int cost[][];
	static ArrayList<Point> relation [];
	static class node implements Comparable<node>{
		int num;
		int cnt;
		int cost;
		public node(int num, int cnt, int cost) {
			this.num = num;
			this.cnt = cnt;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		cost = new int[1000][1000];
		for(int i = 0 ; i < N+1 ; i++)
			Arrays.fill(cost[i], 987654321);
		relation = new ArrayList[N+1];
		for(int i = 0; i < N+1 ; i++) relation[i] = new ArrayList<Point>();
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			relation[a].add(new Point(b,w));
			relation[b].add(new Point(a,w));
		}
		dij(S);
		System.out.println(1);
		
	}
	static void dij(int S) {
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.add(new node(S, 0, 0));
		while(!pq.isEmpty()) {
			node now = pq.poll();
			if(cost[now.num][now.cnt] < now.cost)
				continue;
			for(Point p :relation[now.num]) {
				int pCost = cost[p.x][now.cnt+1];
				if(pCost > now.cost+p.y) {
					pq.add(new node(p.x, now.cnt+1, now.cost+p.y));
					cost[p.x][now.cnt+1] = now.cost+p.y;
				}
				
			}
		}
	}

}
