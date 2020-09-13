package kakao;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class kakao4 {
	//n 정점 갯수
	//s 출발점
	//a a도착점
	//b b도착점
	static class node implements Comparable<node>{
		int from;
		int to;
		int dist;
		public node(int from,int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	static int N;
	static ArrayList<node>[] nodelist; 
    static int solution(int n, int s, int a, int b, int[][] fares) {
    	nodelist = new ArrayList[n+1];
    	N = n;
        for(int i = 0 ; i < n+1 ; i++) {
        	nodelist[i] = new ArrayList<node>();
        }
        
        for(int i = 0 ; i < fares.length ;i++) {
        	int from = fares[i][0];
        	int to = fares[i][1];
        	int dist = fares[i][2];
        	nodelist[from].add(new node(from,to, dist));
        	nodelist[to].add(new node(to,from, dist));
        }
        int firstdist[] = djik(s);
        int result = firstdist[a]+firstdist[b];
        for(int i = 1 ; i <= N ; i++) {
        	if(i == s)
        		continue;
        	int dist[] = djik(i);
        	result = Math.min(result, firstdist[i]+dist[a]+dist[b]);
        }
        
        
    	int answer = result;
        return answer;
    }
	static int[] djik(int s) {
        PriorityQueue<node> que = new PriorityQueue<node>();
        int [] dist = new int[N+1];
        for(int i = 0 ; i < N+1 ; i++) {
        	dist[i] = Integer.MAX_VALUE;
        }
    	boolean visit [] = new boolean[N+1];
    	dist[s] = 0;
    	que.offer(new node(0,s, 0));
    	
    	while(!que.isEmpty()) {
    		node now = que.poll();
    		if(visit[now.to])
    			continue;
    		
    		visit[now.to] = true;
    		for(node i : nodelist[now.to]) {
    			que.offer(i);
    			if(dist[i.to] >dist[i.from]+i.dist)
    				dist[i.to] = dist[i.from]+i.dist;
    		}
    	}
    	return dist;
	}
	public static void main(String[] args) {
		int n = 7;
		int s = 1;
		int a = 2;
		int b = 3;
		int [][] fares ={{1, 2, 1}, {2, 3, 10}, {1, 3, 1}};
		System.out.println(solution(n, s, a, b, fares));
	}

}
