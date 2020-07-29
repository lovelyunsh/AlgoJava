package D5;

import java.util.ArrayList;
import java.util.Scanner;

public class P10507영어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			int n = sc.nextInt();
			int p = sc.nextInt();
			int arr [] = new int [n];
			for(int i = 0 ; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			
			System.out.printf("#%d \n", tc );
		}
		
	}
	static void makelen(int arr[]) {
		ArrayList<Integer> lenarr = new ArrayList<Integer>();
		int cnt = 0;
		int len = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i]+1 == arr[i+1]) {
				cnt ++;
			}
			else {
				lenarr.add(cnt);
				cnt = 0;
				len = arr[i+1]-arr[i];
				lenarr.add(len);
			}
		}
	}

}
