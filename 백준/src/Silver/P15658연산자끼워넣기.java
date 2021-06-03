package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15658연산자끼워넣기 {
	static int N, min, max;
	static int nums[];
	static int operator[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		nums = new int[N];
		operator = new int[4];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		dfs(nums[0],1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int result, int idx) {
		if (idx == N) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int num = 0;
			if (operator[i] == 0)
				continue;
			operator[i]--;
			if (i == 0)
				num = result + nums[idx];
			else if (i == 1)
				num = result - nums[idx];
			else if (i == 2)
				num = result * nums[idx];
			else if (i == 3)
				num = result / nums[idx];
			dfs(num,idx+1);
			operator[i]++;

		}
	}

}
