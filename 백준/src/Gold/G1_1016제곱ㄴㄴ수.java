package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_1016제곱ㄴㄴ수 {
	static long min,max;
	static int totalcnt;
	static int cnt;
	static boolean sqrtvisit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		totalcnt = (int)(max-min +1);
		sqrtvisit = new boolean[totalcnt];
		
		eratos((int) Math.sqrt(max));
		System.out.println(totalcnt-cnt);
	}

	static void eratos(int end) {
		boolean visit[] = new boolean[end + 1];
		for (int i = 2; i <= end; i++) {
			if (!visit[i]) {
				eratossqrt(i);
				for (long j = 1L*i * i; j <= end; j += i)
					visit[(int)j] = true;
			}

		}
	}
	
	static void eratossqrt(int num) {
		long numgop = 1L*num*num;
		long start = 0 ;
		if(min%numgop == 0)
			start = 0;
		else
			start =1L*numgop *((min /numgop)+1)-min;

		for(long i = start ; i < totalcnt ; i += numgop) {
			if(!sqrtvisit[(int)i]) {
				cnt++;
				sqrtvisit[(int)i] = true;
			}
		}
	}
}

