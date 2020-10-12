package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P16637괄호추가하기 {
	static StringBuilder sb = new StringBuilder();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		sb.append(br.readLine());
		dfs(0);
		System.out.println(max);
	}

	static void dfs(int arrow){
		if (arrow >= sb.length()) {
			max = Math.max(calc(sb.toString()), max);
			return;
		}

		if ('0' <= sb.charAt(arrow) && sb.charAt(arrow) <= '9' && arrow != sb.length()-1) {
			sb.insert(arrow, '(');
			sb.insert(arrow+4, ')');
			dfs(arrow + 5);// 긋고
			sb.deleteCharAt(arrow+4);
			sb.deleteCharAt(arrow);
			dfs(arrow + 1);// 안긋고
		} else {
			dfs(arrow + 1);
		}
	}

	static int calc(String s) {
		int result = 0;
		char mark = '+';
		for(int i = 0 ; i < s.length() ; i++) {
			char now = s.charAt(i);
			if(now == '(') {
				int a = Integer.parseInt(""+s.charAt(i+1));
				char c = s.charAt(i+2);
				int b = Integer.parseInt(""+s.charAt(i+3));
				
				result = get(result, mark, get(a,c,b));
				i = i + 4;
				continue;
			}
			if('*' <= now &&  now <= '/') {
				mark = now;
				continue;
			}
			if('0' <= now && now <= '9') {
				int back = Integer.parseInt(""+now);
				result = get(result,mark,back);
			}
			
		}
		return result;
	}
	static int get(int a , char Ellie, int b) {
		if(Ellie == '+')
			return a+b;
		else if(Ellie == '-')
			return a-b;
		else if(Ellie == '*')
			return a*b;
		return 0;
	}
}
