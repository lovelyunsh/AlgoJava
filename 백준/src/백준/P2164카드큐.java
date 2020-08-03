package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164카드큐 {




	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i ++) {
			queue.offer(i);
		}
		while(queue.size() != 1) {
			queue.poll();
			int temp = queue.poll();
			queue.offer(temp);
		}
		
		System.out.println(queue.poll());
	}

}
