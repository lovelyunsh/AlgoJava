package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		for (int j = 0; j < K; j++) {
			sum += arr[j];
			end++;
		}
		int max = sum;
		while (end < N) {
			sum -= arr[start];
			start++;
			sum += arr[end];
			end++;
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

}
