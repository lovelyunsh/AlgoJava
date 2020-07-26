package D2;

import java.util.Scanner;

public class P1986지그재그숫자 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			int num = sc.nextInt();
			System.out.printf("#%d %d",tc,num%2 == 1 ? num/2+1 : -(num/2) );
			System.out.println();
			
		}
	}

}
