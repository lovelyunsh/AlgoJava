import java.util.Arrays;
import java.util.HashSet;

public class test {

	public static void main(String[] args) {
		int h= 2;
		int m = 12;
		int s= 5;
		System.out.println(String.format("%02d:%02d:%02d",h,m,s));
		
		HashSet<HashSet> a = new HashSet<>();
		HashSet<Integer> l1 =new HashSet<Integer>(Arrays.asList(1,2,3));
		HashSet<Integer> l2 =new HashSet<Integer>(Arrays.asList(1,2,3));
		a.add(l1);
		a.add(l2);
		
		
		
		System.out.println(1);
	}
}
