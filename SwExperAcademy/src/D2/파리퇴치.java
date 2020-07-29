package D2;

import java.util.Scanner;

public class 파리퇴치 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int Narr[][] = new int[N][N];
			for(int i =0 ; i < N ; i++)
				for(int j = 0 ; j < N ; j++)
					Narr[i][j] = sc.nextInt();
			int max = 0;
			for (int i = 0; i < N - M; i++) {
				int sum = 0;
				for (int j = 0; j < N - M; j++) {
					for (int k = 0; k < M; k++)
						sum += Narr[i + k][j + k];
					if(max < sum)
						max = sum;
				}
			}

			System.out.printf("#%d %d\n", tc,max);
		}
	}

}
