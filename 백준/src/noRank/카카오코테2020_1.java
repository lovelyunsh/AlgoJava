package noRank;

public class 카카오코테2020_1 {
	public static int solution(String s) {
		int min = s.length();
		for (int len = 1; len <= s.length() / 2; len++) {// 1~ N/2 개까지의 len에 대해
			StringBuilder ss = new StringBuilder();
			String target = "";
			int start = 0;
			while (true) {
				if (start + len > s.length())
					break;
				target = s.substring(start, start + len);
				int cnt = 1;
				while (true) {// 지금 타겟 글자가 몇번 반복되는지
					if (start + len * 2 > s.length()) {
						break;
					}
					if (target.equals(s.substring(start + len, start + len * 2))) {
						cnt++;
						start = start + len;
					} else {
						break;
					}
				}
				if (cnt != 1)
					ss.append(cnt);

				ss.append(target);
				start = start + len;
			}
			ss.append(s.substring(start));
			min = Math.min(min, ss.length());
		}
		int answer = min;
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution("a"));
	}
}
