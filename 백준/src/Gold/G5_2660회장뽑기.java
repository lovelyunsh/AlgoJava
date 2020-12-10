package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_2660회장뽑기 {
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inf = 987654321;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr [] = new ArrayList [N+1];
		
		for(int i = 0 ; i < N+1 ; i++) 
			arr[i] = new ArrayList<Integer>();
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			if(to == -1 && from == -1)
				break;
			arr[to].add(from);
			arr[from].add(to);
		}
		
		int min = 123456789;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 1 ; i < N+1 ; i++) {
			boolean visit[] = new boolean[N+1];
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(i);
			visit[i] = true;
			int size = 0;
			int dist = -1;
			while(!que.isEmpty()) {
				if(size == 0) {
					size = que.size();
					dist++;
				}
				int now = que.poll();
				size--;
				for(int j : arr[now]) {
					if(visit[j])
						continue;
					visit[j] = true;
					que.offer(j);
				}
			}
			if(dist == min) {
				result.add(i);
			}
			if(dist < min) {
				result.clear();
				result.add(i);
				min = dist;
			}
			
		}
		
		System.out.println(min+ " " + result.size());
		for(int i : result) {
			System.out.print(i +" ");
		}
		
		
		
	}

}
