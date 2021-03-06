package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G3_1941소문난칠공주 {
	static char map[][] = new char[5][5];
	static int result;
	static int sel[] = new int [7];
	static void comb(int idx ,int selidx,int Y) {
		if(Y>3)
			return;
		if(selidx == 7) {
			if(check()) {
				result++;
			}
			return;
		}
		if(idx == 25)
			return;
		
		sel[selidx] = idx;
		int isY = map[idx/5][idx%5] == 'Y'? 1 : 0;
		comb(idx+1,selidx+1,Y+isY);
		comb(idx+1,selidx,Y);
			
		
	}
	static boolean check() {
		//뭐든 요소가 연결되어있는지 확인
		boolean [] visit = new boolean [7];
		visit[0] =true;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(0);
		int cnt = 1;
		while(!que.isEmpty()) {
			int i = que.poll();
			for(int j = 0 ; j < 7 ; j++) {
				if(i==j || visit[j])
					continue;
				if(sel[i] % 5 == 0) // 가장 왼쪽 벽일때
					if(sel[i] - 1 == sel[j])
						continue;
				if(sel[i] % 5 == 4) //가장 오른쪽 벽일때
					if(sel[i] + 1 == sel[j])
						continue;
				if(sel[i] - 1 == sel[j] || sel[i] + 1 == sel[j] || sel[i]+5 == sel[j] || sel[i] - 5 == sel[j]) {
					que.offer(j);
					visit[j] = true;
					cnt++;
				}
			}
		}
		if(cnt != 7) //연결이 하나라도 안되어있으면
			return false;
		
		return true; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		comb(0,0,0);
		System.out.println(result);
		
	}
}
