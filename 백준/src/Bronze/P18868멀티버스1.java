package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18868멀티버스1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //학급의 수
		int N = Integer.parseInt(st.nextToken()); //학생의 수
		
		int score [][] = new int [M][N]; //학생들의 점수 저장
		char [][] compare = new char [M][N*(N-1)/2]; // 각 학급 학생들 점수 비교 상태 저장 M * comb(n,2) 만큼 필요 최대 49500개
		
		for(int i = 0 ; i < M ; i++) { // i번째 학급의
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) { // j번째 학생
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int Class = 0 ; Class < M ; Class ++ ) { //각 학급에 대해
			int cnt = 0;
			for(int i = 0 ; i < N-1 ; i++) {     //for문 2개로 학생 2명 짝짓는 comb(n,2) 경우 다 구하기
				for(int j = i+1 ; j < N ; j++ ) {
					if(score[Class][i] > score[Class][j]) // Class학급의 i번째 학생과 j번째 학생의 점수 비교가 > 이면
						compare[Class][cnt++] = '>';       // 해당 상태에 > 저장
					else if(score[Class][i] < score[Class][j]) // 점수 비교가 < 이면
						compare[Class][cnt++] = '<';			 // 해당 상태에 < 저장
					else if(score[Class][i] == score[Class][j]) // 점수 비교가 == 이면
						compare[Class][cnt++] = '=';             // 해당 상태에 = 저장
				}
			}
		}
		
		
		int result = 0 ;
		for(int i = 0 ; i < M - 1 ; i ++) { // 각 학급에 대해
			for(int j = i+1 ; j < M ; j++) {  // for문 2개로 학급 2개씩 짝짓는 comb(n,2) 경우 다 구하기
				boolean flag = true;
				for(int comp = 0 ; comp < compare[0].length ; comp++) { //비교 했던 모든 경우의수에 대하여
					if(compare[i][comp] != compare[j][comp]) { //각 학급의 비교했던 위치에 해당하는 값이 하나라도 다르면   
						flag = false;						   //실력이 안 비슷 한거고
						break;								   //해당 두 학급 비교 끝내기
					}
				}
				if(flag) 									   //flag가 true라면 두 학급의 실력이 같으니
					result++;								   //결과값 ++
			}
		}
		
		System.out.println(result);
		
		
		
		
	}

}
