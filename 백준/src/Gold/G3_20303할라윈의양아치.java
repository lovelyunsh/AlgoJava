package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_20303할라윈의양아치 {
	static class group{
		int candy;
		int head;
		public group(int candy, int head) {
			this.candy = candy;
			this.head = head;
		}
		
	}
	static int candies[];
	static ArrayList<group> groups = new ArrayList<group>();
	static ArrayList<Integer> relation[];
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //아이 수
		int M = Integer.parseInt(st.nextToken()); //관계 수
		int K = Integer.parseInt(st.nextToken()); //뺏는 수
		relation = new ArrayList[N];
		visit = new boolean[N];
		for(int i = 0 ; i < N ; i++)
			relation[i] = new ArrayList<Integer>();
		candies = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			candies[i] = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken())-1;
			int from = Integer.parseInt(st.nextToken())-1;
			relation[to].add(from);
			relation[from].add(to);
		}
		for(int i = 0 ; i < N ; i++) { //group 만들기
			if(visit[i])
				continue;
			bfs(i);
		}
		int dp[][] = new int[2][K];
		for(int i = 0 ; i < groups.size() ; i++) {
			group now = groups.get(i);
			int head = now.head;
			int candy = now.candy;
			for(int j = 0 ; j < K ; j++) {
				if(j>=head && dp[0][j-head]+candy > dp[0][j])
					dp[1][j] =dp[0][j-head]+candy;
				else
					dp[1][j] = dp[0][j];
			}
			dp[0] = dp[1].clone();
		}
		System.out.println(dp[1][K-1]);
	}
	
	static void bfs(int start) {
		visit[start] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(start);
		int head = 1,candy = candies[start];
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : relation[now]) {
				if(visit[i])
					continue;
				visit[i] = true;
				que.offer(i);
				head++;
				candy += candies[i];
			}
		}
		groups.add(new group(candy,head));
	}

}
