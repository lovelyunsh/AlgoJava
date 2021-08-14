package 네이버웹툰;

import java.util.Arrays;
import java.util.Collections;

public class P1 {

	public int solution(int[] prices, int[] discounts) {
		int answer = 0;
		Integer[] pricesArr = new Integer[prices.length];
		Integer[] discountsArr = new Integer[discounts.length];
		for (int i = 0; i < prices.length; i++)
			pricesArr[i] = prices[i];
		for (int i = 0; i < discountsArr.length; i++)
			discountsArr[i] = discounts[i];
		Arrays.sort(pricesArr, Collections.reverseOrder());
		Arrays.sort(discountsArr, Collections.reverseOrder());

		for (int i = 0; i < pricesArr.length; i++) {
			int price = pricesArr[i];
			if (i < discountsArr.length)
				price = price / 100 * (100-discountsArr[i]);
			answer+=price;
		}
		return answer;
	}

}
