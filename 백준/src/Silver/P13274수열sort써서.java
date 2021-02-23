package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class P13274수열sort써서 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		long arr[] = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		Arrays.sort(arr);
		for (int i = 0; i < K; i++) {
			int L = sc.nextInt() - 1;
			int R = sc.nextInt() - 1;
			long X = sc.nextLong();
			for(int j = L ; j <= R ; j++)
				arr[j] += X;
			Arrays.sort(arr);
		}
		for (long i : arr)
			System.out.print(i + " ");

		sc.close();

	}

}
