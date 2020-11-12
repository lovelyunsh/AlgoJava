package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14698전생했더니슬라임연구자였던건에대하여 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder stb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long div = 1000000007;
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			long result = 1;
			while (pq.size() != 1) {
				long mul = (pq.poll() * pq.poll());
				pq.offer(mul);
				result = result *( mul % div ) % div;
			}
			stb.append(result +"\n");
		}
		System.out.println(stb);
	}

}
