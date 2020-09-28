package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2669직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws Exception {
		int map[][] = new int[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int row1 = Integer.parseInt(st.nextToken());
			int col1 = Integer.parseInt(st.nextToken());
			int row2 = Integer.parseInt(st.nextToken());
			int col2 = Integer.parseInt(st.nextToken());
			for (int j = row1; j < row2; j++) {
				for (int k = col1; k < col2; k++) {
					if (map[j][k] == 0) {
						cnt++;
						map[j][k] = 1;
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
