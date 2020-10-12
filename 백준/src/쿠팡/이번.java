package 쿠팡;

import java.util.*;

public class 이번 {
	public int solution(int n, String[] customers) {
		int[] count = new int[n];
		int[] time = new int[n];
		for (String cust : customers) {
			int sec = makeSec(cust);
			int min = Integer.MAX_VALUE;
			int minidx = 0;
			for (int i = 0; i < n; i++) {
				if (min > time[i]) {
					min = time[i];
					minidx = i;
				}
			}
			count[minidx]++;
			time[minidx] = sec;
		}
		int answer = 0;
		for (int i : count) {
			answer = Math.max(answer, i);
		}
		return answer;
	}

	static int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static int makeSec(String customer) {
		StringTokenizer st = new StringTokenizer(customer);
		String Month = st.nextToken();
		String time = st.nextToken();
		int useTime = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(Month, "/");
		int Mon = Integer.parseInt(st.nextToken());
		int Day = Integer.parseInt(st.nextToken());
		for (int i = 1; i < Mon; i++)
			Day += month[i];
		st = new StringTokenizer(time, ":");
		int Hour = Integer.parseInt(st.nextToken());
		int Min = Integer.parseInt(st.nextToken());
		int Sec = Integer.parseInt(st.nextToken());
		Hour += Day * 24;
		Min += Hour * 60;
		Min += useTime;
		Sec += Min * 60;
		return Sec;
	}
}