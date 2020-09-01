package 야구게임_승환;

import java.util.Scanner;

public class 혜린야구 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("야구 게임을 시작합니다.");
		System.out.println("몇 개의 숫자로 진행하시겠습니까 : ");
		int cnt = sc.nextInt();
		System.out.println("번호를 입력해주세요 : ");
		int num = sc.nextInt();
		
		int com[] = new int[cnt];
		int user[] = new int[cnt];
		
		int strike = 0;
		int ball = 0;
		//입력한 번호와 자리가 맞으면 스트라이크
		//입력한 번호는 있지만 자리가 맞지 않으면 볼
		//다 맞지 않으면 아웃
		
		//컴퓨터에 랜덤숫자 넣기
		for (int i = 0; i < cnt; i++) {
			com[i] = (int) (Math.random() * 9);
			System.out.print(com[i]);
			
		}
		
		//사용자 숫자 넣기
		for (int i = 0; i < user.length; i++) {
			user[i] = num;
		}
		
		//숫자 서로 비교하기
		for (int i = 0, j=0; i < cnt && j < cnt; i++) {
			if(com[i] == user[j] && i==j) {
				strike++;
			} else if(com[i] == user[j] && i != j) {
				ball++;
			} else {
				System.out.println("아웃");
			}
		}
		System.out.println(strike + " 스트라이크, " + ball + " 볼");
		
		
	}

}
