package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class tree implements Comparable<tree> {
	int A;
	int B;
	int weight;

	public tree(int a, int b, int weight) {
		super();
		A = a;
		B = b;
		this.weight = weight;
	}

	@Override
	public int compareTo(tree o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class P3124최소스패닝트리 {
	static int parents[] = new int[100001];
	static int find(int x) {
		if (x == parents[x])
			return x;
		parents[x] = find(parents[x]);
		return find(parents[x]);
	}
	
	static boolean union(int x,int y) {
		int px = find(x);
		int py = find(y);
		if(px == py)
			return false;
		parents[py] = px;
		return true;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());

			parents = new int[V + 1];
			for (int i = 1; i <= V; i++)
				parents[i] = i;

			int E = Integer.parseInt(st.nextToken());
			tree treeA [] = new tree[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				treeA[i] = new tree(a, b, c);
			}
			Arrays.sort(treeA);
			int cnt = 0;
			long sumweight = 0;
			for(int i = 0 ; cnt < V-1 ; i++) {
				tree ntree = treeA[i];
				if(union(ntree.A, ntree.B)){
					cnt++;
					sumweight += ntree.weight;
				}
			}
			

			System.out.println("#"+tc+" "+sumweight);
		}
	}

}
