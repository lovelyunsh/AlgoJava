package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G2_14725개미굴 {
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N;
		TreeMap<String, TreeMap > map = new TreeMap<>();
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i< N ; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			TreeMap target = map;
			for(int j = 0 ; j < n ; j++) {
				String name = st.nextToken();
				if(target.get(name) == null)
					target.put(name, new TreeMap<>());
				target = (TreeMap)target.get(name);
			}
		}
		getresult(map,0);
		System.out.println(result);
	}
	static void getresult(TreeMap map,int n) {
		
		for(Object s : map.keySet()) {
			for(int i = 0 ; i < n ; i++)
				result.append("--");
			result.append(s + "\n");
			getresult((TreeMap)map.get(s),n+1);
		}
	}

}
