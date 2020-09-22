package Silver;

import java.util.Scanner;

public class P1463_1로만들기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] dp = new int [N+1];
		dp[1] = 0;
		for(int i = 2 ; i < N+1 ; i++) {
			int min = 9999999;
			if(i%3 == 0) {
				min = Math.min(dp[i/3]+1, min);
			}
			if(i%2 == 0) {
				min = Math.min(dp[i/2]+1, min);
			}
			min = Math.min(dp[i-1]+1, min);
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}

}
