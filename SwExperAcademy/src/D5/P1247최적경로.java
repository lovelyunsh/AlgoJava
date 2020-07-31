package D5;

import java.util.Scanner;

public class P1247최적경로 {
	
	static int N;
	static int [] company = new int [2];
	static int [] home = new int [2];
	static int xyvalue[][];
	static int xyindex[];
	static boolean check[];
	static int sel [];
	static int min;
	
	
	public static void minlen(int idx) {
		if(idx == N) {
			int len = Math.abs(company[0] - xyvalue[sel[0]][0]) + Math.abs(company[1] - xyvalue[sel[0]][1]);
			for(int i = 0 ; i < N-1 ; i++) {
				len += Math.abs(xyvalue[sel[i]][0]-xyvalue[sel[i+1]][0]) +Math.abs(xyvalue[sel[i]][1]-xyvalue[sel[i+1]][1]);
			}
			len += Math.abs(xyvalue[sel[N-1]][0] - home[0]) + Math.abs(xyvalue[sel[N-1]][1] - home[1]);
			if(len < min) {
				min = len;
			}
		
		}
		
		for(int i = 0 ; i < N ; i++) {
			if (!check[i]) {
				check[i] = true;
				sel[idx] = xyindex[i];
				minlen(idx + 1);
				check[i] = false;
			}
		}
		
		
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			N = sc.nextInt();
			sel = new int [N];
			check = new boolean [N];
			xyindex = new int [N];
			xyvalue = new int [N][2];
			for(int i = 0 ; i < N ; i++) {
				xyindex[i] = i;
			}
			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			
			for(int i = 0 ; i < N ; i++) {
				xyvalue[i][0] = sc.nextInt();
				xyvalue[i][1] = sc.nextInt();
			}
			min = 99999999;
			minlen(0);
			
			System.out.printf("#%d %d\n", tc, min );
		}
	}


}
