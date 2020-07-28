package D3;

import java.util.Scanner;

public class P1208Flatten {

	static int[] findMinMax(int boxarr[]) {
		int min = 101;
		int max = 0;
		int minIdx;
		int maxIdx;
		minIdx = maxIdx = 0;
		for (int i = 0; i < boxarr.length; i++) {
			if (boxarr[i] > max) {
				maxIdx = i;
				max = boxarr[i];
			}

			if (boxarr[i] < min) {
				minIdx = i;
				min = boxarr[i];
			}

		}
		int result[] = { minIdx, maxIdx, min, max };
		return result;

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int[] boxarr = new int[100];
			int work = sc.nextInt();
			for (int i = 0; i < 100; i++)
				boxarr[i] = sc.nextInt();
			for (int i = 0; i < work; i++) {
				int[] MinMax = findMinMax(boxarr);
				if (MinMax[0] != MinMax[1]) {
					boxarr[MinMax[0]] += 1;
					boxarr[MinMax[1]] -= 1;
				}
				else
					break;
			}
			int MinMaxValue[] = findMinMax(boxarr);
			int result = MinMaxValue[4] - MinMaxValue[3];

			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
