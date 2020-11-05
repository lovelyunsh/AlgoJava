package D4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5644무선충전 {

	static List<Integer> map[][];
	static int bcinfo[];
	static int moveA[], moveB[], M;
	static Point A, B;
	static int score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // time
			int Ap = Integer.parseInt(st.nextToken()); // Ap cnt
			map = new List[10][10];
			bcinfo = new int[Ap + 1];
			score = 0;
			moveA = new int[M];
			moveB = new int[M];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st1.nextToken()) - 1;
				moveB[i] = Integer.parseInt(st2.nextToken()) - 1;
			}
			for (int i = 1; i <= Ap; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcinfo[i] = p;
				spread(x, y, c, i);
			}
			A = new Point(0, 0);
			B = new Point(9, 9);
			go();
			System.out.println("#" + tc + " " + score);
		}

	}

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	static void go() { // 점수 올리고 이동하고
		for (int i = 0; i <= M; i++) {
			List<Integer> Anum = map[A.x][A.y];
			List<Integer> Bnum = map[B.x][B.y];
			int sumA = findMax(Anum, -1);
			int sumB = findMax(Bnum, -1);
			if (sumA != 0 && sumA == sumB) {
				if (Anum.size() > 1 && Bnum.size() > 1) {
					int a = findMax(Anum, sumA);
					int b = findMax(Bnum, sumB);
					if (bcinfo[a] > bcinfo[b])
						sumA = a;
					else
						sumB = b;
				} else if (Anum.size() > 1) {
					sumA = findMax(Anum, sumA);
				} else if (Bnum.size() > 1) {
					sumB = findMax(Bnum, sumB);
				} else {
					sumA = sumA;
					sumB = 0;
				}
			}
			score += bcinfo[sumA];
			score += bcinfo[sumB];
			if (i == M)
				break;
			if (moveA[i] != -1) {
				A = new Point(A.x + dr[moveA[i]], A.y + dc[moveA[i]]);
			}
			if (moveB[i] != -1) {
				B = new Point(B.x + dr[moveB[i]], B.y + dc[moveB[i]]);
			}
		}
	}

	static int findMax(List<Integer> nums, int ex) {
		int max = 0;
		if (nums != null) {
			for (int i : nums) {
				if (i != ex && bcinfo[max] < bcinfo[i])
					max = i;
			}
		}
		return max;
	}

	static void spread(int x, int y, int c, int num) { // 맵 만들기
		Queue<Point> que = new LinkedList<Point>();
		boolean visited[][] = new boolean[10][10];
		visited[x][y] = true;
		que.offer(new Point(x, y));
		int dist = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point now = que.poll();
				if (map[now.x][now.y] == null) {
					map[now.x][now.y] = new ArrayList<Integer>();
				}
				map[now.x][now.y].add(num);

				for (int d = 0; d < 4; d++) {
					int row = now.x + dr[d];
					int col = now.y + dc[d];
					if (row < 0 || col < 0 || row >= 10 || col >= 10)
						continue;
					if (visited[row][col])
						continue;
					visited[row][col] = true;
					que.offer(new Point(row, col));
				}
			}
			if (dist == c) {
				break;
			}
			dist++;
		}
	}

}
