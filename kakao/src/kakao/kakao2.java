package kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class kakao2 {
	//모든 부분집합 비트마스크 배열 만들기
	//orders하나씩 빼서 부분집합 만들어서 배열에 +1씩 하기
	//가장 큰 숫자에 해당 하는 비트마스크 배열로 빼기
	//코스에 해당하면 집어넣고 만약 코스가 남았으면 다음 큰숫자 찾으러
	//돌면서 가장 큰 숫자였던 얘들은 0으로 바꿔주기
	static int [] powerset= new int [1<<26];
	static int preMax = 0;
    static String[] solution(String[] orders, int[] course) {
    	
        for(int i = 0 ; i < orders.length ; i++) {
        	makepowerset(orders[i]);
        }
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> cour = new ArrayList<Integer>();
        for(int i = 0 ; i < course.length ; i++) 
        	cour.add(course[i]);
        
        while(true) {
        	ArrayList<Integer> big = findBig();
        	ArrayList<Integer> deleteidx = new ArrayList<Integer>();
        	for(int i = 0 ; i < big.size() ; i++) {
        		String temp = bitToString(big.get(i));
        		for(int j = 0 ; j < cour.size() ; j++) {
        			if(temp.length() == cour.get(j)) {
        				if(!deleteidx.contains(j)) {
        					deleteidx.add(j);
        				}
        				result.add(temp);
        			}
        		}
        	}
        	for(int i = deleteidx.size()-1 ; i>=0 ; i--) {
        		cour.remove(deleteidx.get(i));
        	}
        	if(cour.size() == 0)
        		break;
        }
        
    	
    	
    	
    	String[] answer = new String [result.size()];
    	for(int i = 0 ; i < result.size() ; i++) {
    		answer[i] = result.get(i);
    	}
    	Arrays.sort(answer);
        return answer;
    }
    
    static void makepowerset(String target) {
    	int bitmask = 1;
    	while(bitmask == 1<<target.length()) {
    		int power = 0;
    		for(int i = 0 ; i < target.length() ; i++) {
    			if((bitmask & (1<<i)) == 1) {
    				power = power | (1<<(target.charAt(i) - 'A'));
    			}
    		}
    		powerset[power]++;
    		
    		bitmask++;
    	}
    }
    static ArrayList<Integer> findBig() {
    	int max = 0;
    	ArrayList<Integer> maxidx = new ArrayList<>();
    	System.out.println(powerset.length);
    	for(int i = 0 ; i < powerset.length ; i++) {
    		if(powerset[i] == preMax)
    			powerset[i] = 0;
    		if(max < powerset[i]) {
    			maxidx.clear();
    			max = powerset[i];
    			maxidx.add(i);
    		}
    		if(max == powerset[i])
    			maxidx.add(i);
    	}
    	preMax = max;
    	return maxidx;
    }
    
    static String bitToString(int bit) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < 26 ; i++) {
    		if((bit & (1<<i)) == 1) {
    			sb.append((char)(i+'A'));
    		}
    	}
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
    	String[] orders =  {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    	int[] course = {2,3,4};
    	System.out.println(solution(orders,course));
	}
    
	

}
