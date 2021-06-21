import java.util.ArrayList;
import java.util.HashMap;

class Solution2 {
    public int[] solution(String inp_str) {
        int[] answer = check(inp_str);
        return answer;
    }
    public int[] check(String inp_str) {
    	//1 길이
    	//2 문자 종류
    	//3 종류의 수
    	//4 연속 금지
    	//5 5개 포함 금지
    	boolean check[] = new boolean[6];
    	boolean checkThree[] = new boolean[5];
    	int threeCnt = 0;
    	char preChar = 0;
    	int continueCnt = 0;
    	HashMap<Character, Integer> charcount = new HashMap<Character, Integer>();
    	if(8<=inp_str.length() && inp_str.length()<=15)
    		check[1] = true;
    	check[2] = true;
    	check[4] = true;
    	check[5] = true;
    	
    	for(char c : inp_str.toCharArray()) {
    		if(check[2] == true || check[3] == false) {
    			String pattern = "~!@#$%^&*";
    			if('A'<=c && c <= 'Z') {
    				if(!checkThree[1]) {
    					checkThree[1] = true;
    					threeCnt++;
    				}
    			}
    			else if('a'<=c && c<= 'z') {
    				if(!checkThree[2]) {
    					checkThree[2] = true;
    					threeCnt++;
    				}
    			}
    			else if('0' <= c && c <= '9') {
    				if(!checkThree[3]) {
    					checkThree[3] = true;
    					threeCnt++;
    				}
    			}
    			else if(pattern.contains(c+"")) {
    				if(!checkThree[4]) {
    					checkThree[4] = true;
    					threeCnt++;
    				}
    			}
    			else check[2] = false;
    			
    			if(threeCnt >= 3)
    				check[3] = true;
    		}
    		if(check[4]) {
    			if(preChar == c) {
    				if(++continueCnt >=4)
    					check[4] = false;
    			}
    			else {
    				preChar = c;
    				continueCnt = 1;
    			}
    		}
    		
    		if(check[5]) {
    			if(charcount.get(c) == null)
    				charcount.put(c, 0);
    			int cnt = charcount.get(c)+1;
    			charcount.put(c, cnt);
    			if(cnt >=5)
    				check[5] = false;
    		}
    	}
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	for(int i = 1; i < 6 ; i++)
    		if(!check[i])
    			arr.add(i);
    	if(arr.size() == 0) 
    		return new int [] {0};
    	
    	int [] result = new int [arr.size()];
    	for(int i = 0 ; i < arr.size() ; i++)
    		result[i] = arr.get(i);
    		
    	return result;
    }
}