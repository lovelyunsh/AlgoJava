package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205맥주마시면서걸어가기 {
	static ArrayList<Point> allnode;
	static Point fe;

	static boolean bfs() {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(allnode.get(0));
		allnode.remove(0);
		while(!que.isEmpty()) {
			Point nowp = que.poll();
			if(nowp.equals(fe))
				return true;
			for (int i = allnode.size()-1; i >= 0; i--) {
				Point nextp = allnode.get(i);
				int dist = Math.abs(nowp.x - nextp.x) + Math.abs(nowp.y - nextp.y);
				if (-1000 > dist || dist > 1000)
					continue;
				que.offer(allnode.get(i));
				allnode.remove(i);
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int p = Integer.parseInt(br.readLine());
			allnode = new ArrayList<Point>();
			for (int i = 0; i < p + 2; i++) {
				st = new StringTokenizer(br.readLine());
				allnode.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			fe = allnode.get(allnode.size() - 1);
			if (bfs())
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
