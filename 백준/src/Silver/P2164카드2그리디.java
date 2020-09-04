package Silver;

import java.util.Scanner;

public class P2164카드2그리디 {
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 int N = sc.nextInt();
		 int temp = 0;
		 int result = 0;
		 if(N<2)result = 1;
			 
		 for(int i=2 ; i <= N ; i++) {
			 temp +=2;
			 result = temp;
			 if(i == temp) {
				 temp = 0;
			 }
		 }
		 System.out.println(result);
	}
}
