package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1926간단한369게임 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String b = "";
		
		for (int tc = 1; tc <= 1; tc++) {
			Stack<Integer> hi = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			for(int i = 1 ; i <= N ; i++) {
				int a = i;
				boolean isthree = false;
				while(a/10 !=0) {
					hi.push(a%10);
					if(hi.peek() != 0 && hi.peek()%3 == 0)
						isthree = true;
					a = a/10;
				}
				hi.push(a%10);
				if(hi.peek()%3 == 0)
					isthree = true;
				
				while(!hi.isEmpty()) {
					int c = hi.pop();
					if(isthree ) {
						if(c != 0 &&c%3 == 0) {
							b = b+ "-";
						}
					}
					else {
						b = b+c;
					}
					
				}
				b = b+" ";
				
				
				
			}
			
			System.out.println(b);
		}
	}

}
