package D3;

import java.util.ArrayList;
import java.util.Scanner;

public class P5215햄버거다이어트2 {
	static int arr [];
	static ArrayList<Integer> arr1 = new ArrayList<>();
	static boolean[] sel;
	static int[] cal;
	static int[] score;
	static void powerSet(int idx) {
		
		if(idx == arr.length) {
			for(int i = 0 ; i < arr.length ; i++) {
				if(sel[i])
					break;
					
			}
			System.out.println();
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx + 1);
		
					
					
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			arr = new int [N];
			for(int i = 0 ; i < N ; i ++)
				arr[i] = i;
			sel = new boolean[N];
			
			
			System.out.printf("#%d \n", tc );
		}
	}



}
