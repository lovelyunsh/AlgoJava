package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P19535ㄷㄷㄷㅈ {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int parents [] = new int [N+1];
		int lineNum [] = new int [N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 0 ; i < N+1 ; i++)
			list[i] = new ArrayList<Integer>(); //부모 자식 짝맞추기 용
		
		for(int i = 0 ; i < N+1 ; i++)parents[i] = i;
		
		for(int i = 0 ; i < N-1 ; i++) {
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
			lineNum[start]++;
			lineNum[end]++;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(1);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i = 0 ; i < list[now].size(); i++) {
				int target = list[now].get(i);
				if(parents[now] == target)
					continue;
				parents[target] = now;
				que.offer(target);
			}
		}
		
		
		
		long E = 0; //ㄷ
		long W = 0; //ㅈ
		for(int i = 1 ; i < N+1 ; i++) {
			long myNum = lineNum[i];
			long parentNum = lineNum[parents[i]]; 
			if(myNum >= 3 ) W += myNum*(myNum-1)*(myNum-2)/1/2/3; //조합이야~~~
			if(parents[i] != i)E += (myNum-1) * (parentNum -1);
		}
		
		String result = "";
		if(E > W*3)result = "D";
		else if(E == W*3)result = "DUDUDUNGA";
		else if(E < W*3)result = "G";
		System.out.println(E+ " " + W);
		System.out.println(result);
	}

}
