package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 브라우저 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> Back = new Stack();
		Stack<String> Front = new Stack();
		System.out.println("방문할 url 입력");
		String curr = sc.next();
		out:while (true) {
			System.out.println("V : 방문, B: 뒤로, F : 앞으로, Q : 종료");
			char a = sc.next().charAt(0);

			switch (a) {
			case 'Q' :
				break out;
			case 'V':
				System.out.println("방문할 url 입력");
				Back.push(curr);
				Front.clear();
				curr = sc.next();
				break;
			case 'B':
				if (Back.isEmpty()) {
					System.out.println("뒤에 갈 페이지 없어");
					break;
				} else {
					Front.push(curr);
					curr = Back.pop();
					break;
				}
			case 'F':
				if (Front.isEmpty()) {
					System.out.println("앞으로 갈 페이지 없어");
					
				} else {
					Back.push(curr);
					curr = Front.pop();
					break;
				}

			default :
				System.out.println("V B F 중에 선택");
				break;

			}
			System.out.println();
			System.out.println("현재 페이지 : " + curr);
			System.out.println();
		}

	}

}
