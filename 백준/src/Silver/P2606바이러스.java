package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606바이러스 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		ArrayList<Integer> list [] = new ArrayList[N+1];
		boolean visit [] = new boolean[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ; i < P ; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		Queue<Integer> que = new LinkedList();
		que.offer(1);
		visit[1] = true;
		int cnt = 0;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : list[now]) {
				if(!visit[i]) {
					visit[i] = true;
					que.add(i);
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
		
	}

}
