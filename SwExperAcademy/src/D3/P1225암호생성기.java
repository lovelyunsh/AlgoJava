package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1225암호생성기 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
			
		for(int tc = 1; tc <= T; tc++)
		{
			sc.next();
			Queue<Integer> que = new LinkedList();
			for(int i = 0 ; i < 8 ; i ++) {
				que.offer(sc.nextInt());
			}
			
			int b = 0;
			while(true) {
				
				b++;
				if(b == 6)
					b = 1;
				int a = que.poll();
				if(a-b <= 0) {
					que.offer(0);
					break;
				}
				que.offer(a-b);
			
			}
			
			
			System.out.printf("#%d", tc );
			for(int i = 0 ; i < 8 ; i++) {
				System.out.print(" "+que.poll());
			}
			System.out.println();
		}
	}


}
