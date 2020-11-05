package noRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1163증가하는리스트 {
	
	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = 1;
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		gg:for(int i = 0 ; i < s.length() ; i++) {
			//내 숫자자리가 확보 되고 뒤가 숫자가 아니라면 넣고
			//숫자라면 내자리에 10000 때려넣고
			//확보가 안됐는데 숫자라면 1*000000 떄려넣고
			//?, 라면 1000000때려넣고
			char a = s.charAt(i);
			if(a == '?') {
				int size =(int)Math.log10(n);
				for(int j = 0 ; j < size ; j++) {
					if(i+j>= s.length() || s.charAt(i+j) == ',') {
						flag = false;
						break gg;
					}
					s.charAt(i+j);
				}
				
			}
			else {
			}
		}
		if(flag) {
			
		}else {
			System.out.println(-1);
		}
		
	}

}
