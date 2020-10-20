package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P14226이모티콘 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean visit[][] = new boolean[10001][10001];

		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(1, 0)); // x= 현재 개수 y = 클립보드 개수
		visit[1][0] = true;
		int cnt = 0;
		gg:while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point now = que.poll();
				if(now.x == N) {
					break gg;
				}
				if (!visit[now.x][now.x]) {
					visit[now.x][now.x] = true;
					que.offer(new Point(now.x, now.x));
				}
				if(now.x-1 >0 && !visit[now.x-1][now.y]) {
					visit[now.x-1][now.y] = true;
					que.offer(new Point(now.x-1,now.y));
				}
				if(!visit[now.x+now.y][now.y]) {
					visit[now.x+now.y][now.y] = true;
					que.offer(new Point(now.x+now.y, now.y));
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
