import java.util.Collections;
import java.util.LinkedList;

public class P42628이중우선순위큐2 {

    public int[] solution(String[] operations) {
    	LinkedList<Integer> deque = new LinkedList<Integer>();
    	
        for(String s : operations) {
        	String [] split = s.split(" ");
        	if(split[0].charAt(0) == 'I') {
        		deque.add(Integer.parseInt(split[1]));
        		Collections.sort(deque);
        	}else {
        		if(deque.isEmpty())
        			continue;
        		if(split[1].charAt(0) == '1') 
        			deque.pollLast();
        		else 
        			deque.pollFirst();
        	}
        }
        int max = 0;
        int min = 0;
        if(deque.isEmpty())
        	max = min = 0;
        else {
        	max = deque.peekLast();
        	min = deque.peekFirst();
        }
        	
        int[] answer = {max,min};
        return answer;
    }
    
}
