package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_2048Easy {
	
	static int firstmap[][];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		firstmap = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				firstmap[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	static void move(int cnt,int map[][]) {
		for(int i = 0 ; i < 4; i++) {
			int dupmap[][] = clone(map);
			go(dupmap,i);
			move(cnt+1,dupmap);
		}
		
		
	}
	
	static int[][] clone(int [][] map) {
		int newmap[][] = new int[N][N];
		for(int i = 0 ; i < N ; i++)
			newmap[i] = map[i].clone();
		return newmap;
	}
	static void go(int map[][],int dir) {
		
	}

}
