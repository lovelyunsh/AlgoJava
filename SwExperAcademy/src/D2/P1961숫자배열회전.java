package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1961숫자배열회전 {

	static int[][] turn(int[][] map) {
		int[][] clone = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				clone[j][map.length - 1 - i] = map[i][j];
			}
		}
		return clone;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(bf.readLine());
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.printf("#%d\n", tc);
			StringBuilder sb[] = new StringBuilder[N];
			for (int i = 0; i < N; i++)
				sb[i] = new StringBuilder();
			for (int bangbang = 0; bangbang < 3; bangbang++) {
				map = turn(map);
				for (int i = 0; i < N; i++) {
					String str = Arrays.toString(map[i]).replaceAll("[^0-9]", "");
					sb[i].append(str);
					sb[i].append(" ");
				}
			}
			for(StringBuilder i : sb)
				System.out.println(i);
			
		}
	}

}
