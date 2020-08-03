package D3;

import java.util.Scanner;

public class P9229한빈이와SpotMart {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int snack[] = new int [N];
			int wei = 0;
			int max = 0;
			for(int i = 0 ; i < N ; i++)
				snack[i] = sc.nextInt();
			for(int i = 0 ; i < N -1 ; i++) {
				for(int j = i+1 ; j < N ; j++ ) {
					wei = snack[i]+snack[j];
					if(wei <= M)
						max = Math.max(wei, max);
				}
			}
			
			max = max == 0 ? -1 : max;
			System.out.printf("#%d %d\n", tc , max);
		}
	}

}
