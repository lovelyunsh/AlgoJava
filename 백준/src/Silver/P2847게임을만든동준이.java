package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2847게임을만든동준이 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr []= new int [N];
		
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = N-1 ; i > 0 ; i--) {
			if(arr[i-1] >= arr[i]) {
				cnt += arr[i-1] - arr[i] +1;
				arr[i-1] = arr[i]-1;
			}
		}
		System.out.println(cnt);
	}

}
