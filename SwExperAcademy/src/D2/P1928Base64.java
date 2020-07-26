package D2;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class P1928Base64 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		Decoder de = Base64.getDecoder();
		for (int tc = 1; tc <= T; tc++) {
			String input = sc.next();
			String result = new String(de.decode(input));
			System.out.printf("#" + tc + " " + result);
			System.out.println();
		}
	}

}
