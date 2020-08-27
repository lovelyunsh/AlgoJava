package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P9205맥주마시면서걸어가기DFS {
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return (this.x + this.y) - (o.x + o.y);
		}

	}

	static ArrayList<Point> allnode;
	static int p;
	static boolean flag, visit[];
	static Point me, fe;

	static void dfs(int now) {
		if (allnode.get(now).equals(fe)) {
			flag = true;
			return;
		}
		if (flag)
			return;
		Point nowp = allnode.get(now);
		for (int i = now; i < allnode.size(); i++) {
			if (visit[i])
				continue;
			Point nextp = allnode.get(i);
			int dist = nowp.x + nowp.y - (nextp.x + nextp.y);
			if (-1000 > dist || dist > 1000)
				break;
			visit[i] = true;
			dfs(i);
			visit[i] = false;
		}
		
		for(int i = now ; i >= 0 ; i--) {
			if (visit[i])
				continue;
			Point nextp = allnode.get(i);
			int dist = nowp.x + nowp.y - (nextp.x + nextp.y);
			if (-1000 > dist || dist > 1000)
				break;
			visit[i] = true;
			dfs(i);
			visit[i] = false;
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			p = Integer.parseInt(br.readLine());
			allnode = new ArrayList<Point>();
			for (int i = 0; i < p + 2; i++) {
				st = new StringTokenizer(br.readLine());
				allnode.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			me = allnode.get(0);
			fe = allnode.get(allnode.size() - 1);

			Collections.sort(allnode);
			int now = 0;
			for (int i = 0; i < allnode.size(); i++)
				if (allnode.get(i).equals(me)) {
					now = i;
					break;
				}

			visit = new boolean[allnode.size()];
			visit[now] = true;
			flag = false;
			dfs(now);
			
			if (flag)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
