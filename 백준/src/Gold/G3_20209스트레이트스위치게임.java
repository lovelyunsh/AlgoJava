package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_20209스트레이트스위치게임 {
	static int firstcube[];
	static ArrayList<Integer> switchlist[];
	static int N, K;
	static boolean finish = false;
	static HashMap<String, Boolean> visit = new HashMap<String, Boolean>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		firstcube = new int[N];
		switchlist = new ArrayList[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			firstcube[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++)
			switchlist[i] = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++)
				switchlist[i].add(Integer.parseInt(st.nextToken()) - 1);
		}
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(firstcube);
		visit.put(makekey(firstcube), true);
		int click = 0;
		gg: while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				int[] now = que.poll();
				if (isfinish(now))
					break gg;

				for (int i = 0; i < K; i++) {
					int[] newcube = now.clone();
					change(newcube, i);
					String key = makekey(newcube);
					if (visit.get(key) != null)
						continue;
					
					visit.put(key, true);
					que.offer(newcube);
				}
			}
			click++;
		}
		if (!finish)
			click = -1;
		System.out.println(click);
	}

	static String makekey(int[] cube) {
		String key = "";
		for (int i = 0; i < N; i++) {
			key += cube[i];
		}
		return key;
	}

	static void change(int[] cube, int switchnum) {
		for (int i : switchlist[switchnum])
			cube[i] = (cube[i] + switchnum + 1) % 5;
	}

	static boolean isfinish(int[] cube) {
		int flag = cube[0];
		for (int i = 1; i < N; i++) {
			if (cube[i] != flag)
				return false;
		}
		finish = true;
		return true;
	}

}
