package noRank;

import java.util.PriorityQueue;

public class test {
	static int num = -1;
	static class ab implements Comparable<ab>{
		int a;
		
		@Override
		public int compareTo(ab o) {
			// TODO Auto-generated method stub
			return num*this.a - num*o.a;
		}

		public ab(int a) {
			this.a = a;
		}
		
	}
	
	public static void main(String[] args) {
		PriorityQueue<ab> cc = new PriorityQueue<test.ab>();
		cc.add(new ab(1));
		cc.add(new ab(2));
		cc.add(new ab(3));
		cc.add(new ab(4));
		cc.add(new ab(5));
		
		System.out.println(cc.poll().a);
		num = 1;
		cc.add(new ab(-1));
		System.out.println(cc.poll().a);
		System.out.println(cc.poll().a);
		System.out.println(cc.poll().a);
		
	}

}
