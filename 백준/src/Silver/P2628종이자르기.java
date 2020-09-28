package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2628종이자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> garo = new ArrayList<Integer>();
		List<Integer> sero = new ArrayList<Integer>();
		
		
		garo.add(Integer.parseInt(st.nextToken()));
		sero.add(Integer.parseInt(st.nextToken()));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int what = Integer.parseInt(st.nextToken());
			int where = Integer.parseInt(st.nextToken());
			if(what == 0) { // 가로
				int index;
				for(index = 0  ; where - sero.get(index)>0 ; index++ ) {
					where -= sero.get(index);
				}
				int temp = sero.remove(index);
				sero.add(index,temp-where);
				sero.add(index,where);
			}
			else { // 세로
				int index;
				for(index = 0  ; where - garo.get(index)>0 ; index++ ) {
					where -= garo.get(index);
				}
				int temp = garo.remove(index);
				garo.add(index,temp-where);
				garo.add(index,where);
			}
		}
		int max = 0;
		for(int i : garo) {
			for(int j : sero)
				max = Math.max(i*j, max);
		}
		System.out.println(max);
		
		
		
	}

}
