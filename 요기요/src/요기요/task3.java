package 요기요;

import java.util.ArrayList;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution3 {
 public int[] solution(int N) {
     // write your code in Java SE 8
	 ArrayList<Integer> arr = new ArrayList<Integer>();
	 int n = (int)Math.sqrt(N)+1;
	 int mod = n*n-N;
	 int num = 1;
	 if(mod %2 == 1) {
		 for(int i = 1; i < 2*n +1 ; i++) {
			 if(i != mod)
				 arr.add(i);
		 }
	 }else {
		 for(int i = 1; i < 2*n +1 ; i++) {
			 if(i != 1 || i != mod-1)
				 arr.add(i);
		 }
	 }
	 
	 //return arr;
	 return null;
 }
}
