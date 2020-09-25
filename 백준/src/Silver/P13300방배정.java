package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13300방배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int stu[][] = new int[2][7];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stu[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		int room = 0;
		for (int i = 1; i <= 6; i++) {
			if (stu[0][i] != 0)
				room += stu[0][i] % K != 0 ? stu[0][i] / K + 1 : stu[0][i] / K;

			if (stu[1][i] != 0) {
				room += stu[1][i] % K != 0 ? stu[1][i] / K + 1 : stu[1][i] / K;
			}

		}
		System.out.println(room);
	}
}
