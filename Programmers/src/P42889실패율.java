import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P42889실패율 {
	class st implements Comparable<st> {
		int num;
		double fail;

		public st(int num, double fail) {
			this.num = num;
			this.fail = fail;
		}

		@Override
		public int compareTo(st o) {
			if (this.fail == o.fail)
				return this.num - o.num;
			return Double.compare(o.fail, this.fail);
		}

	}

	public int[] solution(int N, int[] stages) {
		int[] stage = new int[N + 2];
		for (int i : stages)
			stage[i]++;
		int total = stage[N + 1];
		List<st> sta = new ArrayList<st>();
		for (int i = N; i > 0; i--) {
			total += stage[i];
			double a=0;
			if (total != 0)
				a = (double) stage[i] / total;
			
			sta.add(new st(i, a));
		}
		Collections.sort(sta);
		int[] answer = new int[sta.size()];
		for (int i = 0; i < sta.size(); i++)
			answer[i] = sta.get(i).num;

		return answer;
	}

}
