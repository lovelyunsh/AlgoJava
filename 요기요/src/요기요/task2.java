package 요기요;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution2 {
	public String solution(String S) {
		// write your code in Java SE 8
		String answer = "";
		int min = 99999;
		for (String target : S.split("\r\n")) {
			String[] targetSplit = target.split(" ");
			if(!tildeCheck(target))
				continue;
			if(!sizeCheck(targetSplit[1]))
				continue;
			if(!dateCheck(targetSplit[2]))
				continue;
			min = Math.min(min,targetSplit[3].lastIndexOf("."));
		}
		if(min == 99999)
			answer = "NO FILES";
		else
			answer += min;
		return answer;
	}
	boolean dateCheck(String date) {
		String dates[] = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
		if(year < 1990)
			return false;
		else if(year > 1990)
			return true;
		else {
			if(month < 2)
				return false;
			return true;
		}
	}
	boolean tildeCheck(String target) {
		if(target.charAt(target.length()-1) == '~')
			return true;
		return false;
	}
	boolean sizeCheck(String size) {
		char KMG = size.charAt(size.length()-1);
		if(KMG == 'G')
			return false;
		if(KMG == 'M') {
			int mega = Integer.parseInt(size.replace("M", ""));
			if(mega >= 14)
				return false;
		}
		return true;
	}

}
 