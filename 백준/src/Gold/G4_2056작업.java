package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_2056작업 {
	
	static int [] parentcnt,time;
	
	static int N;
	static ArrayList<ArrayList<Integer>> nodearr = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<Integer>();
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		parentcnt = new int[N];
		for(int i = 0 ; i < N ; i++)
			nodearr.add(new ArrayList<>());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			time[i] = n;
			n = Integer.parseInt(st.nextToken());
			if(n == 0)
				que.offer(i);
			for(int j = 0 ; j < n ; j++) {
				int ch = Integer.parseInt(st.nextToken())-1;
				nodearr.get(ch).add(i);
				parentcnt[i]++;
			}
		}
		bfs();
		System.out.println(ans);
		
	}
	static void bfs() {
		
		while(!que.isEmpty()) {
			for(int s = que.size() ; s> 0 ; s--) {
				int now = que.poll();
				time[now]--;
				if(time[now] != 0) {
					que.offer(now);
					continue;
				}
				
				for(int i : nodearr.get(now)) {
					parentcnt[i]--;
					if(parentcnt[i] == 0)
						que.offer(i);
				}
			}
			ans++;
		}
	}

}
