package D4;

import java.util.Scanner;

public class P3234준환이의양팔저울 {
	static int weight[], N, sel[], cnt, fullsum;
	static boolean visit[];

	static void perm(int idx) {
		if (idx == N) {
			comb(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			sel[idx] = weight[i];
			perm(idx + 1);
			visit[i] = false;
		}
	}

	static void comb(int idx, int L, int R) {
		if (L < R) {
			return;
		}
		if (idx == N) {
			cnt++;
			return;
		}
		comb(idx + 1, L + sel[idx], R);
		comb(idx + 1, L, R + sel[idx]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			weight = new int[N];
			visit = new boolean[N];
			sel = new int[N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
				fullsum += weight[i];
			}
			perm(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

}