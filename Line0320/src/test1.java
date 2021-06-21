import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Score implements Comparable<Score>{
	String name;
	int score;
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(Score o) {
		if(o.score == this.score)
			return this.name.compareTo(o.name);
		return o.score-this.score;
	}
}
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String, String []> map = getMap(table);
        ArrayList<Score> scoreList = getScore(map, languages, preference);
        answer = scoreList.get(0).name;
        return answer;
    }
    public HashMap<String, String []> getMap(String[] table){
    	StringTokenizer st;
        HashMap<String, String []> map = new HashMap<String, String[]>();
        for(String i : table) {
        	st = new StringTokenizer(i);
        	String [] language = new String[5];
        	String job = st.nextToken();
        	for(int j = 0 ; j < 5 ; j++)
        		language[j] = st.nextToken();
        	map.put(job, language);
        }
        return map;
    	
    }
    public ArrayList<Score> getScore( HashMap<String, String []> map,  String[] languages, int[] preference){
    	ArrayList<Score> scoreList = new ArrayList<Score>();
    	for(String key : map.keySet()) {
    		int score = 0;
    		String [] value = map.get(key);
    		for(int i = 0 ; i < value.length ; i++) {
    			String lang = value[i];
    			for(int j = 0 ; j < languages.length ; j++) {
    				if(lang.equals(languages[j])) 
    					score += (5-i) * preference[j];
    			}
    		}
    		scoreList.add(new Score(key, score));
    	}
    	Collections.sort(scoreList);
    	return scoreList;
    }
    
    
}
