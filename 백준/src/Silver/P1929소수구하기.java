package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929소수구하기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean eratos[] = new boolean[N + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < N + 1; i++) {
			if (eratos[i])
				continue;
			if (M <= i)
				sb.append(i + "\n");
			if (i < 1001) {
				for (int j = i * i; j < N + 1; j += i)
					eratos[j] = true;
			}
		}
		System.out.print(sb);
	}
}
