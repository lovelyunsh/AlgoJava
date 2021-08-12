package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2_21611마법사상어와블리자드 {
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		List<Integer> arr = new ArrayList<Integer>();
		for (int j = 0; j < N; j++) {
			if(map[0][j] == 0)
				continue;
			arr.add(map[0][j]);
		}
		int num = N - 1;
		int row = 0;
		int col = N - 1;
		int dr[] = { 1, 0, -1, 0 };
		int dc[] = { 0, -1, 0, 1 };
		int d = 0;
		int go = 0;
		while (num != 0) { // 일자로 쭉 펴기
			for (int i = 0; i < num; i++) {
				row = row + dr[d];
				col = col + dc[d];
				if(map[row][col] == 0)
					continue;
				arr.add(map[row][col]);
			}
			d = (d + 1) % 4;
			if (++go == 2) {
				go = 0;
				num--;
			}
		}
		Collections.reverse(arr);

		while (M-- != 0) { // 시뮬
			st = new StringTokenizer(br.readLine());
			int di = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			blizard(arr, di, si);
			Queue<Point> marble = bomb(arr);
			arr = makeNewmarble(marble, N);
		}
		System.out.println(answer);
	}

	static void blizard(List<Integer> arr, int di, int si) {
		int[] dd = { 7, 3, 1, 5 };
		while (si != 0) {// 블리자드
			int idx = dd[di - 1] + dd[di - 1] * (si - 1) + 8 * (si * (si - 1) / 2);
			if (idx < arr.size())
				arr.remove(idx - 1);
			si--;
		}

	}

	static Queue<Point> bomb(List<Integer> arr) {
		Queue<Point> marble = new LinkedList<Point>();
		int num = arr.get(0);
		int cnt = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (num == arr.get(i))
				cnt++;
			else {
				marble.add(new Point(num, cnt));
				num = arr.get(i);
				cnt = 1;
			}

		}
		int bomb = 1;
		while (bomb != 0 && !marble.isEmpty()) {
			bomb = 0;
			num = marble.peek().x;
			cnt = 0;
			int size = marble.size();
			while(size-- != 0) {
				Point now = marble.poll();
				if(num == now.x)
					cnt += now.y;
				else {
					if(cnt >=4) {
						bomb++;
						answer += num*cnt;
					}
					else
						marble.add(new Point(num,cnt));
					num = now.x;
					cnt = now.y;
				}
			}
			if(cnt >=4) {
				bomb++;
				answer += num*cnt;
			}
			else
				marble.add(new Point(num,cnt));
		}
		return marble;
	}

	static List<Integer> makeNewmarble(Queue<Point> marble, int N) {
		List<Integer> newArr = new ArrayList<Integer>();
		while (!marble.isEmpty()&& newArr.size() < N*N-1) {
			Point now = marble.poll();
			newArr.add(now.y);
			newArr.add(now.x);
		}
		return newArr;
	}

}
