package 네이버웹툰;

import java.util.Stack;

public class P3 {

	public int solution(String s, String t) {
		int result = 0;
		int tPoint = 0;
		boolean isPeek = false;
		Stack<Integer> postStack = new Stack<Integer>();
		for (char e : s.toCharArray()) {
			if (e == t.charAt(tPoint)) {
				tPoint++;
				if (tPoint == t.length()) {
					result++;
					if(isPeek)
						postStack.pop();
					tPoint = postStack.isEmpty() ? 0 : postStack.peek();
					isPeek = tPoint == 0 ? false:true;
				}
			} else {
				postStack.push(tPoint);
				isPeek = false;
				if(e == t.charAt(0))
					tPoint = 1;
				else {
					tPoint = 0;
					postStack.push(0);
				}
			} 
		}
		return result;
	}
}