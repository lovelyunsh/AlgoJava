package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P1208FlattenSort {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int work = sc.nextInt();
			int boxarr[] = new int[100];
			for (int i = 0; i < 100; i++) {
				boxarr[i] = sc.nextInt();
			}
			Arrays.sort(boxarr);
			for (int i = 0; i < work; i++) {
				if(boxarr[0] == boxarr[99])
					break;
				boxarr[0]++;
				boxarr[99]--;
				for (int j = 0; j < 100; j++) {
					if (boxarr[j] > boxarr[j + 1]) {
						int temp = boxarr[j];
						boxarr[j] = boxarr[j + 1];
						boxarr[j + 1] = temp;
					} else
						break;
				}
				for (int j = 99; j >= 0; j--) {
					if (boxarr[j] < boxarr[j - 1]) {
						int temp = boxarr[j];
						boxarr[j] = boxarr[j - 1];
						boxarr[j - 1] = temp;
					} else
						break;
				}
			}

			int result = boxarr[99] - boxarr[0];

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
