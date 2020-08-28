package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15961회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int roll [] = new int [N];
		for (int i = 0; i < N; i++)
			roll[i] = Integer.parseInt(br.readLine());
		
		int check [] = new int [d+1];
		int start = 0;
		int end = k-1;
		int cnt = 0;
		
		for(int i = start ; i <= end ; i++) {
			if(check[roll[i]] == 0)
				cnt++;
			check[roll[i]]++;
		}
		if(check[c] == 0)
			cnt++;
		
		int max = cnt;
		for (int i = 0; i < N - 1; i++) {
			//start 하나 빼고 end하나 넣고
			check[roll[start]]--;
			if(roll[start] == c && check[c] ==0) {
				
			}
			else if(check[roll[start]] == 0)
				cnt--;
			start = (start+1)%N;
			end = (end + 1)%N;
			check[roll[end]]++;
			if(roll[end] == c && check[c] == 1) {
				
			}
			else if(check[roll[end]] == 1)
				cnt++;
			max = Math.max(max, cnt);
		}
		System.out.println(max);

	}

}
