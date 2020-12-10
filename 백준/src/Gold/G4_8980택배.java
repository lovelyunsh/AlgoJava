package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_8980택배 {
	static class pack implements Comparable<pack>{
		int from;
		int to;
		int amount;
		public pack(int from, int to, int amount) {
			this.from = from;
			this.to = to;
			this.amount = amount;
		}
		
		@Override
		public int compareTo(pack o) {
			return this.to - o.to;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		pack [] packs = new pack[M];
		int [] village = new int[N+1];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			packs[i] = new pack(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(packs);
		Arrays.fill(village, C);
		int packcnt = 0;
		for(int i = 0 ; i < M ; i++) {
			pack nowPack = packs[i];
			int min = nowPack.amount;
			for(int j = nowPack.from ; j < nowPack.to ; j++)
				min = Math.min(village[j],min);
			if(min == 0)
				continue;
			packcnt += min;
			for(int j = nowPack.from ; j< nowPack.to ; j++) {
				village[j] -= min;
			}
		}
		
		System.out.println(packcnt);
	}
}
