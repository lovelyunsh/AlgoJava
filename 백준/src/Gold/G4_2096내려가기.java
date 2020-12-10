package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_2096내려가기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int maxdp [] = new int [3];
		int maxpre[] = new int [3];
		int mindp [] = new int[3];
		int minpre [] = new int[3];
		
		for(int i = 1 ; i < N+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int third = Integer.parseInt(st.nextToken());
			maxdp[0] = Math.max(maxpre[0]+first, maxpre[1]+first);
			maxdp[1] = Math.max(Math.max(maxpre[0]+second, maxpre[1]+second),maxpre[2]+second);
			maxdp[2] = Math.max(maxpre[1]+third, maxpre[2]+third);
			
			mindp[0] = Math.min(minpre[0]+first, minpre[1]+first);
			mindp[1] = Math.min(Math.min(minpre[0]+second, minpre[1]+second),minpre[2]+second);
			mindp[2] = Math.min(minpre[1]+third, minpre[2]+third);
			
			maxpre = maxdp.clone();
			minpre = mindp.clone();
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			max = Math.max(maxdp[i], max);
			min = Math.min(mindp[i], min);
		}
		System.out.println(max +" "+ min);
			
	}

}
