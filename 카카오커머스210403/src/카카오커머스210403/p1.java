package 카카오커머스210403;

import java.util.HashMap;

public class p1 {
	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[] { 5, 4, 5, 4, 5 }, new int[] { 1, 2, 3, 5, 4 }));
	}

	public static int solution(int[] gift_cards, int[] wants) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int get_cnt = 0;
		for (int i = 0; i < gift_cards.length; i++) {
			if (map.get(gift_cards[i]) == null)
				map.put(gift_cards[i], 0);
			map.put(gift_cards[i], map.get(gift_cards[i]) + 1);
		}

		for (int i = 0; i < wants.length; i++) {
			if (map.get(wants[i]) != null && map.get(wants[i]) > 0) {
				map.put(wants[i], map.get(wants[i]) - 1);
				get_cnt++;
			}
		}

		int answer = wants.length - get_cnt;
		return answer;
	}

}
