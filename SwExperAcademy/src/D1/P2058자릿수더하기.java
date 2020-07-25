/*package D1;

import java.util.Scanner;

public class P2058자릿수더하기 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String T = sc.next();
		int sum = 0;
		
		for(char i : T.toCharArray() ) {
			sum += (int)i - 48;
		}
		System.out.print(sum);
	}

}
*/
package D1;

import java.util.Scanner;

public class P2058자릿수더하기 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int sum = 0;
		
		while(T%10 != 0) {
			sum += T % 10;
			T = T/10;
		}
		System.out.print(sum);
	}

}
