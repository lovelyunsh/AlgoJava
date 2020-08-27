package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931회의실배정 {
	public static class intcomp implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			int a = Integer.compare(o1[1], o2[1]);
			if(o1[1] == o2[1])
				return(Integer.compare(o1[0], o2[0]));
			return Integer.compare(o1[1], o2[1]);
		}

	}

	public static void main(String[] args) throws IOException , NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int time[][] = new int [N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time,new intcomp());
		int endtime = -1;
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(endtime <= time[i][0]) {
				endtime = time[i][1];
				cnt ++;
			}
		}
		System.out.println(cnt);
	}

}
