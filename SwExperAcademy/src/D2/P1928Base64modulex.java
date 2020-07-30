package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class P1928Base64modulex {

	public static String intTo6bit(int value) {
		String bit = "";
		for (int i = 0; i < 6; i++) {
			int namu = value % 2;
			value = value / 2;
			if (namu == 1)
				bit = "1" + bit;
			if (namu == 0)
				bit = "0" + bit;
		}

		return bit;

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			ArrayList<Byte> bytearr = new ArrayList();
			String valuebit = "";
			String input = sc.next();

			int value = 0;
			for (char i : input.toCharArray()) {// 6비트 짜리 값 획득
				if (i < '0')
					value = i == '+' ? 62 : 63;
				else if (i <= '9')
					value = i + 4;
				else if (i <= 'Z')
					value = i - 65;
				else if (i <= 'z')
					value = i - 71;
				valuebit = valuebit + intTo6bit(value);// 값을 6비트로 변환 뒤 쭉 이어붙이기

			}
			int cnt = 8;
			int bitarr[] = { 1, 2, 4, 8, 16, 32, 64, 128 }; 
			String result = "";
			char sum = 0;
			
			for (char i : valuebit.toCharArray()) { // char형 8비트 값으로 변환
				cnt--;
				if (i == '1')
					sum += bitarr[cnt];

				if (cnt == 0) {// 8비트 계산이 끝나면
					result = result + sum; //sum 값을 String에 붙여 문자 이어 붙임
					cnt = 8;
					sum = 0;
				}

			}

			System.out.printf("#%d "+ result, tc);
			System.out.println();
		}
	}

}
