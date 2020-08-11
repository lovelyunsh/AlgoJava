package 그래프;

import java.util.ArrayList;
import java.util.Scanner;

public class 간선배열to인접리스트 {
//7 8
//0 1
//0 2
//1 3
//1 4
//2 4
//3 5
//4 5
//5 6

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = new ArrayList<Integer>();
		for(int i = 0 ; i < M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=0; i < N ; i++ )
			System.out.println(i + " : " + arr[i]);
		
		
		
	}

}
