package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G4_2457공주님의정원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Point> arr = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			arr.add(new Point(a1 * 100 + a2, b1 * 100 + b2));
		}
		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
		int last = 301;
		int lastidx = -1;
		int cnt = 0;
		gg: while (true) {
			int temp = last;
			int i = lastidx;
			boolean isget = false;
			while (true) {
				if (++i >= N) {
					if (!isget) {
						cnt = 0;
						break gg;
					}
					break;
				}
				if (arr.get(i).x > temp) {
					if (!isget) {
						cnt = 0;
						break gg;
					}
					break;
				}
				if (arr.get(i).y > last) {
					lastidx = i;
					last = arr.get(i).y;
					isget = true;
				}
			}
			cnt++;
			if (last >= 1201)
				break;
		}
		System.out.println(cnt);

	}
}
