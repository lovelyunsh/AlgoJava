package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14696딱지놀이 {
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		gg: for (int turn = 0; turn < N; turn++) {
			int A[] = new int[5];
			int B[] = new int[5];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			for (int i = 4; i > 0; i--) {
				if (B[i] < A[i]) {
					System.out.println('A');
					continue gg;
				}
				if (B[i] > A[i]) {
					System.out.println('B');
					continue gg;
				}
			}
			System.out.println('D');
			
		}

	}

}
