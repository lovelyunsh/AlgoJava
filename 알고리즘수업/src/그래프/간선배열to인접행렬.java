package 그래프;

import java.util.Arrays;
import java.util.Scanner;

public class 간선배열to인접행렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //정점
		int M = sc.nextInt(); //간선
		int mat[][] = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			mat[x][y] = mat[y][x] = 1;
		}
		
		
		for(int i[] : mat) {
			System.out.println(Arrays.toString(i));
		}
		
	}

}
