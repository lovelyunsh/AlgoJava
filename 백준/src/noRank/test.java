package noRank;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		
		List<String> a = new ArrayList<>();
		a.add("123");
		a.add("2123");
		a.add("3123");
		
		
		String temp = a.get(0);
		a.set(0, a.get(2));
		a.set(2, temp);
		
	
		
		
	}

}
