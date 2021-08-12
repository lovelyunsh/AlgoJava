import java.util.HashMap;

public class P17685자동완성dfs {
	int answer = 0;

	public int solution(String[] words) {
		
		HashMap<Character, HashMap> hash = new HashMap();

		for (String s : words) {
			s += "E";
			HashMap<Character, HashMap>  targetHash = hash;
			for (char c : s.toCharArray()) {
				if (targetHash.get(c) == null)
					targetHash.put(c, new HashMap());
				targetHash =  targetHash.get(c);
			}
		}
		dfs(hash,1);
		return answer;
	}
	
	Boolean dfs(HashMap<Character, HashMap> hash,int depth) {
		int size = hash.size();
		if(size == 0) 
			return null;
		
		for(char c : hash.keySet()) {
			Boolean result =dfs(hash.get(c),depth+1);
			if(result == null) {
				if(size != 1)
					answer += depth-1;
				else
					return true;
			}
			else if(result&&size==1)
				return true;
			else if(result && size != 1)
				answer += depth;
		}
		return false;
	}
}

