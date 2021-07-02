package Round728Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_prettyPermutations {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String s = "";
			if (n % 2 == 0) {
				for (int i = 1; i < n; i++) {
					s += i%2==0?i-1:i+1;
					s += " ";
				}
				s+=n-1;
			}else {
				for(int i = 1 ; i < n-2 ; i++) {
					s += i%2 ==0 ? i-1: i+1;
					s+= " ";
				}
				s+= (n-1) +" "+ n+" "+(n-2);
			}
			s+="\n";
			sb.append(s);
		}
		System.out.println(sb);
	}

}
