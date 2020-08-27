package Silver;
import java.util.Scanner;

public class P15649N과M1 {
	static int N;
	static int numarr[];
	static StringBuilder s = new StringBuilder();
	static int sel[];
	static boolean check[];
	static int M;
	
	static void NandM(int idx) {
		if(idx == M) {
			for(int i = 0 ; i < M ; i++) {
				s.append(sel[i] + " ");
			}
			s.append("\n");
			return;
		}
		for(int i = 0 ; i < N ; i++ ) {
			if(!check[i]) {
				check[i] = true;
				sel[idx] = numarr[i];
				NandM(idx+1);
				check[i] = false;
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		M = sc.nextInt();
		numarr = new int [N];
		sel = new int [N];
		check = new boolean[N];
		for(int i = 0 ; i < N ; i++) 
			numarr[i] = i+1;
			
		NandM(0);
		System.out.println(s);
		
		
	}

}
