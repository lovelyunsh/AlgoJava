package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17281야구 {

	static int N, round[][], max;
	static int player[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int sel[] = new int[8];
	static boolean visit[] = new boolean[9];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		round = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				round[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		powerset(0);
		System.out.println(max);
	}

	static void powerset(int selidx) {
		if (selidx == 8) {
			max = Math.max(play(), max);
		}
		
		for (int i = 1; i <= 8; i++) {
			if (visit[i])
				continue;
			sel[selidx] = i;
			visit[i] = true;
			powerset(selidx + 1);
			visit[i] = false;
		}
	}

	static int play() {
		int nownum = 0; // 현재 칠 타자의 타순
		int score = 0;
		int out = 0;
		int map[] = new int[3];
		int hit = 0; // 뭘로 치는지
		gg: for (int i = 0; i < N; i++) { // i는 라운드
			while (true) { //반복 한번당 타자 한명
				if (nownum < 3) {
					hit = round[i][sel[nownum]];
				}
				if (nownum == 3) {
					hit = round[i][0];
				}
				if (nownum > 3) {
					hit = round[i][sel[nownum - 1]];
				}
				nownum = (nownum+1)%9;
				if (hit == 0) {
					out++;
					if (out == 3) {
						out = 0;
						Arrays.fill(map, 0);
						break;
					}
					continue;
				}
				for (int j = 2; j >= 0; j--) {// 기존 맵에 있던 친구들 위치 바꾸기
					int pos = j;
					if (map[pos] == 1) {
						map[pos] = 0;
						pos = pos + hit;
						if (pos > 2) {
							score++;
							continue;
						}
						map[pos] = 1;
					}
				}
				if(hit == 4) {
					score ++;
					continue;
				}
				map[hit-1] = 1;

			}
		}

		return score;
	}
}
