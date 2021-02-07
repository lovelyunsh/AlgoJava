package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20055컨베이어벨트위의로봇 {
	static int N,K;
	static int health[];
	static boolean robot[];
	static int cnt, Rbreak;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		health = new int[N*2];
		cnt = 0;
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N *2 ; i++)
			health[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			cnt++;
			rotate();
			robotmove();
			putonRobot();
			if(Rbreak >= K)
				break;
		}
		System.out.println(cnt);
		
		
		
	}
	
	static void rotate() {
		int pre = health[N*2-1];
		for(int i = 0 ; i < N*2 ; i++) {
			int now = health[i];
			health[i] = pre;
			pre = now;
		}
		for(int i = N-2 ; i >= 0 ; i--)
			robot[i+1] = robot[i];
		robot[0] = false;
		robot[N-1] = false;
	}
	static void robotmove() {
		for(int i = N-1 ; i >= 0 ; i-- ) {
			if(robot[i] && !robot[i+1] && health[i+1] != 0) {
				robot[i] = false;
				robot[i+1] = true;
				health[i+1] -=1;
				if(health[i+1] == 0)
					Rbreak++;
			}
		}
		robot[N-1] = false;
	}
	static void putonRobot() {
		if(health[0] != 0) {
			robot[0] = true;
			health[0]--;
			if(health[0] == 0)
				Rbreak++;
		}
	}
}
