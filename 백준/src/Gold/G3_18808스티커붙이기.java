package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_18808스티커붙이기 {
	static int map[][], N, M, K, result;

	static boolean attach(int[][] sticker) {
		for (int i = 0; i < N - sticker.length + 1; i++) // 들어갈 수 있는 모든 점에 대해 검사하기
			for (int j = 0; j < M - sticker[0].length + 1; j++)
				if (check(sticker, i, j)) { // 모든 점중 한점에 대해 검사
					attachOne(sticker, i, j);
					return true;
				}

		return false;
	}

	static boolean check(int[][] sticker, int row, int col) { // 한점에 대해 겹치는 위치 없는지 확인
		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				if (sticker[i][j] == 1 && map[row + i][col + j] == 1)
					return false;
		return true;
	}

	static void attachOne(int[][] sticker, int row, int col) { // 조건에 부합하면 맵에 붙이기

		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				if (sticker[i][j] == 1) { // 붙이는게 스티커 부분이면 result +1
					map[row + i][col + j] = sticker[i][j];
					result++;
				}
	}

	static int[][] turn(int[][] sticker) { // 90도 회전
		int[][] newSticker = new int[sticker[0].length][sticker.length];

		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				newSticker[j][sticker.length - i - 1] = sticker[i][j];

		return newSticker;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int strow = Integer.parseInt(st.nextToken());
			int stcol = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[strow][stcol];
			for (int j = 0; j < strow; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < stcol; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int tu = 0; tu < 4; tu++) {
				if (attach(sticker)) //붙여 졌으면 종료
					break;
				
				sticker = turn(sticker); //안붙여졌으면 90도 돌려서 다시
			}
		}
		System.out.println(result);
	}

}
