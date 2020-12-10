package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G3_20209스트레이트스위치게임부분 {
	static int firstCube[], N, K;
	static ArrayList<Integer> switchs[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		firstCube = new int[N];
		switchs = new ArrayList[K];
		sel = new int[K];
		for (int i = 0; i < K; i++)
			switchs[i] = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			firstCube[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++)
				switchs[i].add(Integer.parseInt(st.nextToken()) - 1);
		}

		powerset(0, K * 4, 0);
		// 부분 집합 으로 스위치 누르는 횟수들을 만들고
		// 그 숫자 만큼 스위치 눌러보고
		// 숫자가 같아졌는지 검사하기
		if(!finish)
			ans = -1;
		System.out.println(ans);
	}

	static int sel[], ans = Integer.MAX_VALUE;
	static boolean finish;
	static void powerset(int selidx, int num, int sum) {
		if(sum >= ans)
			return;
		if (selidx == K) {
			if(!check(click()))
				return;
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 0; i <= num; i++) {
			if (i > 4)
				break;
			sel[selidx] = i;
			powerset(selidx + 1, num - i,sum + i);

		}
	}

	static int[] click() {
		int newcube[] = firstCube.clone();
	
		for (int i = 0; i < K; i++) {
			if (sel[i] == 0)
				continue;
			for (int j : switchs[i])
				newcube[j] = (newcube[j] + (i+1) * sel[i]) % 5;
		}
		return newcube;
	}
	static boolean check(int [] cube) {
		int flag = cube[0];
		for (int i = 1; i < N; i++) {
			if (cube[i] != flag)
				return false;
		}
		finish = true;
		return true;
	}

}
