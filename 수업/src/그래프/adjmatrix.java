package 그래프;

import java.util.Scanner;

public class adjmatrix {

	static int N;
	static boolean[][] adjMatrix;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjMatrix = new boolean[N][N];
		
		int cnt = sc.nextInt();
		
		for (int i = 0; i < cnt; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = true;
			
		}
		
	}

}
