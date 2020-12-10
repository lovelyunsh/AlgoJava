package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1987알파벳visit {
	static char map[][];
	static boolean alpha[];
	static int R;
	static int C;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int max;
	static void dfs(Point p , int cnt) {
		for(int i = 0 ; i < 4 ; i++) {
			int row = p.x + dr[i];
			int col = p.y + dc[i];
			if(row<0 || col < 0 || row>=R || col >=C)
				continue;
			if(alpha['Z' - map[row][col]])
				continue;
			alpha['Z' - map[row][col]] = true;
			dfs(new Point(row,col), cnt+1);
			alpha['Z' - map[row][col]] = false;
		}
		max = Math.max(cnt, max);
		
	}
	

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		alpha = new boolean[27];
		max = 0;
		for (int i = 0; i < R; i++) {
			String hi = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = hi.charAt(j);
			}
		}
		alpha['Z' - map[0][0]] = true;
		dfs(new Point(0,0), 1);
		System.out.println(max);
	}

}
