package 요기요;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public int solution(int[] A) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int ans = 0;
		for (int i : A)
			arr.add(i);
		TreeSet<Integer> tree = new TreeSet<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 < 1)
					return o2 - o1;

				return o1 - o2;
			};
		});
		tree.addAll(arr);
		arr = new ArrayList<Integer>(tree);
		for (int i = 0; i < arr.size(); i++) {
			if (i + 1 != arr.get(i)) {
				ans = i + 1;
				break;
			}
		}
		if (ans == 0)
			ans = arr.size() + 1;
		return ans;

	}
}
