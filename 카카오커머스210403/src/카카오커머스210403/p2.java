package 카카오커머스210403;

public class p2 {
	
	static int needsArr[][];
	static int rNum;
	static boolean sel[];
	static int answer;
    public int solution(int[][] needs, int r) {
    	needsArr = needs;
    	rNum = r;
    	sel = new boolean [needs[0].length];
    	
    	comb(0,0);
        
        return answer;
    }
    public void comb(int idx, int selidx) {
    	if(selidx == rNum) {
    		score();
    		return;
    	}
    	if(idx == needsArr[0].length)
    		return;
    	sel[idx] = true;
    	comb(idx+1,selidx+1);
    	sel[idx] = false;
    	comb(idx+1,selidx);
    	
    	
    }
    public void score() {
    	int cnt = 0;
    	for(int i = 0 ; i < needsArr.length ; i++) {
    		boolean isMake = true;
    		for(int j = 0 ; j < needsArr[0].length; j++) {
    			if(needsArr[i][j] == 1 && sel[j] == false) {
    				isMake = false;
    				break;
    			}
    		}
    		if(isMake)
    			cnt++;
    	}
    	answer = Math.max(cnt, answer);
    	
    }

}
