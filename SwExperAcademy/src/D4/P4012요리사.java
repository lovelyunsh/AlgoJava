package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P4012요리사 {
	static int sel[];
	static int N, Min;
	static int matrix[][];
	static void comb(int selidx, int idx) {
		if(selidx == N/2) {
			ArrayList<Integer> A = new ArrayList<Integer>();
			for(int i = 0 ; i < N/2 ; i++)
				A.add(sel[i]);
			ArrayList<Integer> B = new ArrayList<Integer>();
			for(int i = 0 ; i < N; i++) {
				if(!A.contains(i))
					B.add(i);
			}
			int diff = Math.abs(getSum(A) - getSum(B));
			Min = Math.min(Min, diff);
			return;
		}
		if(idx == N) {
			return;
		}
		sel[selidx] = idx;
		comb(selidx+1,idx+1);
		comb(selidx,idx+1);
		
		
	}
	static int getSum(ArrayList<Integer> sel) {
		int sum= 0;
		for(int i = 0 ; i < sel.size() ; i ++) {
			for(int j = i+1 ; j < sel.size() ; j++) {
				
				sum += (matrix[sel.get(i)][sel.get(j)] + matrix[sel.get(j)][sel.get(i)]);
			}
		}
		return sum;
		
	}
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			sel = new int[N/2];
			matrix = new int [N][N];
			Min=123456789;
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0,0);

			System.out.printf("#%d %d\n", tc,Min);
		}
	}


}
