package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P5397키로거 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= test_case ; tc++) {
			String s = br.readLine();
			LinkedList<Character> map = new LinkedList<Character>();
			int cursor = 0;
			for(int i = 0 ; i < s.length() ; i++) {
				char now = s.charAt(i);
				if(now == '<') {
					cursor = cursor == 0 ? 0 : cursor-1; 
				}else if(now == '>') {
					cursor = cursor == map.size() ? cursor : cursor+1;
				}else if(now == '-') {
					if(cursor == 0)
						continue;
					map.remove(--cursor);
				}else {
					map.add(cursor++,now);
				}
			}
			StringBuilder sb = new StringBuilder();
			for(char i : map)
				sb.append(i);
			System.out.println(sb);
		}
		
		
	}

}
