package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20159동작그만밑장빼기냐 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int map[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		int even[] = new int[N / 2];
		int odd[] = new int[N / 2];
		int preeven = 0, preodd = 0;
		for (int i = N - 1; i > 0; i--) {
			if (i % 2 == 0) {
				even[i / 2] = preeven + map[i];
				preeven = even[i / 2];
			} else {
				odd[i / 2] = preodd + map[i];
				preodd = odd[i / 2];
			}
		}
		int max = 0;
		int maxidx = -1;
		for (int i = 1; i <= N / 2; i++) {
			int swap = map[N] - map[i * 2 - 1] > 0 ? map[N] - map[i * 2 - 1] : 0;
			if (i == N / 2) {
				if (swap > max) {
					maxidx = 0;
				}
			} else if (even[i] - odd[i] + swap > max) {
				max = even[i] - odd[i] + swap;
				maxidx = i;
			}
		}
		int sum = 0;
		if (maxidx == 0) {
			for (int i = 1; i < N - 1; i += 2) {
				sum += map[i];
			}
			sum += map[N];
		} else if (maxidx > 0) {
			for (int i = 1; i < (maxidx - 1) * 2; i += 2) {
				sum += map[i];
			}
			sum += even[maxidx];
			if (map[maxidx * 2 - 1] > map[N])
				sum = sum + map[maxidx * 2 - 1];
			else
				sum += map[N];
		} else {
			for (int i = 1; i <= N; i += 2) {
				sum += map[i];
			}
		}
		System.out.println(sum);
	}

}
