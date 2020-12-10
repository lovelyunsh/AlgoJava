package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_16235나무재테크 {
	static class tree implements Comparable<tree> {
		int age;
		int row;
		int col;

		public tree(int age, int row, int col) {
			this.age = age;
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}

	}

	static int N, M, K, A[][], food[][];
	static PriorityQueue<tree> treeQue;
	static PriorityQueue<tree> deathQue = new PriorityQueue<tree>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 크기
		M = Integer.parseInt(st.nextToken()); // 나무 갯수
		K = Integer.parseInt(st.nextToken()); // k년후 나무 갯수

		A = new int[N][N];

		food = new int[N][N];

		for (int i = 0; i < N; i++)
			Arrays.fill(food[i], 5);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		treeQue = new PriorityQueue<tree>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			treeQue.add(new tree(z, x, y));
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		System.out.println(treeQue.size());

	}

	static void spring() {
		PriorityQueue<tree> temp = new PriorityQueue<tree>();
		
		while (!treeQue.isEmpty()) {
			tree now = treeQue.poll();
			if (now.age > food[now.row][now.col]) {
				deathQue.offer(now);
				continue;
			}
			food[now.row][now.col] -= now.age;
			temp.offer(new tree(now.age + 1, now.row, now.col));
		}
		treeQue = temp;
	}

	static void summer() {
		while (!deathQue.isEmpty()) {
			tree now = deathQue.poll();
			food[now.row][now.col] += now.age / 2;
		}
	}

	static void fall() {
		int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		PriorityQueue<tree> temp = new PriorityQueue<tree>();

		while (!treeQue.isEmpty()) {
			tree now = treeQue.poll();
			temp.offer(now);
			if (now.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int row = now.row + dr[i];
					int col = now.col + dc[i];
					if (row < 0 || col < 0 || row >= N || col >= N)
						continue;
					temp.offer(new tree(1, row, col));
				}
			}

		}
		treeQue = temp;
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				food[i][j] += A[i][j];
			}

		}
	}
}
