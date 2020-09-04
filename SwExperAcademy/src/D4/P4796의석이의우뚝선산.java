package D4;

import java.util.Scanner;

public class P4796의석이의우뚝선산 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int map[] = new int[N];
			for (int i = 0; i < N; i++)
				map[i] = sc.nextInt();
			int result = 0;
			int left = 0;
			int right = 0;
			for (int i = 1; i < N; i++) {
				if(map[i-1] < map[i]) {
					if( left == 0 && right >0)
						right = 0;
					else if(left>0 && right >0) {
						result += left*right;
						left = right = 0;
					}
				}
				if(map[i-1] < map[i])
					left++;
				else
					right++;
				
			}
			if( left > 0 && right > 0)
				result += left * right;

			System.out.printf("#%d %d\n", tc,result);
		}
	}

}
