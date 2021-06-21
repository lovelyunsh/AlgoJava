package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2947나무조각 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[5];
		for(int i = 0 ; i < 5 ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean swap = true;
		ArrayList<String> result = new ArrayList<String>();
		while(swap) {
			swap = false;
			for(int i = 0 ; i < 4 ; i++) {
				if(arr[i] > arr[i+1]) {
					arr[i] = arr[i+1] ^ arr[i] ^(arr[i+1] = arr[i]);
					String S = "";
					for(int j = 0 ; j < 5 ; j++)
						S += arr[j] +" ";
					result.add(S);
					swap = true;
				}
			}
		}
		for(int i = 0 ; i < result.size() ; i++)
			System.out.println(result.get(i));
		
	}

}
