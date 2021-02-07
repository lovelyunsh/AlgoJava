package noRank;

import java.util.Arrays;

public class 합병정렬 {

	public static void main(String[] args) throws Exception {
		int arr[] = {1,-1,2,3,10,5,7};
		merge_sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	static int compare(int a, int b) {
		if (a <= b)
			return -1;
		else
			return 1;
	}

	static void merge_sort(int[] arr, int left, int right) {
		int mid;

		if (left < right) {
			mid = (left + right) / 2;
			merge_sort(arr, left, mid);
			merge_sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int sort[] = new int[right - left +1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		// 하나 씩 비교
		while (i <= mid && j <= right) {
			int com = compare(arr[i], arr[j]);
			if (com < 0)
				sort[k++] = arr[i++];
			else
				sort[k++] = arr[j++];
		}
		//남은거 넣기
		if (i > mid)
			for (int l = j; l <= right; l++)
				sort[k++] = arr[l];

		else
			for (int l = i; l <= mid; l++)
				sort[k++] = arr[l];
		for(int l : sort)
			arr[left++] = l;
		
	}
}
