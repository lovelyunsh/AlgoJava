package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class find {
	int now;
	int cnt;
	public find(int now, int cnt) {
		super();
		this.now = now;
		this.cnt = cnt;
	}
	
}
public class P1697숨바꼭질 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean check [] = new boolean[1000000];
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<find> que = new LinkedList<find>();
		que.add(new find(N, 0));
		int result = 0;
		while(!que.isEmpty()) {
			find a = que.poll();
			check[N] = true;
			if(a.now == K) {
				result = a.cnt;
				break;
			}
			
			if(a.now + 1 > K) {
				que.offer(new find(a.now-1, a.cnt+1));
			}
			else if(a.now == 0) {
				que.offer(new find(a.now+1, a.cnt+1));
			}
			else {
				que.offer(new find(a.now*2, a.cnt+1));
				que.offer(new find(a.now+1, a.cnt+1));
				if(!check[a.now-1]) {
					que.offer(new find(a.now-1, a.cnt+1));
				}
				if(a.now+1 < 1000000 &&!check[a.now+1]) {
					que.offer(new find(a.now-1, a.cnt+1));
				}
				if(a.now*2 < 1000000 && !check[a.now*2]) {
					que.offer(new find(a.now-1, a.cnt+1));
				}
			}
		}
		
		System.out.println(result);
		
	}

}
