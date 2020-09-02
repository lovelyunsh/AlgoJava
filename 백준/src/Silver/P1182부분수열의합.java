package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182부분수열의합 {
	static int N,S,data[],result;
	static boolean sel[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		data = new int[N];
		sel = new boolean[N];
		st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			data[i] = Integer.parseInt(st.nextToken());
		powerSet(0);
		System.out.println(result);
		
	}
	
	
	static void powerSet(int idx) {
		if(idx == N) {
			int sum = 0;
			boolean flag = false;
			for(int i = 0 ; i < N ; i++) {
				if(sel[i]) {
					sum+= data[i];
					flag = true;
				}
			}
			if(!flag)
				return;
			if(sum == S)
				result++;
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
		
	}

}
