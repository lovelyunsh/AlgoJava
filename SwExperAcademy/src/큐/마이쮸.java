package 큐;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {

	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<>();
		int N = 20;
		int person = 1;
		queue.offer(new int[] { 1, 1 });
		while(N>0) {
			int[] p = queue.poll();
			int available = (N>=p[1])?p[1]:N;
			N -= available;
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : "+ p[0]+", 가져간 개수: "+available);
			}else {
				System.out.println(p[0] + "번이"+ available + " 개수만큼 가져갑니다. 남은 개수 : "+N);
				++p[1];
				queue.offer(p);
				queue.offer(new int [] {++person , 1});
			}
		}
	}
}
