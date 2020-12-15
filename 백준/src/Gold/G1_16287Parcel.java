package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_16287Parcel {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		boolean sum[] = new boolean[400001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean ok = false;
		
		gg:for(int i = 0 ; i < N ; i++) {
			for(int j = i+1 ; j < N ; j++) {
				int now = arr[i] + arr[j];
				if(now >= W || W- now > 400000 )
					continue;
				if(sum[W-now]) {
					ok = true;
					break gg;
				}
			}
			for(int j = 0 ; j < i ; j++)
				sum[arr[i]+arr[j]] = true;
		}
		System.out.println(ok?"YES":"NO");
	}

}
