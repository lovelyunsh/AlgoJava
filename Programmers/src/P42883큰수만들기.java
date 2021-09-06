import java.util.Stack;

public class P42883큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < number.length(); i++) {
        	int num = Integer.parseInt(String.valueOf(number.charAt(i)));
        	while(k>0 && !stack.isEmpty() && stack.peek() < num) {
        		k--;
        		stack.pop();
        	}
        	stack.push(num);
        }
        while(k-- > 0)
        	stack.pop();
        while(!stack.isEmpty())
        	answer = stack.pop() + answer;
        return answer;
    }

}
