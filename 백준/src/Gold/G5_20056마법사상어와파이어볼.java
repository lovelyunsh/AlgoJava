package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class G5_20056마법사상어와파이어볼 {
	static class fireball {
		int x;
		int y;
		int m;
		int s;
		int d;

		public fireball(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public fireball() {
		}

	}

	static int N, M, K;
	static ArrayList<fireball> firelist = new ArrayList<fireball>();
	static HashMap<Integer, List<fireball>> dupli = new HashMap<Integer, List<fireball>>();
	static int dir[][] = {{0,2,4,6},{1,3,5,7}};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			firelist.add(new fireball(x, y, m, s, d));
		}
		for (int i = 0; i < K; i++) {// simul
			move();
			fillList();
		}
		int result = 0;
		for(fireball f : firelist)
			result += f.m;
		System.out.println(result);
	}

	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static void move() {
		for(fireball now : firelist) {
			int row = now.x + dr[now.d] * now.s;
			int col = now.y + dc[now.d] * now.s;
			if (row < 0) {
				row = (N - (Math.abs(row) % N));
			}
			if (row >= N) {
				row = (row % N);
			}
			if (col < 0) {
				col = (N - (Math.abs(col) % N));
			}
			if (col >= N) {
				col = (col % N);
			}
			int key = row*1000+col;
			if(dupli.get(key) == null) {
				dupli.put(key, new ArrayList<fireball>());
			}
			dupli.get(key).add(new fireball(row, col, now.m, now.s, now.d));
		}
		firelist.clear();
	}
	
	static void fillList() {
		for(int key : dupli.keySet()) {
			List<fireball> nowlist = dupli.get(key);
			if(nowlist.size() == 1) {
				fireball now = nowlist.get(0);
				firelist.add(new fireball(now.x, now.y, now.m, now.s, now.d));
				continue;
			}
			fireball first = nowlist.get(0);
			boolean allsame = true;
			int x = first.x;
			int y = first.y;
			int firstd = first.d; 
			int sumM = first.m;
			int sumS = first.s;
			for(int i = 1 ; i < nowlist.size() ; i++) {
				fireball now = nowlist.get(i);
				sumM += now.m;
				sumS += now.s;
				if((firstd + now.d) %2 == 1) {
					allsame = false;
				}
			}
			sumM = sumM/5;
			sumS = sumS/nowlist.size();
			if(sumM == 0)
				continue;
			int d = allsame ? 0 : 1;
			for(int i = 0 ; i < 4 ; i++) {
				firelist.add(new fireball(x, y, sumM, sumS, dir[d][i]));
			}
			
		}
		dupli.clear();
	}

}
