package 회귀;

import java.util.Scanner;

public class 순열연습 {
	static int arr[];
	static int N;
	static boolean check[];
	static int sel[];
	static void perm(int idx) {
		if(idx == N) {
			for(int i : sel) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
			
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				sel[idx] = arr[i];
				check[i]= true;
				perm(idx+1);
				check[i] = false;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		check = new boolean[N];
		arr = new int[N];
		sel = new int[N];
		for(int i = 1 ; i <= N ; i++) {
			arr[i-1]  = i; 
		}
		
		perm(0);
		
		
	}
	

}
