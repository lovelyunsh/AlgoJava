package D3;

public class 부분집합의합 {
	static int[] arr;
	static boolean[] sel;
	static int N;
	static int max = 0;
	static void powerSet(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0 ; i < N ; i++) {
				if(sel[i])
					sum+= arr[i];
			}
			if(sum> max)
				max = sum;
			return;
		}
		sel[idx] = true;
		powerSet(idx +1);
		sel[idx] = false;
		powerSet(idx + 1);
	}
	
	public static void main(String[] args) {
		N=3;
		arr = new int[N];
		sel = new boolean[N];
		
		powerSet(0);
		System.out.println(max);
	}

}
