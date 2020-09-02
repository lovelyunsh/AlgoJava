package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2933미네랄 {
	static char map[][];
	static int R, C;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static boolean[][] visit;
	static Queue<Point> que = new LinkedList<Point>(); // 검사용
	static PriorityQueue<Point> pQue = new PriorityQueue<Point>(); // 떨구기용

	static class Point implements Comparable<Point> {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Point o) {
			return o.row - this.row; // 아랫줄 부터 ( row가 큰거부터)
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int height[] = new int[N];
		for (int i = 0; i < N; i++)
			height[i] = Integer.parseInt(st.nextToken());

		// 부순다.
		// 상하좌우에 미네랄있으면 거기부터 bfs시작 visit처리 해주면서
		// 상 문제 없으면 좌 문제 없으면 우 다 검사하고 검사한것 중에 바닥 없으면 떨어뜨리게 클러스터 묶기
		// 클론한 맵에 맨밑줄부터 한칸씩 떨구기 우선순위큐로 한칸씩 떨궈
		// 내려갈라는데 바닥이나 다른 미네랄이면 종료
		boolean L = true;
		for (int i = 0; i < N; i++) { // 모든 던지기에 대해
			
			for (int j = 0; j < N; j++)
				System.out.println();
			
			for (int ki = 0; ki < R-8; ki++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[ki][j]);
				}
				if(ki == R- height[i]) {
					System.out.print("<- ");
					System.out.print(L? "L":"R");
				}
				
				System.out.println();
			}
			Thread.sleep(3000);

			
			
			
			
			
			Point hitPoint = hit(height[i], L); // 일단 때려보고
			if (hitPoint == null) { // 안맞았으면 아무일도 안일어나기
				L = !L;
				continue;
			}

			visit = new boolean[R][C];

			for (int j = 0; j < 4; j++) {
				int row = hitPoint.row + dr[j]; // 맞은 위치 4방에 대해
				int col = hitPoint.col + dc[j];
				if (row < 0 || col < 0 || row >= R || col >= C)// 맵넘기지 말고
					continue;
				if (map[row][col] != 'x') // x가 아닌곳은 필요없고
					continue;
				if (visit[row][col]) // 이미 방문되어졌으면 필요없고
					continue;
				if (check(new Point(row, col)))// 바닥에 닿는지 쭉 검사해보자 연결된 클러스터는 다 visit되었겠지
					continue; // 바닥에 잘 닿으면 떨굴일 없으니 넘기고

				// 위를 다 지나왔으면 떨굴일이 생긴것
				while (true) // 끝에 다다를때까지 떨궈
					if (!drop())
						break;
				// 떨굴일 한번뿐이랬으니
				break;

			}
			L = !L; // 반대편 얘가 던지기
		}
		// 던지기 다 끝났으면 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static Point hit(int height, boolean L) {
		int row = R - height;
		if (L) {
			for (int i = 0; i < C; i++) {
				if (map[row][i] == 'x') {
					map[row][i] = '.';
					return new Point(row, i);
				}
			}
		}

		else
			for (int i = C - 1; i >= 0; i--)
				if (map[row][i] == 'x') {
					map[row][i] = '.';
					return new Point(row, i);
				}
		return null;
	}

	static boolean check(Point np) {
		boolean flag = false;
		que.offer(np);
		pQue.offer(np); // 나중에 떨굴일 생기면 쓰게 미리 넣어두기
		visit[np.row][np.col] = true;
		while (!que.isEmpty()) {
			Point now = que.poll();
			for (int i = 0; i < 4; i++) {
				int row = now.row + dr[i];
				int col = now.col + dc[i];

				if (row < 0 || col < 0 || row >= R || col >= C)
					continue;
				if (visit[row][col])
					continue;
				if (map[row][col] != 'x')
					continue;
				if (row == R - 1) {// 바닥에 닿네?
					flag = true;
				}

				visit[row][col] = true;
				que.offer(new Point(row, col));
				pQue.offer(new Point(row, col));
			}

		}
		if (flag) {// 바닥에 닿았으니
			pQue.clear(); // 떨어뜨릴거 없어 필요없어
			return true;
		}
		return false; // 다 돌았는데 바닥에 안닿았으니 떨궈야지

	}

	static boolean drop() {
		PriorityQueue<Point> npQue = new PriorityQueue<Point>(); // 한칸씩 떨구고 다음 떨굴 상태 저장하자
		char [][] nMap = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				nMap[i][j] = map[i][j];
			}
		}
		while (!pQue.isEmpty()) { // 다 떨굴때까지
			Point now = pQue.poll(); // 밑에 줄꺼 부터 나올거에여
			int row = now.row;
			int col = now.col;
			if (row + 1 >= R) // 바닥이다? 끝
				return false;
			if (nMap[row + 1][col] == 'x') { // 떨굴라는데 미네랄이 있다? 끝
				return false;
			}
			nMap[row][col] = '.'; // 원래 자리는 비워주고
			nMap[row + 1][col] = 'x'; // 아래 자리는 채워주고
			npQue.offer(new Point(row + 1, col)); // 또 떨구기 위해
		}

		// 다 잘 떨궈졌으면 원본들 변화
		pQue = npQue;
		map = nMap;

		return true;
	}
}
