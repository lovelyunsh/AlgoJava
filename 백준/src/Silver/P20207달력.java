package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P20207달력 {

	static class block implements Comparable<block> {
		int S;
		int E;

		public block(int s, int e) {
			S = s;
			E = e;
		}

		@Override
		public int compareTo(block o) {
			if (this.S == o.S)
				return o.E - this.E;
			return this.S - o.S;
		}

	}

	static int map[][] = new int[1001][367];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<block> pq = new PriorityQueue<block>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			pq.add(new block(S, E));
		}
		int sum = 0;
		int max[] = new int[366];
		while (!pq.isEmpty()) {
			block now = pq.poll();
			int row = findloc(now);
			for(int i = now.S; i <= now.E; i++) {
				map[row][i] = 1;
				max[i] = Math.max(row, max[i]);
			}
		}
		int maxH = 0;
		int len = 0;
		for(int i = 0 ; i < 366 ; i++) {
			if(max[i] == 0) {
				sum += maxH * len;
				maxH = 0;
				len = 0;
			}else {
				maxH = Math.max(max[i], maxH);
				len++;
			}
		}
		sum += maxH * len;
		System.out.println(sum);
	}

	static int findloc(block now) {
		for (int i = 1; i <= 1000; i++) {
			if (map[i][now.S] == 1)
				continue;
			return i;
		}
		return -1;
	}

}
