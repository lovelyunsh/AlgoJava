package D2;

import java.util.Scanner;

public class P1940가랏RC카 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int dist = 0;
			int speed = 0;
			for(int i = 0 ; i < N ; i++) {
				int pm = sc.nextInt();
				if(pm != 0) 
					speed = pm == 1 ? speed + sc.nextInt() : speed - sc.nextInt(); 
				if(speed<0)
					speed = 0;
				dist += speed; 
			}
			System.out.printf("#%d %d\n", tc, dist );
		}
	}


}
