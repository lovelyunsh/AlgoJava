import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class basicform {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());
		

		for (int tc = 1; tc <= T; tc++) {
			// solving
			System.out.printf("#%d \n", tc);
		}
	}

}
