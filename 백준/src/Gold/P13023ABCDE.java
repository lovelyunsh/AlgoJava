package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13023ABCDE {
	static List<Integer> arr[];
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		arr = new ArrayList [N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = new ArrayList<Integer>();
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			arr[to].add(from);
			arr[from].add(to);
		}
		for(int i = 0 ; i < N ; i++) {
			visit[i] = true;
			dfs(i,1);
			visit[i] = false;
		}
		System.out.println(0);
	}
	
	static void dfs(int num, int cnt) {
		if(cnt == 5) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i : arr[num]) {
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(i,cnt+1);
			visit[i] = false;
		}
		
	}

}
