package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//실패 ;;

public class P18443우체국2 {
	static long L,arr[],dist[];
	static List<Long> mail;
	static int V,P;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		mail = new ArrayList<Long>();
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		arr = new long[V];
		dist = new long[V];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.fill(dist, Long.MAX_VALUE);
		
		for(int i = 0 ; i < P ; i++) {
			mail.add(arr[findMail()]);
		}
		long sum = 0;
		for(int i = 0 ; i < V ; i++)
			sum += dist[i];
		Collections.sort(mail);
		System.out.println(sum);
		for(long i : mail)
			System.out.print(i+" ");
	}
	static int findMail() {
		long min = Long.MAX_VALUE;
		int minidx = 0;
		long maxdist = 0;
		for(int i = 0 ; i < V; i++ ) { //i에 설치
			long diff = 0;
			long nowmaxdist = 0;
			for(int j = 0 ; j < V ; j++) {
				long nowdist = Math.min(dist[j], Math.min(Math.abs(arr[i] - arr[j]), L-Math.abs(arr[i] - arr[j])));
				nowmaxdist = Math.max(nowmaxdist, nowdist);
				diff += nowdist;
			}
			if(diff<min || (diff == min && nowmaxdist<maxdist)) {
				min = diff;
				minidx = i;
				maxdist = nowmaxdist;
			}
			
		}
		dist[minidx] = 0;
		for(int i = 0 ; i < V ; i++) {
			long diff = Math.min(dist[i], Math.min(Math.abs(arr[i] - arr[minidx]), L-Math.abs(arr[i] - arr[minidx])));
			dist[i] = diff;
		}
		return minidx;
	}

}
