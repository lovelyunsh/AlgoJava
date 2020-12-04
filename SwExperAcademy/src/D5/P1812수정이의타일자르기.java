package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1812수정이의타일자르기 {
	static PriorityQueue<Integer> tiles;
	static PriorityQueue<shape> newtiles;
	static int cnt, N, M;

	static class shape implements Comparable<shape> {
		int x;
		int y;

		public shape(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(shape o) {
			return o.x - this.x;
		}

	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tiles = new PriorityQueue<Integer>(Collections.reverseOrder());
			newtiles = new PriorityQueue<shape>();
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				tiles.add(Integer.parseInt(st.nextToken()));
			make_tile();
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	static void make_tile() {
		if (tiles.isEmpty()) {
			return;
		}
		if (newtiles.isEmpty()) {
			newtiles.offer(new shape(M, M));
			cnt++;
		}
		int tile = (int) Math.pow(2, tiles.poll()); // 지금 만들 타일
		if (newtiles.peek().x < tile) {
			cnt++;
			newtiles.offer(new shape(M, M));
		}
		shape newtile = newtiles.poll();

		if (newtile.x < newtile.y - tile)
			newtiles.offer(new shape(newtile.x, newtile.y - tile));
		else
			newtiles.offer(new shape(newtile.y - tile, newtile.x));

		if (newtile.x - tile < tile)
			newtiles.offer(new shape(newtile.x - tile, tile));
		else
			newtiles.offer(new shape(tile, newtile.x - tile));
		make_tile();
	}
}
