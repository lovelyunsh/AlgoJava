package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10158개미 {
	
	static int dr[] = {1,1,-1,-1};
	static int dc[] = {1,-1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q가 컬럼
		int p = Integer.parseInt(st.nextToken()); //p가 로우
		int t = Integer.parseInt(br.readLine());
		int direct = 0;
		boolean flag = false;
		int firstp = p;
		int firstq = q;
		
		for(int i = 1 ; i < t ; i++) {
			//가장 구석지 들어 갔을때
			if((p == H && q== W) || (p==H && q ==0) || (p==0 && q ==W) || (p==0 && q == 0)) {
				direct = (direct+2)%4; 
			}
			else if(q == W) {
				direct = direct == 0 ? 1: 2; //0은 1로 3은 2로
			}
			else if(p == H) {
				direct = direct == 1 ? 2: 3; //1은 2로 0은 3로
			}
			else if(q == 0) {
				direct = direct == 2 ? 3: 0; //2은 3로 1은 0로
			}
			else if(p == 0) {
				direct = direct == 3 ? 0: 1; //3은 0로 2은 1로
			}
			p = p+dr[direct];
			q = q+dc[direct];
			if(p == firstp && q == firstq && direct ==0) {
				flag = true;
				t = t%i;
				i = 1;
				continue;
			}
		}
		
		System.out.println(p+" "+q);
	}

}
