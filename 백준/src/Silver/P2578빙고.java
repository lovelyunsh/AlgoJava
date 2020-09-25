package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2578빙고 {
	
	static int map[][];
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//1~25
		map  = new int [5][5];
		for(int i = 0 ; i < 5 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int turn = 0;
		gg:for(int i = 0 ; i < 5 ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++) {
				change(Integer.parseInt(st.nextToken()));
				turn++;
				if(count >= 3) {
					break gg;
				}
			}
		}
		System.out.println(turn);
		
	}
	

	static void change(int num) {
		gg:for(int i = 0 ; i < 5 ; i++) {
			for(int j =0 ; j < 5 ; j++) {
				if(map[i][j] == num) {
					map[i][j] = 0;
					checkbingo(i,j);
					break gg;
				}
			}
		}
	}
	static void checkbingo(int i , int j) {
		boolean flag = false;
		for(int a = 0 ; a < 5 ; a ++) {
			if(map[a][j] != 0) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			count++;
		}
		flag = false;
		
		for(int a = 0 ; a < 5 ; a++) {
			if(map[i][a] != 0) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			count++;
		}
		flag = false;
		if(i == j) {
			for(int a = 0, b = 0 ; a < 5 ; a++,b++) {
				if(map[a][b] != 0) {
					flag = true;
					break;
				}
			}
		}
		else
			flag = true;
		if(!flag) {
			count++;
		}
		flag = false;
		if(i == 4-j) {
			for(int a = 0, b = 4 ; a < 5 ; a++,b--) {
				if(map[a][b] != 0) {
					flag = true;
					break;
				}
			}
		}
		else
			flag = true;
		if(!flag) {
			count++;
		}
		
	}
	
}
