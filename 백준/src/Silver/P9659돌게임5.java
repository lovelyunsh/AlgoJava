package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9659돌게임5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long N = Long.parseLong(br.readLine());
		System.out.println(N % 2 == 0 ? "CY" : "SK");
	}

}
