package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3499퍼펙트셔플 {
	
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			//solving
			int N = sc.nextInt();
			Queue<String> que = new LinkedList<>();
			Queue<String> front = new LinkedList<>();
			Queue<String> back = new LinkedList<>();
			

			for(int i = 0 ; i < N/2 + N%2 ; i++)
				front.offer(que.poll());
			while(!que.isEmpty())
				back.offer(que.poll());
			
			String result = "";
			while(!front.isEmpty()) {
				result = result + front.poll()+ " ";
				if(!back.isEmpty())
					result = result + back.poll()+ " ";
			}
			
			System.out.printf("#%d "+result +"\n", tc );
			
		}
	}

}
