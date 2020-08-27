package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260DFS와BFS {
	static ArrayList<Integer> list [];
	static boolean visit [];
	static int N,M,V;
	
	static void bfs(int first) {
		Queue<Integer> que = new LinkedList();
		que.offer(first);
		visit[first] = true;
		while(!que.isEmpty()) {
			int now = que.poll();
			System.out.print(now+" ");
			for(int i : list[now]) {
				if(!visit[i]) {
					visit[i] = true;
					que.add(i);
				}
			}
			
		}
	}
	static void dfs(int now) {
		System.out.print(now+" ");
		for(int i : list[now]) {
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(i);
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i = 1 ; i < N+1 ; i++) list[i] = new ArrayList<Integer>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		for(int i = 1 ; i < N+1 ; i++) Collections.sort(list[i]);
		visit = new boolean[N+1];
		visit[V] = true;
		dfs(V);
		System.out.println();
		visit = new boolean[N+1];
		visit[V] = true;
		bfs(V);
		
	}

}
