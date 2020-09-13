package kakao;

public class kakao1 {
	public static void main(String[] args) {
		System.out.println(solution("abcdefghijklmn.p"));
	}

	static String solution(String new_id) {
		String answer = "";
		if (check(new_id))
			answer = new_id;
		else
			answer = change(new_id);

		return answer;
	}

	static boolean check(String id) {
		if (id.length() < 3 || id.length() > 15)
			return false;
		boolean iscontinue = false;
		for (char i : id.toCharArray()) {

			if (97 <= i && i <= 122)
				continue;
			if (48 <= i && i <= 57)
				continue;
			if (i == 45 || i == 95)
				continue;
			if (i == 46 && !iscontinue) {
				iscontinue = true;
				continue;
			}
			if (i != 46)
				iscontinue = false;
			return false;
		}
		return true;
	}

	static String change(String id) {
		StringBuilder temp = new StringBuilder(id);
		for (int i = 0; i < temp.length(); i++) { // 1단계
			if (65 <= temp.charAt(i) && temp.charAt(i) <= 90) {
				temp.insert(i, (char) (temp.charAt(i) + 32));
				temp.deleteCharAt(i + 1);
			}
		}
		for (int i = temp.length() - 1; i >= 0; i--) { // 2단계
			char target = temp.charAt(i);
			if (97 <= target && target <= 122)
				continue;
			if (48 <= target && target <= 57)
				continue;
			if (target == 45 || target == 95 || target == 46)
				continue;
			temp.deleteCharAt(i);
		}
		boolean iscontinue = false;
		for (int i = temp.length() - 1; i >= 0; i--) { // 3단계
			char target = temp.charAt(i);
			if (target != 46) {
				iscontinue = false;
				continue;
			}
			if (target == 46 && !iscontinue) {
				iscontinue = true;
				continue;
			}
			temp.deleteCharAt(i);
		}
		if (temp.length() != 0) {
			if (temp.charAt(0) == '.') // 4단계
				temp.deleteCharAt(0);
		}
		if(temp.length() != 0) {
		if (temp.charAt(temp.length() - 1) == '.')
			temp.deleteCharAt(temp.length() - 1);
		}
		if (temp.length() == 0) // 5단계
			temp.append('a');
		if(temp.length() > 15) {
			temp = new StringBuilder(temp.substring(0, 15)); // 6단계
		}
		if (temp.charAt(temp.length() - 1) == '.')
			temp.deleteCharAt(temp.length() - 1);

		char target = temp.charAt(temp.length() - 1);
		while (temp.length() <= 2) { // 7단계
			temp.append(target);
		}

		return new String(temp);
	}

}
