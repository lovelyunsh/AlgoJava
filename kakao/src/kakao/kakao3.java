package kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class kakao3 {
	// cpp 1 , java 2, python 3
	// backend 1 , frontend 2
	// junior 1 , senior 2
	// chicken 1 , pizza 2
	static class person {
		int lang;
		int field;
		int carrer;
		int soulfood;
		int score;

		public person(int lang, int field, int carrer, int soulfood, int score) {
			this.lang = lang;
			this.field = field;
			this.carrer = carrer;
			this.soulfood = soulfood;
			this.score = score;
		}

	}

	static int[] solution(String[] info, String[] query) {
		ArrayList<person> personList = new ArrayList<person>();
		for (int i = 0; i < info.length; i++) {
			personList.add(make_info(info[i]));
		}
		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			answer[i] = filter(personList, query[i]);
		}
		return answer;
	}

	static person make_info(String info) {
		// cpp 1 , java 2, python 3
		// backend 1 , frontend 2
		// junior 1 , senior 2
		// chicken 1 , pizza 2
		String[] man = info.split(" ");
		int[] intman = new int[man.length];
		intman[0] = man[0].equals("cpp") ? 1 : man[0].equals("java") ? 2 : 3;
		intman[1] = man[1].equals("backend") ? 1 : 2;
		intman[2] = man[2].equals("junior") ? 1 : 2;
		intman[3] = man[3].equals("chicken") ? 1 : 2;
		intman[4] = Integer.parseInt(man[4]);

		return new person(intman[0], intman[1], intman[2], intman[3], intman[4]);
	}

	static int filter(ArrayList<person> personList, String query) {
		String[] Stringsubquery = query.split(" and ");
		int[] subquery = new int[query.length() + 1];
		String[] foodScore = Stringsubquery[3].split(" ");
		int cnt = 0 ;
		if (Stringsubquery[0].equals("-"))
			subquery[0] = 0;
		else
			subquery[0] = Stringsubquery[0].equals("cpp") ? 1 : Stringsubquery[0].equals("java") ? 2 : 3;
		if (Stringsubquery[1].equals("-"))
			subquery[1] = 0;
		else
			subquery[1] = Stringsubquery[1].equals("backend") ? 1 : 2;
		if (Stringsubquery[2].equals("-"))
			subquery[2] = 0;
		else
			subquery[2] = Stringsubquery[2].equals("junior") ? 1 : 2;
		if (foodScore[0].equals("-"))
			subquery[3] = 0;
		else
			subquery[3] = foodScore[0].equals("chicken") ? 1 : 2;
		subquery[4] = Integer.parseInt(foodScore[1]);

		for (int i = personList.size() - 1; i >= 0; i--) {
			if (!(subquery[0] == 0)) {
				if (!(personList.get(i).lang == subquery[0])) {
					continue;
				}
			}
			if (!(subquery[1] == 0)) {
				if (!(personList.get(i).field ==subquery[1])) {
					continue;
				}
			}
			if (!(subquery[2] == 0)) {
				if (!(personList.get(i).carrer == subquery[2])) {
					continue;
				}
			}
			if (!(subquery[3] == 0)) {
				if (!(personList.get(i).soulfood == subquery[3])) {
					continue;
				}
			}
			if (personList.get(i).score < subquery[4]) {
				continue;
			}
			cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
	}
}
