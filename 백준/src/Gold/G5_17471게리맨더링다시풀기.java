package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_17471게리맨더링다시풀기 {
	static int peopleNum[];
	static boolean matrix[][];
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		peopleNum = new int[N];
		matrix = new boolean[N][N];
		sel = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			peopleNum[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int target = Integer.parseInt(st.nextToken())-1;
				matrix[i][target] = true;
				matrix[target][i] = true;
			}
		}
		ans = Integer.MAX_VALUE;
		powerSet(0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static boolean sel[];

	static void powerSet(int idx) {
		if (idx == N) {
			ArrayList<Integer> section1 = new ArrayList<>();
			ArrayList<Integer> section2 = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (sel[i])
					section1.add(i);
				else
					section2.add(i);
			}
			
			int cnt1 = check(section1);
			if(cnt1 == -1)
				return;
			int cnt2 = check(section2);
			if(cnt2 == -1)
				return;
			ans = Math.min(Math.abs(cnt1-cnt2), ans);
			return;
		}
		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);

	}

	static int check(ArrayList<Integer> section) {
		if(section.size() == 0)
			return -1;
		Queue<Integer> que = new LinkedList<Integer>();
		int first = section.remove(0);
		int cnt = peopleNum[first];
		que.add(first);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int i = section.size()-1; i >= 0; i--)
				if (matrix[now][section.get(i)]) {
					int num = section.remove(i);
					cnt += peopleNum[num];
					que.offer(num);
				}

		}
		if(section.size() == 0)
			return cnt;
		else
			return -1;
	}

}
