package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P4659비밀번호발음하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if (s.equals("end"))
				break;
			sb.append(check(s));
		}
		System.out.println(sb);
	}

	static String check(String s) {
		boolean isAeiou = false;
		boolean can = true;
		char lastC = '1';
		int conJa = 0;
		int conMo = 0;
		char[] mo = { 'a', 'e', 'i', 'o', 'u' };
		for (char i : s.toCharArray()) {
			boolean isMo = false;
			for (char m : mo)
				if (m == i) {
					isMo = true;
					break;
				}
			if (isMo) { // 모음
				isAeiou = true;
				conMo++;
				conJa = 0;
			} else { // 자음
				conJa++;
				conMo = 0;
			}
			if (lastC != 'e' && lastC != 'o' && lastC == i) {
				can = false;
				break;
			}
			
			if (conJa == 3 || conMo == 3) {
				can = false;
				break;
			}
			lastC = i;
		}
		String re = "<" + s + "> is ";
		if (!isAeiou || !can) {
			re += "not acceptable.";
		} else
			re += "acceptable.";
		re += "\n";
		return re;
	}

}
