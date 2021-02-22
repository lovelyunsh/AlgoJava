package Silver;

import java.util.HashMap;
import java.util.Scanner;

public class P1270전쟁땅따먹기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< N ; i++) {
			int n = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			boolean flag= true;
			for(int j = 0 ; j < n ; j++) {
				int num = sc.nextInt();
				if(map.get(num)== null)
					map.put(num, 0);
				map.put(num,map.get(num)+1);
				if(map.get(num) == n/2+1) {
					sb.append(num+"\n");
					flag = false;
					
				}
			}
			if(flag)
				sb.append("SYJKGW\n");
			
		}
		System.out.println(sb);
	}
}
