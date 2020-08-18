import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//static int dr[] = {1,0,-1,0};
//static int dc[] = {0,-1,0,1};


//for(int i = 0 ; i < 30 ; i++) {  //맵보기
//System.out.println();
//}
//System.out.println(row+" "+col);
//for(int i = 0 ; i < 5 ; i++) {
//for(int j = 0 ; j < 5 ; j++) {
//	System.out.print(visit[i][j] +" ");
//}
//System.out.println();
//}
//
//Thread.sleep(500);


public class basicform {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			// solving
			System.out.printf("#%d \n", tc);
		}
	}

}
