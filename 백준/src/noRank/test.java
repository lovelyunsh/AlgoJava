package noRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		List<Integer> b = a.subList(1, 2);
		System.out.println(Arrays.toString(b.toArray()));
	}

}
