package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2814최장경로 {
	
	static ArrayList<Integer> [] nodes;
	static boolean visit[];
	static int max;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			nodes = new ArrayList[N+1];
			visit = new boolean[N+1];
			max = 0;
			for(int i = 1 ; i <= N ; i++)
				nodes[i] = new ArrayList<Integer>();
			
			for(int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				nodes[to].add(from);
				nodes[from].add(to);
			}
			
			for(int i = 1 ; i<=N ; i++ ) {
				visit[i] = true;
				dfs(i,1);
				visit[i] = false;
			}
			
			
			System.out.printf("#%d %d\n", tc,max);
		}
		
	}
	
	static void dfs(int num, int size) {
		boolean isgo = false;
		for(int i = 0 ; i < nodes[num].size() ; i++) {
			int now = nodes[num].get(i);
			if(visit[now])
				continue;
			isgo = true;
			visit[now] = true;
			dfs(now,size+1);
			visit[now] = false;
		}
		if(!isgo) {
			max = Math.max(size,max);
		}
	}


}
