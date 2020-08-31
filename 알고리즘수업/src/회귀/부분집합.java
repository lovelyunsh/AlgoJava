package 회귀;

public class 부분집합 {
	static int[] arr = {1,3,5};
	static boolean[] sel = new boolean[3];
	
	static void powerSet(int idx) {
		
		if(idx == arr.length) {
			for(int i = 0 ; i < arr.length ; i++) {
				if(sel[i])
					System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx + 1);
		
					
					
	}
	public static void main(String[] args) {
		powerSet(0);
	}	
}
