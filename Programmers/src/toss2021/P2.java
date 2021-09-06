package toss2021;

import java.util.ArrayList;
import java.util.HashMap;

public class P2 {
	
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        
        ArrayList<Integer> [] serverList = new ArrayList[servers];
        for(int i = 0 ; i < servers ; i++) serverList[i] = new ArrayList<Integer>();
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        int idx = 0;
        if(!sticky) {
        	for(int re : requests) {
        		serverList[idx].add(re);
        		idx = idx + 1 ==servers? 0 : idx+1; 
        	}
        }
        else {
        	for(int re : requests) {
        		if(mapping.containsKey(re)) 
        			serverList[mapping.get(re)].add(re);
        		else {
        			serverList[idx].add(re);
        			mapping.put(re, idx);
        			idx = idx + 1 ==servers? 0 : idx+1;
        		}
        	}
        }
        int answer [][] = new int [servers][serverList[0].size()];
        for(int i = 0 ; i < answer.length; i++) 
        	for(int j = 0 ; j < answer[i].length ; j++)
        		answer[i][j] = serverList[i].get(j);
        
        return answer;
    }

}
