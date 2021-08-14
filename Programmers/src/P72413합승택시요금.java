import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P72413합승택시요금 {

	public int solution(int n, int s, int a, int b, int[][] fares) {
		List<Point> relationList[] = new List[n + 1];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n + 1; i++)
			relationList[i] = new ArrayList<Point>();
		for (int[] i : fares) {
			relationList[i[0]].add(new Point(i[1], i[2]));
			relationList[i[1]].add(new Point(i[0], i[2]));
		}
		int[] sArr = Dij(n, s, relationList);
		int[] aArr = Dij(n, a, relationList);
		int[] bArr = Dij(n, b, relationList);
		for (int i = 1; i < n + 1; i++) {
			if(sArr[i] == Integer.MAX_VALUE || aArr[i] == Integer.MAX_VALUE || bArr[i] == Integer.MAX_VALUE )
				continue;
			min = Math.min(min, sArr[i]+aArr[i]+bArr[i]);
		}

		return min;
	}

	int[] Dij(int n, int s, List<Point>[] relationList) {
		int visit[] = new int[n + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.y - o2.y;
			}
		});
		pq.add(new Point(s, 0));
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (visit[now.x] < now.y)
				continue;
			visit[now.x] = now.y;
			for (Point p : relationList[now.x]) {
				int cost = now.y + p.y;
				if (cost < visit[p.x])
					pq.add(new Point(p.x, cost));
			}
		}
		return visit;
	}
}
