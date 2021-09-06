import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P49189가장먼노드 {
	
    public int solution(int n, int[][] edge) {
    	ArrayList<Integer> [] arr = new ArrayList[n+1];
    	for(int i = 0 ; i <= n ; i++)
    		arr[i] = new ArrayList<Integer>();
    	for(int [] i : edge) {
    		arr[i[0]].add(i[1]);
    		arr[i[1]].add(i[0]);
    	}
    	boolean visit [] = new boolean[n+1];
    	Queue<Integer> que = new LinkedList<Integer>();
    	que.add(1);
    	visit[1] = true;
    	int size = 0;
    	while(!que.isEmpty()) {
    		size = que.size();
    		for(int i = 0 ; i < size ; i++) {
    			int now = que.poll();
    			for(int num : arr[now]) {
    				if(visit[num])
    					continue;
    				visit[num] =true;
    				que.add(num);
    			}
    		}
    	}
        return size;
    }
}
