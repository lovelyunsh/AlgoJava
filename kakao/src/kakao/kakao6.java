package kakao;

import java.awt.Point;
import java.util.ArrayList;

public class kakao6 {
	
    static int solution(int[][] board, int r, int c) {
    	boolean [] visitcard = new boolean[8];
    	ArrayList<Point []> card = new ArrayList<Point[]>();
    	Point [] tempcard = new Point[8];
    	for(int i = 0 ; i < 4 ; i++) {
    		for(int j = 0 ; j < 4 ; j++) {
    			if(board[i][j] == 0)
    				continue;
    			if(!visitcard[board[i][j]]) {
    				tempcard[board[i][j]] = new Point(i,j);
    				visitcard[board[i][j]] = true;
    				continue;
    			}
    			Point a [] = new Point [2];
    			a[0] = tempcard[board[i][j]];
    			a[1] = new Point(i,j);
    			card.add(a);
    		}
    	}
    	arr = new int[card.size()];
    	for(int i = 1 ; i <= card.size(); i++) {
    		arr[i] = i;
    	}
    	iselected = new boolean[arr.length];
    	perm(0);
    	
    	
    	
        int answer = 0;
        return answer;
    }
    
	static int[] arr;
	static boolean iselected[] = new boolean[arr.length];
	static int[] sel = new int[3];

	static void perm(int idx) {
		if (idx == arr.length) {
			//check
			//break & plus cnt
			//find min cnt
			return;
		}
		

		for(int i = 0 ; i < arr.length ; i++) {
			if (!iselected[i]) {
				iselected[i] = true;
				sel[idx] = arr[i];
				perm(idx + 1);
				iselected[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		
		
	}

}
