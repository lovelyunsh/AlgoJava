
public class P42862체육복 {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		int clothes[] = new int[31];
		for (int i : lost)
			clothes[i]--;
		for (int i : reserve)
			clothes[i]++;
		for (int i = 1; i < 31; i++) {
			if (clothes[i] == -1)
				if (clothes[i - 1] == 1)
					clothes[i - 1] = clothes[i] = 0;
				else if (clothes[i + 1] == 1)
					clothes[i + 1] = clothes[i] = 0;
				else
					answer--;
		}
		return answer;
	}

}
