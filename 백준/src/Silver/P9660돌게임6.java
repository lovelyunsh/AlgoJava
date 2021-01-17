package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9660돌게임6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long N = Long.parseLong(br.readLine());
		System.out.println(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");
	}

}
