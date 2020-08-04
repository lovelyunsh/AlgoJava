package D4;

import java.util.Scanner;

public class P3289서로소집합 {
	static int parent[];
	static int rank[];
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py)
			return;
		if(rank[px] > rank[py])
			parent[py] = px;
		else if(rank[px] < rank[py])
			parent[px] = py;
		else {
			parent[px] = py;
			rank[py]++;
		}
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		parent[x] = find(parent[x]);
		return find(parent[x]);
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt()+1;
			int M = sc.nextInt();
			parent = new int[N];
			rank = new int[N];
			for(int i = 0 ; i < N ; i++) {
				parent[i] = i;
			}
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < M; i++) {
				int C = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				switch (C) {
				case 0:
					union(a,b);
					break;
				case 1:
					result.append(find(a) == find(b) ? 1 : 0);
					break;
				}
				
			}

			System.out.printf("#%d "+result +"\n", tc);
		}
	}

}
