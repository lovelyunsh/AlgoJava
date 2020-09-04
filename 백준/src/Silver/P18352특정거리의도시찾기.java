package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352특정거리의도시찾기 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //거리정보
		int X = Integer.parseInt(st.nextToken()); //출발점
		
		ArrayList<Integer> [] list = new ArrayList [N+1] ;
		for(int i = 0 ; i < N+1 ; i++) list[i] = new ArrayList<Integer>();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list[to].add(from);
		}
		
		
		boolean [] visit = new boolean [N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		visit[X] = true;
		que.offer(X);
		que.offer(-1);
		int dist = 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(true) {
			int now = que.poll();
			if(now == -1) {
				dist++;
				if(dist>K)
					break;
				if(que.isEmpty())
					break;
				que.offer(-1);
				continue;
			}
			
			for(int i : list[now]) {
				if(visit[i])
					continue;
				if(dist == K)
					result.add(i);
				que.offer(i);
				visit[i] = true;
			}
		}
		
		if(result.isEmpty()) {
			System.out.println(-1);
			System.exit(0);
		}
		Collections.sort(result);
		for(int i : result)
			System.out.println(i);
	}

}
