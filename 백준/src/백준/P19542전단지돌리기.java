package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P19542전단지돌리기 {

	static boolean visited[];
	static ArrayList<Integer> list[];
	static int cnt, D, parents[];

	static int find(int x) {
		if (parents[x] == x)
			return cnt;
		if (visited[x]) {
			return cnt - 1;
		}
		cnt++;
		if (D < cnt)
			visited[x] = true;
		return find(parents[x]);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		visited = new boolean[N + 1];
		ArrayList<Integer> leaflist = new ArrayList<Integer>();
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(S);
		while (!que.isEmpty()) {
			int now = que.poll();
			boolean isleaf = true;
			for (int i = 0; i < list[now].size(); i++) {
				if (parents[now] != list[now].get(i)) {
					isleaf = false;
					que.add(list[now].get(i));
					parents[list[now].get(i)] = now;
				}
			}
			if (isleaf)
				leaflist.add(now);
		}
		int result = 0;
		for (int leaf : leaflist) {
			cnt = 0;
			find(leaf);
			if (cnt - D > 0)
				result += (cnt - D) * 2;
		}
		System.out.println(result);
	}
}
