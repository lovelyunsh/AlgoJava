package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1065한수 {

	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0 ;
		for(int i = 1 ; i<= N ; i++) {
			if(check(i)) {
				cnt++;
			}			
		}
		System.out.println(cnt);
		
	}
	static boolean check(int i) {
		int size = (int) Math.log10(i);
		
		if(size == 0 )
			return true;
		if(size == 1)
			return true;
		if(size == 3)
			return false;
		int arr[] = new int[size+1];
		for(int j = 0 ; j <= size ; j++) {
			arr[j] = i%10;
			i = i/10;
		}
		if((arr[1] - arr[0]) == (arr[2] - arr[1]))
			return true;
		return false;
	}
	
}
