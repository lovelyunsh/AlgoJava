package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P19584난개발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int height[] = new int[N+1];
		long weight[] = new long[1000000000]; //weight크기가 문제랍니담
		long max = 0;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		int hei [] = height.clone();  
		Arrays.sort(hei);
		
		
		
		

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long W = Integer.parseInt(st.nextToken());
			if (height[start] > height[end])
				start =  end ^ start^(end = start);
			for(int j = height[start] ; j <= height[end] ; j++) {
				weight[j]+= W;
				max = Math.max(max, weight[j]);
			}
		}
		System.out.println(max);
	}
}