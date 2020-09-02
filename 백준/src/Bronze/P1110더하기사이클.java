package Bronze;

import java.util.Scanner;

public class P1110더하기사이클 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cycle = 0;
		int newN = N;
		while(true) {
			cycle++;
			newN = newN%10 * 10 + (newN/10 + newN%10)%10;
			if(newN == N)
				break;
		}
		System.out.println(cycle);
	}

}
