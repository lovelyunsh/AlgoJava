package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1748수이어쓰기1 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = (int)Math.log10(N);
		long result = 0L;
		for(int i = 0 ; i < n ; i++)
			result = (long) (result +  9 * Math.pow(10, i)*(i+1));
		
		result += (N-Math.pow(10, n)+1)*(n+1);
		System.out.println(result);
	}

}
