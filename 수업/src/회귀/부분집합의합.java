package 회귀;

import java.util.Scanner;

public class 부분집합의합 {

	static int arr[];
	static boolean check[];
	static int N;

	static void superSet(int idx) {
		if (idx == N-1) {
			for (int i = 0; i < idx; i++)
				if (check[i])
					System.out.print(arr[i]);
			System.out.println();
			return;
		}

		check[idx] = true;
		superSet(idx + 1);
		check[idx] = false;
		superSet(idx + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int [N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		check = new boolean[N];
		superSet(0);

	}

}
