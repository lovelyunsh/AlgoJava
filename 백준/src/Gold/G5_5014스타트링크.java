package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_5014스타트링크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 최대
		int S = Integer.parseInt(st.nextToken()); // 현재
		int G = Integer.parseInt(st.nextToken()); // 도착
		int U = Integer.parseInt(st.nextToken()); // 위
		int D = Integer.parseInt(st.nextToken()); // 아래
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(S);
		boolean visit[] = new boolean[F + 1];
		visit[S] = true;
		int cnt = 0;
		boolean flag = false;
		gg:while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int now = que.poll();
				if (now == G) {
					flag = true;
					break gg;
				}
				int up = now + U;
				if (up <= F  && !visit[up]) {
					visit[up] = true;
					que.offer(up);
				}
				int down = now - D;
				if ( down > 0 && !visit[down]) {
					visit[down] = true;
					que.offer(down);
				}
			}
			cnt++;
		}

		System.out.println(flag? cnt:"use the stairs");

	}

}
