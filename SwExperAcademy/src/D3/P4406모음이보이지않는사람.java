package D3;

import java.util.Scanner;

public class P4406모음이보이지않는사람 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		char [] a = {'a','e','i','o','u'};
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();
			System.out.printf("#%d ",test_case);
			
			for(char i : input.toCharArray()) {
				boolean flag = true;
				for(char ae : a) {
					if(ae == i) {
						flag = false;
						break;
					}
				}
				if(flag)
					System.out.print(i);
				
			}
			System.out.println();
			
		
		}
	}

}
