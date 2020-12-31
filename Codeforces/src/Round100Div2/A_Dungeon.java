package Round100Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Dungeon {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.println(solve(a, b, c));
		}
	}

	static String solve(int a, int b, int c) {
		int sum = a + b + c;
		if (sum % 9 == 0 && a>= sum/9 && b >= sum/9 && c >= sum/9)
			return "YES";
		return "NO";
	}
}
