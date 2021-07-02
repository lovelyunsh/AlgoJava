package Round728Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_pleasantPairs {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < t ; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int [] num = new int[n];
			int [] arr = new int[2*n+1];
			Arrays.fill(arr, Integer.MAX_VALUE);
			for(int i = 0 ; i < n ; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				arr[num[i]] = i+1;
			}
			int ans= 0;
			for(int i = 3 ; i < 2*n ; i++) {
				for(int j = 1; j <= Math.sqrt(i);j++) {
					if(i%j == 0 && i!=j*j) {
						if(arr[j] + arr[i/j] == i)
							ans++;
					}
				}
			}
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

}
