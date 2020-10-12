package 쿠팡;

import java.util.HashMap;

public class 삼번 {
	
	public static void main(String[] args) {
		System.out.println(solution(3,new int [] {24,22,20,10,5,3,2,1}));
		
	}
	
	static int solution(int k , int [] score) {
		int answer = 0;
		int diff[] = new int [score.length];
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < score.length-1 ; i++) {
			diff[i] = score[i] - score[i+1];
			if(map1.get(diff[i])!= null)
				map1.put(diff[i], map1.get(diff[i])+1);
			else
				map1.put(diff[i],1);
			
		}
		for(Integer i : map1.keySet()) {
			if(map1.get(i) >= k) {
				for(int j = 0 ; j < score.length-1 ; j++) {
					if(diff[j] == i) {
						score[j] = -1;
						score[j+1] = -1;
					}
				}
			}
		}
		for(int i : score) {
			if(i != -1)
				answer++;
		}
		return answer;
	}

}
