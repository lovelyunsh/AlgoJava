package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P3691컴퓨터조립 {

	static class product implements Comparable<product> {
		long price;
		long quality;

		public product(long price, long quality) {
			this.price = price;
			this.quality = quality;
		}

		@Override
		public int compareTo(product o) {
			return Long.compare(this.quality, o.quality);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			HashMap<String, List<product>> map = new HashMap<String, List<product>>();
			String firstKey = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				if (i == 0)
					firstKey = type;
				st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int quality = Integer.parseInt(st.nextToken());
				if (map.get(type) == null) {
					map.put(type, new ArrayList<product>());
				}
				map.get(type).add(new product(price,quality));
			}
			Collections.sort(map.get(firstKey));
			Map<Long, Long> dp = new LinkedHashMap<Long, Long>();
			for (product p : map.get(firstKey)) {
				dp.put(p.quality, p.price);
			}
			map.remove(firstKey);
			for (String type : map.keySet()) {
				Map<Long, Long> temp = new LinkedHashMap<Long, Long>();
				List<product> products = map.get(type);
				Collections.sort(products);
				for (product p : products) {
					long prePrice = Integer.MAX_VALUE;
					long preQuality = Integer.MAX_VALUE;
					boolean end = true;
					for (long dd : dp.keySet()) { // 안되면 2진 탐색 ㄱ
						
						if (p.quality < dd) {
							end = false;
							if (prePrice + p.price <= B) {
								if (temp.get(preQuality) != null && temp.get(preQuality) < prePrice + p.price) {
								} else {
									temp.put(preQuality, prePrice + p.price);
								}
							}
							if (p.price + dp.get(dd) <= B) {
								if (temp.get(p.quality) != null && temp.get(p.quality) < prePrice + p.price) {
								} else {
									temp.put(p.quality, prePrice + dp.get(dd));
								}
							}
							break;
						} // 마지막꺼 더해야대
						preQuality = dd;
						prePrice = dp.get(dd);
					}
					if(end) {
						if (prePrice + p.price <= B) {
							if (temp.get(preQuality) != null && temp.get(preQuality) < prePrice + p.price) {
							} else {
								temp.put(preQuality, prePrice + p.price);
							}
						}
					}
				}
				dp = temp;
			}
			long max = 0;
			for(long p : dp.keySet()) {
				max = Math.max(max, p);
			}
			System.out.println(max);

		}

	}
}