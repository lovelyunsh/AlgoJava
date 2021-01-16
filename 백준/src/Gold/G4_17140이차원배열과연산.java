package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_17140이차원배열과연산 {
	static int r, c, k;
	static int rlen = 3, clen = 3;
	static int map[][] = new int[100][100];
	static int cntarr[] = new int[101];
	static class Point implements Comparable<Point> {
		int key;
		int value;
		
		public Point(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			if(this.value == o.value) {
				return this.key - o.key;
			}	
			return this.value - o.value;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cycle = 0;
		boolean flag = false;
		while (cycle++ <= 100) {
			if(map[r][c] == k) {
				flag = true;
				break;
			}
			if (rlen >= clen)
				R();
			else
				C();
		}
		System.out.println(flag?cycle-1 : -1);
	}

	static void R() {
		int maxidx = 0;
		for (int i = 0; i < rlen; i++) {
			HashSet<Integer> set = new HashSet<>();
			PriorityQueue<Point> pq = new PriorityQueue<>();
			cntarr = new int[101];
			for (int j = 0; j < clen; j++) {
				if(map[i][j] == 0)
					continue;
				cntarr[map[i][j]]++;
				set.add(map[i][j]);
				map[i][j] = 0;
			}
			
			for(int k : set)
				pq.add(new Point(k,cntarr[k]));
			int idx = 0;
			while(!pq.isEmpty() && idx < 100) {
				Point now = pq.poll();
				map[i][idx] = now.key;
				if(idx+1 >= 100)
					break;
				map[i][idx+1] = now.value;
				idx +=2;
				
			}
			maxidx = Math.max(maxidx, idx);
		}
		clen = maxidx;
	}

	static void C() {
		int maxidx = 0;
		for (int j = 0; j < clen; j++) {
			HashSet<Integer> set = new HashSet<>();
			PriorityQueue<Point> pq = new PriorityQueue<>();
			cntarr = new int[101];
			for (int i = 0; i < rlen; i++) {
				if(map[i][j] == 0)
					continue;
				cntarr[map[i][j]]++;
				set.add(map[i][j]);
				map[i][j] = 0;
			}
			
			for(int k : set)
				pq.add(new Point(k,cntarr[k]));
			int idx = 0;
			while(!pq.isEmpty()  && idx < 100) {
				Point now = pq.poll();
				map[idx][j] = now.key;
				if(idx+1 >= 100)
					break;
				map[idx+1][j] = now.value;
				idx +=2;
			}
			maxidx = Math.max(maxidx, idx);
		}
		rlen = maxidx;

	}

}
