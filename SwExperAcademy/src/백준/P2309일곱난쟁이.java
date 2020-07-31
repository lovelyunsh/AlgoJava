package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class P2309일곱난쟁이 {
	static int N = 9;
	static int nangen[] = new int[N];
	static int R = 7;
	static int sel[] = new int[R];
	static int h_idx[];

	static void Search(int idx, int s_idx) {
		if (s_idx == R) {
			int sum = 0;
			for (int i = 0; i < R; i++)
				sum += sel[i];
			if (sum == 100) {
				h_idx = (int[])sel.clone();
			}

			return;
		}
		if(idx == N)
			return;
		
		sel[s_idx] = nangen[idx];
		Search(idx+1, s_idx+1);
		Search(idx+1, s_idx);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < N; i++)
			nangen[i] = sc.nextInt();
		
		
		Search(0,0);
		Arrays.sort(h_idx);
		for(int i : h_idx)
			System.out.println(i);
		

	}

}
