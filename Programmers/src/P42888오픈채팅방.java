import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P42888오픈채팅방 {
	

    public String[] solution(String[] record) {
        
        HashMap<String, String> nickMap = new HashMap<String, String>();
        for(String r : record) {
        	String [] re = r.split(" ");
        	if(re[0].charAt(0) != 'L')
        		nickMap.put(re[1], re[2]);
        }
        List<String> resultList = new ArrayList<String>(); 
        for(String r : record) {
        	String [] re = r.split(" ");
        	if(re[0].charAt(0) == 'E')
        		resultList.add(nickMap.get(re[1]) +"님이 들어왔습니다.");
        	if(re[0].charAt(0) == 'L')
        		resultList.add(nickMap.get(re[1]) +"님이 나갔습니다.");
        	
        }
        String[] answer = (String[]) resultList.toArray(new String[0]);
        
        
        return answer;
    }

}
