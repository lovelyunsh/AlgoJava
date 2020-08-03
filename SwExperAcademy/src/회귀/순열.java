package 회귀;

import java.util.Arrays;

public class 순열 {
	static int[] arr = { 1, 3, 5 };
	static boolean iselected[] = new boolean[arr.length];
	static int[] sel = new int[3];

	// idx번째에 대해서 어떤 숫자를 골라갖다 박을까..
	static void perm(int idx) {
		if (idx == 3) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		

		for(int i = 0 ; i < arr.length ; i++) {
			if (!iselected[i]) {
				iselected[i] = true;
				sel[idx] = arr[i];
				perm(idx + 1);
				iselected[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		perm(0);
	}
}
