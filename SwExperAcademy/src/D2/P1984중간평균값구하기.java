package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1984중간평균값구하기 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int arr[] = new int [10];
			
			for(int i = 0 ; i < 10 ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			float sum = 0;
			for(int i = 1 ; i <9 ; i++) {
				sum += arr[i];
			}
			int result = Math.round(sum/8);
			System.out.printf("#%d %d\n", tc, result);
		}
	}


}
