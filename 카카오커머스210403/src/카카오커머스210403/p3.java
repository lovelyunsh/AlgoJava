package 카카오커머스210403;

import java.util.ArrayList;

public class p3 {
	
	
	static int N;
	static ArrayList<Integer>[] list;
	static int [] answer;
	static boolean [] visit;
	static int weight [];
    public int[] solution(int n, int[] passenger, int[][] train) {
        list = new ArrayList [n+1];
        answer = new int [2];
        visit = new boolean[n+1];
        weight = passenger;
        for(int i= 1 ; i < n+1 ; i++ )
        	list[i] = new ArrayList<Integer>();
        for(int[] i : train) {
        	list[i[0]].add(i[1]);
        	list[i[1]].add(i[0]);
        }
        visit[1] = true;
        dfs(1,weight[0]);
        
        return answer;
    }
    
    public static void dfs(int num,int cnt) {
    	boolean isgo = false;
    	for(int i : list[num]) {
    		if(visit[i])
    			continue;
    		isgo = true;
    		visit[i] = true;
    		dfs(i,weight[i-1]+cnt);
    		visit[i] = false;
    	}
    	if(!isgo) {
    		if(cnt > answer[1]) {
    			answer[0] = num;
    			answer[1] = cnt;
    		}else if(cnt == answer[1] && num > answer[0]) {
    			answer[0] = num;
    		}
    		
    	}
    	
    }

}
