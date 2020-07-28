package D4;

import java.util.Scanner;

public class P1210Ladder {
	static int ladderdown(int ladder[][]) {
		for(int i = 0 ; i < 100 ; i++) {
			if(ladder[0][i] == 1) {
				int nowi = i;
				int j = 1;
				boolean left = true;
				boolean right = true; 

				
				while(true) {
					if(right && nowi-1>=0 && ladder[j][nowi-1] == 1) {
						nowi = nowi-1;
						left = false;
						continue;
					}
					if(left &&nowi+1<100 && ladder[j][nowi+1] == 1) {
						nowi = nowi+1;
						right = false;
						continue;
					}
					left = true;
					right = true;
					j++;
					if(j == 99) {
						if(ladder[j][nowi] == 1)
							break;
						if(ladder[j][nowi] == 2)
							return i;
						return -1;
							
					}
					
					
					
				}
			}
		}
		
		
		return 0;
	}
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
	
		for(int tc = 1; tc <= T; tc++)
		{
			sc.nextInt();
			int [][] ladder = new int [100][100];
			for(int i = 0 ; i < 100 ; i++) 
				for(int j = 0 ; j < 100 ; j++)
					ladder[i][j] = sc.nextInt();
			int result = ladderdown(ladder);
			
			System.out.printf("#%d %d\n", tc, result );
		}
	}

}
