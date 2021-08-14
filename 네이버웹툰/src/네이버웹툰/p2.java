package 네이버웹툰;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p2 {

    public String[] solution(String s) {
        
        String post = "";
        String rear = "";
        List<String> answerList = new ArrayList<String>();
        Stack<String> rearStack = new Stack<String>();
        
        for(int i = 0 ; i< s.length()/2 ; i++) {
        	post = post + s.charAt(i);
        	rear = s.charAt(s.length()-i-1) + rear;
        	if(post.equals(rear)) {
        		answerList.add(post);
        		rearStack.push(rear);
        		post = "";
        		rear = "";
        	}
        }
        if(s.length()%2 == 1)
        	post+= s.length()/2;
        if(!post.equals(""))
        	answerList.add(post+rear);
        while(!rearStack.isEmpty())
        	answerList.add(rearStack.pop());
        String[] answer = new String [answerList.size()];
        for(int i = 0 ; i < answerList.size();i++)
        	answer[i] = answerList.get(i);
        
        return answer;
    }
}
