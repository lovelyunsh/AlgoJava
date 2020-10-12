package 쿠팡;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 사번 {

	static String start;
	static String end;
	static HashMap<String, List<String>> map;
	static HashMap<String, Integer> count;

	public static void main(String[] args) {
		System.out.println(solution("SEOUL", "DAEGU", "YEOSU",
				new String[][] { { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" }, { "DAEJEON", "GWANGJU" },
						{ "SEOUL", "DAEJEON" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "DAEGU" }, { "GWANGJU", "BUSAN" },
						{ "DAEGU", "GWANGJU" }, { "DAEGU", "BUSAN" }, { "ULSAN", "DAEGU" }, { "GWANGJU", "YEOSU" },
						{ "BUSAN", "YEOSU" } }));

	}

	static int solution(String depar, String hub, String dest, String[][] roads) {
		map = new HashMap<String, List<String>>();
		count = new HashMap<String, Integer>();
		for (String[] a : roads) {
			if (map.get(a[0]) == null) {
				map.put(a[0], new ArrayList<String>());
				count.put(a[0], 0);
			}
			if (map.get(a[1]) == null) {
				map.put(a[1], new ArrayList<String>());
				count.put(a[1], 0);
			}
			map.get(a[1]).add(a[0]);
		}
		start = depar;
		end = hub;
		int deparTohub = dfs(end);
		for (String i : count.keySet()) {
			count.put(i, 0);
		}
		start = hub;
		end = dest;
		int hubTodest = dfs(end);

		return deparTohub * hubTodest;
	}

	static int dfs(String a) {
		if (a.equals(start)) {
			return 1;
		}
		if (count.get(a) != 0) {
			return count.get(a);
		}
		List<String> nodes = map.get(a);
		int cnt = 0;
		for (int i = 0; i < nodes.size(); i++) {
			String now = nodes.get(i);
			cnt += dfs(now);
		}
		count.put(a, cnt);
		return cnt;
	}

}
