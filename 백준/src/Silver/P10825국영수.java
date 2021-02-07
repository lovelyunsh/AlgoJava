package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10825국영수 {
	static class person {
		String name;
		int guk;
		int yung;
		int su;

		public person(String name, int guk, int yung, int su) {
			this.name = name;
			this.guk = guk;
			this.yung = yung;
			this.su = su;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		person arr[] = new person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		merge_sort(arr, 0, arr.length - 1);
		StringBuilder sb = new StringBuilder();
		for (person i : arr)
			sb.append(i.name + "\n");

		System.out.println(sb);
	}

	static void merge_sort(person arr[], int left, int right) {
		int mid;

		if (left < right) {
			mid = (left + right) / 2;
			merge_sort(arr, left, mid);
			merge_sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

	}

	static int compare(person a, person b) {
		if (a.guk < b.guk)
			return 1;
		else if (a.guk > b.guk)
			return -1;
		else {
			if (a.yung < b.yung)
				return -1;
			else if (a.yung > b.yung)
				return 1;
			else {
				if (a.su < b.su)
					return 1;
				else if (a.su > b.su)
					return -1;
				else {
					if (a.name.compareTo(b.name) <= 0)
						return -1;
					else
						return 1;
				}
			}
		}

	}

	static void merge(person arr[], int left, int mid, int right) {
		person sort[] = new person[right - left + 1];
		// 하나씩 비교
		int l = left;
		int r = mid + 1;
		int k = 0;
		while (l <= mid && r <= right) {
			int com = compare(arr[l], arr[r]);
			if (com < 0)
				sort[k++] = arr[l++];
			else
				sort[k++] = arr[r++];
		}
		// 남은 거 넣기
		if (l > mid)
			for (int i = r; i <= right; i++)
				sort[k++] = arr[i];
		else
			for (int i = l; i <= mid; i++)
				sort[k++] = arr[i];

		for (person i : sort)
			arr[left++] = i;
	}
}
