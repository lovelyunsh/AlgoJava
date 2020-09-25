package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2491수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int maxleft = 1;
		int leftcnt = 1;
		int maxright = 1;
		int rightcnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] <= arr[i]) {
				leftcnt++;
			} else {
				maxleft = Math.max(maxleft, leftcnt);
				leftcnt = 1;
			}
			if (arr[i - 1] >= arr[i]) {
				rightcnt++;
			} else {
				maxright = Math.max(maxright, rightcnt);
				rightcnt = 1;
			}
		}
		maxleft = Math.max(maxleft, leftcnt);
		maxright = Math.max(maxright, rightcnt);
		System.out.println(Math.max(maxright, maxleft));

	}
}
