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
		boolean asdf [] = new boolean[100001];
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<find> abc = new LinkedList<find>();
		abc.add(new find(N, 0));
		int result = 0;
		while(!abc.isEmpty()) {
			find a = abc.poll();
			if(a.now == K) {
				result = a.cnt;
				break;
			}
			if(a.now + 1 > K) {
				abc.offer(new find(a.now-1, a.cnt+1));
			}
			else {
				abc.offer(new find(a.now*2, a.cnt+1));
				abc.offer(new find(a.now+1, a.cnt+1));
				if(!asdf[a.now-1]) {
					abc.offer(new find(a.now-1, a.cnt+1));
					asdf[a.now-1] = true;
				}
				if(!asdf[a.now+1]) {
					abc.offer(new find(a.now-1, a.cnt+1));
					asdf[a.now+1] = true;
				}
				if(a.now*2 < 100000 && !asdf[a.now*2]) {
					abc.offer(new find(a.now-1, a.cnt+1));
					asdf[a.now*2] = true;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
