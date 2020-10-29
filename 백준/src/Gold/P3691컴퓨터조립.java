package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
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
			return Long.compare(this.price, o.price);
		}
	}
	static class sProduct implements Comparable<sProduct>{
		long price;
		long quality;
		String type;
		public sProduct(long price, long quality, String type) {
			super();
			this.price = price;
			this.quality = quality;
			this.type = type;
		}
		@Override
		public int compareTo(sProduct o) {
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
			Map<String, PriorityQueue<product>> map = new HashMap<String, PriorityQueue<product>>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				st.nextToken();
				long price = Long.parseLong(st.nextToken());
				long quality = Long.parseLong(st.nextToken());
				if (map.get(type) == null) {
					map.put(type, new PriorityQueue<product>());
				}
				map.get(type).offer(new product(price,quality));
			}
			//젤 싼 부품들로 일단 만들고
			//퀄리티 젤 낮은 얘들만 꺼내서 젤 싼 부품 꺼내서 퀄리티 올리기
			//하나라도 더 이상 꺼낼게 없거나 가격이 안맞으면 끝 
			long quality = Long.MAX_VALUE;
			long price = 0;
			PriorityQueue<sProduct> selected = new PriorityQueue<sProduct>();
			for(String type : map.keySet()) {
				product cheap = map.get(type).poll();
				price += cheap.price;
				quality = Math.min(quality, cheap.quality);
				selected.offer(new sProduct(cheap.price, cheap.quality, type));
			}
			long result = 0;
			while(true) {
				sProduct now = selected.poll();
				boolean canChange = false;
				product change = null;
				while(true) { //능력 더 좋은 놈 뽑기
					if(map.get(now.type).isEmpty())
						break;
					change = map.get(now.type).poll();
					if(change.quality<= now.quality)
						continue;
					if(price - now.price + change.price > B)
						break;
					canChange = true;
					break;
				}
				if(canChange) {
					price = price - now.price + change.price;
					selected.offer(new sProduct(change.price, change.quality, now.type));
				}
				else {
					result = now.quality;
					break;
				}
			}
			System.out.println(result);
			
			
		}

	}
}