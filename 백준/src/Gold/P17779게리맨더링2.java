package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17779게리맨더링2 {
	static int N;
	static int map[][];
	static boolean visit[][];
	static int fullsum;
	static int min = 99999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				fullsum += map[i][j];
			}
		}

		for (int x = 0; x <= N - 2; x++) {
			for (int y = 1; y <= N - 1; y++) {
				make_section(x, y);
			}
		}
		
		System.out.println(min);
	}

	public static void make_section(int x, int y) {
		for (int d1 = 1; d1 < N - 1; d1++) {
			for (int d2 = 1; d2 < N - 1; d2++) {
				if (x + d1 + d2 >= N)
					break;
				if (y - d1 < 0 || y + d2 >= N)
					break;
				visit = new boolean[N][N];
				cutVisit(x, y, d1, d2);
				count(x, y, d1, d2);

			}
		}
	}

	public static void cutVisit(int x, int y, int d1, int d2) {
		for (int i = x, j = y; i <= x + d1; i++,j--)
				visit[i][j] = true;
		for (int i = x, j = y; i <= x + d2; i++,j++)
				visit[i][j] = true;
		for (int i = x + d1,j = y - d1; i <= x + d1 + d2; i++,j++)
				visit[i][j] = true;
		for (int i = x + d2,j = y + d2; i <= x + d1 + d2; i++,j--)
				visit[i][j] = true;

	}

	public static void count(int x, int y, int d1, int d2) {
		// 1 ->0 N -> N-1
		// 1번
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0;
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if(visit[i][j])
					break;
				num1 += map[i][j];
			}
		}
		for(int i = 0 ; i<= x+d2 ; i++) {
			for(int j = N-1 ; j >= y+1; j-- ) {
				if(visit[i][j])
					break;
				num2 += map[i][j];
			}
		}
		for(int i = x+d1 ; i < N ; i++) {
			for(int j = 0 ; j<y-d1+d2 ; j++) {
				if(visit[i][j])
					break;
				num3+= map[i][j];
			}
		}
		for(int i = x+d2+1 ; i < N ; i++) {
			for(int j = N-1 ; j>=y-d1+d2 ; j--) {
				if(visit[i][j])
					break;
				num4 += map[i][j];
			}
		}
		num5 = fullsum - num1 - num2 - num3 - num4;
		int arr [] = {num1,num2,num3,num4,num5};
		Arrays.sort(arr);
		int diff = arr[4]-arr[0];
		min = Math.min(diff, min);

	}
}
