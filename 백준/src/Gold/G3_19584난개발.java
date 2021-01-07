package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class G3_19584난개발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int numtoy[] = new int[N];
		TreeSet<Integer> mini = new TreeSet<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			numtoy[i] = Integer.parseInt(st.nextToken());
			mini.add(numtoy[i]);
		}
		
		ArrayList<Integer> miniset = new ArrayList<Integer>(mini);
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < miniset.size() ; i++)
			hashmap.put(miniset.get(i), i);
		
		long sum[] = new long[miniset.size()+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			long c = Long.parseLong(st.nextToken());
			int y1 = numtoy[u];
			int y2 = numtoy[v];
			y1 = hashmap.get(y1);
			y2 = hashmap.get(y2);
			if (y1 > y2)
				y1 = y2 ^ y1 ^ (y2 = y1);
			sum[y1] += c;
			sum[y2+1] -= c;
		}
		long max = sum[0];
		for(int i = 1 ; i < sum.length ; i++) {
			sum[i] += sum[i-1];
			max = Math.max(sum[i], max);
		}
		System.out.println(max);
	}

}
