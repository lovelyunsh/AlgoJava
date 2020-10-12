package 쿠팡;

public class 일번 {
	
	public static void main(String[] args) {
	}
	
	public int[] solu(int N) {
		int max = 0;
		int maxjin = 0;
		
		for(int i = 2 ; i <=9 ; i++) {
			int nowgop = multi(N,i);
			if(nowgop >= max) {
				max = nowgop;
				maxjin = i;
			}
		}
		int [] answer = {maxjin,max};
		
		
		return answer;
	}
	public int multi(int N, int jin) {
		int gop = 1;
		while(N != 0) {
			if(N%jin != 0) {
				gop *= N%jin;
			}
			N /= jin;
		}
		return gop;
	}

}
