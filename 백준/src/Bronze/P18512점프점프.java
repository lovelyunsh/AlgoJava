package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18512점프점프 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());// 김싸피 보폭
		int Y = Integer.parseInt(st.nextToken());// 박싸피 보폭
		int H1 = Integer.parseInt(st.nextToken()); //김싸피 최초 위치
		int H2 = Integer.parseInt(st.nextToken()); //박싸피 최초 위치
		int nowX = H1; //김싸피의 현재 위치
		int nowY = H2; // 박싸피의 현재 위치
		int result = -1; //결과 값 -1로 초기화
		while(nowX - X <10000 && nowY - Y < 10000 ) {
			if(nowX == nowY) { //둘의 위치가 같아지면
				result = nowX; //result를 현재위치에 저장
				break;         // 종료
			}
			if(nowX < nowY) //김싸피가 뒤에 있으면 김싸피가 뛰기
				nowX+=X;
			if(nowX> nowY) //박싸피가 뒤에 있으면 박싸피가 뛰기
				nowY+=Y;
		}
		
		System.out.println(result); //위치가 같았으면 그때의 위치, 만나지 못했다면 최초 초기화 -1 출력
		
	}

}
