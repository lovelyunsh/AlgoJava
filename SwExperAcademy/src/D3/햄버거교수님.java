package D3;

import java.util.Scanner;

public class 햄버거교수님 {
	//재귀함수에서 접근해야될 데이터...
	//N, L 그리고 크기 N의 칼로리 배열과 맛점수 배열, 그리고 정답을 저장할 변수
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;
	static boolean[] sel;
	//idx번째 원소를 고를건지 말건지?
	static void powerSet(int idx) {
		if( idx == N ) {
			int sumCal = 0;
			int sumScore = 0;
			//선택된 재료들에 대해서 칼로리, 점수의 각합을 구해보자.
			for(int i = 0 ; i < N ; i++) {
				if(sel[i]) {
					sumCal += cals[i];
					sumScore += scores[i];
				}
				
			}
			//다 더해봤을때 칼로리합이 L이하 인 것 중에서 sumScoredml 최대값을 기억하자.
			if(sumCal<L && sumScore > ans) {
				ans = sumScore;
			}
			
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1);
		sel[idx] = false;
		powerSet(idx+1);
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{
			//N 과 L이 입력되고 , 칼로리 , 맛점수가 입력됨
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			sel = new boolean[N];
			for(int i = 0 ; i < N ; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			ans = 0;
			powerSet(0);
			
			System.out.printf("#%d %d\n", tc ,ans);
		}
	}


}
