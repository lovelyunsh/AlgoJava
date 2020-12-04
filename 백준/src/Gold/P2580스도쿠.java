package Gold;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2580스도쿠 {
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 9 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go();
		for(int i = 0 ; i < 9 ; i ++) {
			for(int j = 0 ; j < 9 ; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}
	static boolean go() { //백트
		Point myPoint = findzero();
		if(myPoint == null) {
			return true;
		}
		List<Integer> mycanlist = whatcan(myPoint.x,myPoint.y);
		
		if(mycanlist.size() == 0) {
			return false;
		}
		for(int i : mycanlist) {
			map[myPoint.x][myPoint.y] = i;
			if(go())
				return true;
		}
		map[myPoint.x][myPoint.y] = 0;
		return false;
	}
	
	static Point findzero() {
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				if(map[i][j] == 0)
					return new Point(i,j);
			}
		}
		return null;
	}
	
	static List<Integer> whatcan(int x ,  int y){ //현재 위치 가능한 숫자 찾기
		List<Integer> can = new ArrayList<Integer>();
		boolean [] ten = new boolean[10];
		
		for(int i = 0 ; i < 9 ; i++) {
			ten[map[x][i]] = true;
			ten[map[i][y]] = true;
		}
		int startx = x - x%3;
		int starty = y - y%3;
		for(int i = startx ; i <startx+3; i++) {
			for(int j = starty ; j < starty+3 ; j++) {
				ten[map[i][j]] = true;
			}
		}
		for(int i = 1 ; i < 10 ; i++) {
			if(!ten[i])
				can.add(i);
		}
		return can;
	}
	
	

}