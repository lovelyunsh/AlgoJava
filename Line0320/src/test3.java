import java.util.ArrayList;

class Solution3 {
    public int[] solution(int[] enter, int[] leave) {
    	boolean check [] = new boolean [enter.length+1];
    	int[] answer = new int [enter.length];
    	ArrayList<Integer> now = new ArrayList<Integer>();
    	int nowCnt = 0;
    	int enidx = 0;
    	int leidx = 0;
    	while(leidx < leave.length) {
    		if(check[leave[leidx]]) {
    			leidx++;
    			nowCnt--;
    		}else {
    			check[enter[enidx]] = true;
    			answer[enter[enidx++]] = nowCnt;
    			nowCnt++;
    		}
    	}
    	
    	
        return answer;
    }
    
    
    
}