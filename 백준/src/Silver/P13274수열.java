package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class P13274수열 {
	
	static int N,K;
	static long arr[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new long[N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = sc.nextLong();
		Arrays.sort(arr);
		for(int i = 0 ; i < K;i++) {
			int L = sc.nextInt() -1;
			int R = sc.nextInt()-1;
			long K = sc.nextLong();
			sort(L,R,K);
		}
		StringBuilder sb = new StringBuilder();
		for(long i : arr)
			sb.append(i+" ");
		System.out.println(sb);
		sc.close();

	}
	
	static void sort(int L,int R,long K) {
		int sub = R-L+1;
		long temp1 [] = new long[sub];
		long temp2 [] = new long[N-sub];
		int a = 0;
		int b = 0;
		for(int i = 0 ; i < N ; i++) {
			if(L <= i && i <= R)
				temp1[a++] = arr[i]+K;
			else
				temp2[b++] = arr[i];
		}
		a=0;
		b=0;
		int idx = 0;
		while(a< sub && b < N-sub) {
			if(temp1[a] < temp2[b])
				arr[idx++] =temp1[a++];
			else
				arr[idx++] = temp2[b++];
			
		}
		
		if(a == sub)
			for(int i = b ; i < N-sub ; i++ )
				arr[idx++] = temp2[i];
		else
			for(int i = a ; i < sub ; i++)
				arr[idx++] = temp1[i];
		
	}
}
