package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17070파이프옮기기1 {

	static int map[][];
	static int dr[] = { 0, 1, 1 };
	static int dc[] = { 1, 0, 1 };
	static int N, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		dfs(new Point(0,1),0);
		System.out.println(result);
	}

	static void dfs(Point p, int pre) {

		if (p.x == N - 1 && p.y == N - 1) {
			result++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			if(pre ==0 && i == 1)
				continue;
			if(pre ==1 && i == 0)
				continue;
			int row = p.x + dr[i];
			int col = p.y + dc[i];
			
			
			if (row < 0 || col < 0 || row >= N || col >= N)
				continue;
			if (map[row][col] == 1)
				continue;
			if (i == 2) {
				if (map[row - 1][col] == 1)
					continue;
				if (map[row][col - 1] == 1)
					continue;
			}

			dfs(new Point(row, col),i);

		}

	}

}
