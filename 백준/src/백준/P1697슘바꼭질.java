package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697슘바꼭질 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] min = new int[100005];
		System.out.println(bfs(N, K, min));

	}

	public static int bfs(int N, int K, int[] map) {
		int next = N;
		int[] now = new int[3];
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(next);
		map[next] = 0;

		while (!que.isEmpty() && next != K) {
			next = que.poll();
			now[0] = next - 1;
			now[1] = next + 1;
			now[2] = next * 2;
			for (int i = 0; i < 3; i++) {
				if (now[i] >= 0 && now[i] <= 100000) {
					if (map[now[i]] == 0) {
						que.add(now[i]);
						map[now[i]] = map[next] + 1;
					}
				}
			}
		}
		int result = map[K];
		return result;
	}
}
