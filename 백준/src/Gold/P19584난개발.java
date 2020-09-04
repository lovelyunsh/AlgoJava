package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P19584난개발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int height[] = new int[N + 1];
		long max = 0;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> hei = new ArrayList<Integer>();
		for(int i = 0 ; i < height.length ; i++) {
			hei.add(height[i]);
		}
		hei.remove(0);
		Collections.sort(hei);
		
		int temp = -1;
		for(int i = hei.size()-1 ; i >= 0 ; i--) {
			if(temp != hei.get(i)) {
				temp = hei.get(i);
				continue;
			}
			if(temp == hei.get(i))
				hei.remove(i);
		}
		long weight[] = new long[hei.size()];
		
		for (int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long W = Integer.parseInt(st.nextToken());
			if (height[start] > height[end])
				start = end ^ start ^ (end = start);
			start = hei.indexOf(height[start]);
			end = hei.indexOf(height[end]);
			for (int j = start; j < end; j++) {
				weight[j] += W;
				max = Math.max(max, weight[j]);
			}
		}
		System.out.println(max);
	}
}