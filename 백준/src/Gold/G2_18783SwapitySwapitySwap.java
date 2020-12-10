package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G2_18783SwapitySwapitySwap {
	static int arr[],N,M,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for (int i = 1; i <= N; i++)
			arr[i] = i;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			reverse(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		boolean visit[] = new boolean [N+1];
		for(int i = 1 ; i <= N ; i++) {
			if(visit[i])
				continue;
			List<Integer> cycle = new ArrayList<Integer>();
			visit[i] = true;
			int num = arr[i];
			cycle.add(i);
			while(num != i) {
				visit[num] = true;
				cycle.add(num);
				num = arr[num];
			}
			int mod = K % cycle.size();
			for(int j = 0 ; j < cycle.size(); j++) {
				arr[cycle.get(j)] = cycle.get((j+mod)% cycle.size());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =1 ; i <= N ; i++) 
			sb.append(arr[i]+"\n");
		System.out.println(sb);
	}
	static void reverse(int start, int end) {
		for (; start < end; start++, end--)
			arr[start] = arr[end] ^ arr[start] ^ (arr[end] = arr[start]);
	}
}
