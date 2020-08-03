package 스택;

import java.util.Stack;

public class StackAPItest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.size()+"//" +stack.isEmpty() );
		stack.push("이동욱");
		stack.push("이지아");
		stack.push("김태희");
		System.out.println(stack.size() +"//" + stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.size());
	}

}
