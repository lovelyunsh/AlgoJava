package Silver;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2667단지번호붙이기 {

	static boolean visited[][];
	static int map[][];
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int cnt = 1;
	static int N;

	static boolean dfs(Point p) {

		if (map[p.x][p.y] != -1)
			return false;
		map[p.x][p.y] = cnt;

		for (int i = 0; i < 4; i++) {
			int row = p.x + dr[i];
			int col = p.y + dc[i];
			if (row < 0 || col < 0 || row >= N || col >= N)
				continue;
			if (map[row][col] != -1)
				continue;
			dfs(new Point(row, col));
		}

		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		Queue<Point> que = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j)-'0';
				if (map[i][j] == 1) {
					que.add(new Point(i, j));
					map[i][j] = -1;
				}
			}
		}
		while (!que.isEmpty()) {
			if (dfs(que.poll()))
				cnt++;
		}
		int [] arr = new int [cnt];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				arr[map[i][j]]++;
			}
		}
		arr[0] = 0;
		Arrays.sort(arr);
		System.out.println(cnt-1);
		
		for(int i = 1 ; i < cnt ; i++) {
			System.out.println(arr[i]);
		}
	}

}
