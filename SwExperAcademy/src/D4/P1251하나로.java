package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1251하나로 {
	static class node implements Comparable<node> {
		int idx;
		long cost;

		public node(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}

	}

	public static int N, ans;
	public static double E;
	public static long matrix[][];
	public static List<Integer> X;
	public static List<Integer> Y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = new ArrayList<>();
			Y = new ArrayList<>();
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X.add(Integer.parseInt(stX.nextToken()));
				Y.add(Integer.parseInt(stY.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());
			matrix = new long[N][N];
			for (int r = 0; r < N; r++) {
				long x1 = X.get(r);
				long y1 = Y.get(r);
				for (int c = r + 1; c < N; c++) {
					long x2 = X.get(c);
					long y2 = Y.get(c);
					matrix[c][r] = matrix[r][c] = (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				}
			}

			double cost = Prim() * E;
			System.out.println("#" + tc + " " + Math.round(cost));
		}
	}

	private static double Prim() {
		PriorityQueue<node> pq = new PriorityQueue<>(); 

		node[] linkedgraph = new node[N];
		for (int n = 0; n < linkedgraph.length; n++) {
			linkedgraph[n] = new node(n, Long.MAX_VALUE);
			if (n == 0) {
				linkedgraph[0].cost = 0;
			}
			pq.add(linkedgraph[n]);
		}
		long cost = 0;
		while (!pq.isEmpty()) {
			node parents = pq.poll();
			cost += parents.cost;
			for (int i = 0; i < linkedgraph.length; i++) {
				node child = linkedgraph[i];
				if (pq.contains(child)) {
					long nowCost = matrix[parents.idx][child.idx];
					if (nowCost < child.cost) {
						child.cost = nowCost;
						pq.remove(child);
						pq.add(child);
					}
				}
			}
		}
		return cost;
	}
}
