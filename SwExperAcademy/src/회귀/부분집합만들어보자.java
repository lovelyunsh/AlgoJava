package 회귀;

public class 부분집합만들어보자 {

	static int arr[] = { 1, 2, 3, 4 };
	static boolean check[];
	static int N;

	static void superSet(int idx) {
		if (idx == 4) {
			for (int i = 0; i < idx; i++)
				if (check[i])
					System.out.print(arr[i]);
			System.out.println();
			return;
		}

		check[idx] = true;
		superSet(idx + 1);
		check[idx] = false;
		superSet(idx + 1);

	}

	public static void main(String[] args) {

		N = arr.length;
		check = new boolean[N];
		superSet(0);

	}

}
