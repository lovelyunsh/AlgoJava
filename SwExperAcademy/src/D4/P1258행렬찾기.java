package D4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class result implements Comparable<result>{
	int row;
	int col;
	@Override
	public int compareTo(result o) {
		
		if(this.row*this.col == o.row*o.col)
			return this.row-o.row;
		return this.row*this.col - o.row*o.col;
	}
	public result(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	
}
public class P1258행렬찾기 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			Queue<Point> quelu = new LinkedList<>();
			Queue<Point> queru = new LinkedList<>();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0)
						continue;

					if (i - 1 < 0 || map[i - 1][j] == 0)
						if (j - 1 < 0 || map[i][j - 1] == 0) {
							quelu.offer(new Point(i, j));
							cnt++;
						}
					if (i - 1 <0 || map[i - 1][j] == 0)
						if (j + 1 >= N || map[i][j + 1] == 0)
							queru.offer(new Point(i, j));

				}
			result resultarr [] = new result[cnt];
			for(int i = 0 ; i < cnt ; i++) {
				Point left = quelu.poll();
				Point right = queru.poll();
				int nrow = left.x;
				int ncol = left.y;
				int rowcnt = 1;
				while(true) {
					nrow++;
					if(nrow>=N || map[nrow][ncol] == 0)
						break;
					rowcnt++;
				}
				resultarr[i] = new result(rowcnt,right.y-left.y+1);
			}
			
			Arrays.sort(resultarr);
			StringBuilder sb = new StringBuilder();
			sb.append(cnt+" ");
			for(int i = 0; i < cnt ; i++) {
				sb.append(resultarr[i].row +" ");
				sb.append(resultarr[i].col +" ");
			}
			System.out.println("#"+tc+" " + sb);
		}
	}

}
