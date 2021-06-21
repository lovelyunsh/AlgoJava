package 요기요;

import java.util.HashMap;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution1 {
	public String solution(String S, String C) {
		String answer = new String();
		String company = "@" + C.toLowerCase() + ".com";
		String[] names = S.split("; ");
		
		HashMap<String, Integer> idStore = new HashMap<String, Integer>();
		
		for (int i = 0 ; i < names.length; i++) {
			String name = names[i];
			String id = getId(name);
			Integer num = idStore.get(id);
			if(num == null) 
				idStore.put(id, 1);
			else {
				idStore.put(id,num+1);
				id+= num+1;
			}
			if(i == names.length-1)
				answer += name+" <"+id+company+">";
			else
				answer += name+" <"+id+company+">; ";
		}
		return answer;
	}
	String getId(String name) { 
		String id = new String();
		String [] nameSplit = name.split(" ");
		id += nameSplit[0].toLowerCase()+".";
		String lastName = nameSplit[nameSplit.length-1].replace("-", "");
		if(lastName.length() > 8)
			lastName = lastName.substring(0, 8);
		id+= lastName.toLowerCase();
		return id;
	}
}
