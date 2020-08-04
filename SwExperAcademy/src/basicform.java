import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class basicform {

	public static void main(String args[]) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(bf.readLine());
		

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine(), " ");
			// solving

			System.out.printf("#%d \n", tc);
		}
	}

}
