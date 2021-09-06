
public class P42860조이스틱 {
	public static void main(String[] args) {
		System.out.println(solution("AABAAAAAAB"));
	}

	static public int solution(String name) {
		int answer = 0;
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
		}
		int move = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A')
				next++;
			int temp = next == name.length() ? i : i + name.length() - next + i;
			move = Math.min(move, temp);

		}
		answer += move;
		return answer;
	}
}
