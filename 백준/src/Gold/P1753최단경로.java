package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1753최단경로 {
	static class Edge {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()) - 1;
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Edge>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())-1]
					.add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
		}
		// dist배열 준비
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);// 무한대로 넣어주자
		boolean[] check = new boolean[V];
		dist[K] = 0; // 시작 0으로

		for (int i = 0; i < V; i++) {
			// dist값이 젤 작은 정점의 번호를 찾으시오.
			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for (int j = 0; j < V; j++) {
				if(check[j])
					continue;
				if (min > dist[j]) {
					min = dist[j];
					minidx = j;
				}
			}
			if( minidx == -1)
				break;
			// 찾은 정점으로부터 갈 수 있는 경로가 이미 알고 있는 dist보다 작다면 갱신
			for(int j = 0 ; j < adj[minidx].size() ; j++) {
				int nextIdx = adj[minidx].get(j).v;
				int nextWeight = adj[minidx].get(j).weight;
				if(dist[minidx]+ nextWeight < dist[nextIdx]) {
					dist[nextIdx] =dist[minidx]+ nextWeight; 
				}
			}
			check[minidx] = true;
		}
		
		for(int i = 0 ; i < V ; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	}

}
