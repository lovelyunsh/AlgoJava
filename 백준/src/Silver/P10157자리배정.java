package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10157자리배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dr[] = { 1, 0, -1, 0 };
		int dc[] = { 0, 1, 0, -1 };
		int colnum = Integer.parseInt(st.nextToken());
		int rownum = Integer.parseInt(st.nextToken());
		int seat = Integer.parseInt(br.readLine());
		if (colnum * rownum < seat) {
			System.out.println(0);
			System.exit(0);
		}

		int map[][] = new int[rownum][colnum];
		int d = 0;
		int row = 0;
		int col = 0;
		for (int i = 1; i <= seat; i++) {

			map[row][col] = i;
			if(i==seat)
				break;
			while (true) {
				int new_row = row + dr[d];
				int new_col = col + dc[d];
				if(new_row<0 || new_col <0 || new_row>=rownum || new_col>=colnum) {
					d = (d+1)%4;
					continue;
				}
				
				if(map[new_row][new_col] != 0) {
					d = (d+1)%4;
					continue;
				}
				row = new_row;
				col = new_col;
				break;
			}
		}
		System.out.println((col+1)+" "+(row+1));

	}

}
