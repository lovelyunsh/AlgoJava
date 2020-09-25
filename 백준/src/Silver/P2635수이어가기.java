package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2635수이어가기 {
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int resultnum = 0;
		for(int i = 0 ; i <= N ; i++) {
			int num = count(N,i);
			if(result < num) {
				result = num;
				resultnum = i;
			}
		}
		System.out.println(result);
		System.out.print(N+" "+resultnum+" ");
		while(true) {
			int temp = N-resultnum;
			if(temp < 0)
				break;
			System.out.print(temp+" ");
			N = resultnum;
			resultnum = temp;
		}
	}
	
	static int count(int N, int k) {
		int cnt = 2;
		
		while(true) {
			int temp = N-k;
			if(temp < 0)
				break;
			N = k;
			k = temp;
			cnt++;
		}
	
		
		return cnt;
		
	}

}
