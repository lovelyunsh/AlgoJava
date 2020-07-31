package D5;

import java.util.Scanner;

public class P10507영어공부 {

	public static int countone(int start, int end, int[] numarr) {
		int cnt = end - start +1 ;
		while (start - 1 >= 0 && numarr[--start] == 1)
			cnt++;
		while (end + 1 < numarr.length && numarr[++end] == 1)
			cnt++;

		return cnt;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int max = 0;
			int numbers[] = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = sc.nextInt(); // 숫자들 입력
			}
			if(n == 0 || n == 1) {
				max = n + p;
				System.out.printf("#%d %d\n", tc, max);
				continue;
			}
			int size = numbers[n - 1] + 1; // 가장 큰숫자를 배열의 크기로
			int narray[] = new int[size];
			for (int i : numbers)
				narray[i] = 1;

			int start = numbers[0];
			int end = start;
			int namuzi = 0;
			ff : for (int i = 0; i < p; i++) {//최초 start end 설정
				end++;
				
				while (narray[end] == 1) {
					end++;
					if (end >= size) {
						end--;
						namuzi = p - i; // 처음 초기화부터 넘어가버리면 나머지 p 저장
						break ff;
					}
				}
			}
			while (true) {//start end 검사
				start++;
				if (start == end || narray[start] == 0)
					break;
			}
			max = countone(start, end, narray) + namuzi;
			namuzi = 0;
			while (end < 0) {
				end++;
				while (narray[end] == 1) {
					end++;
					if (end >= size) {
						end--;
						namuzi = 1;
						break;
					}

				}
				start++;
				while (start == end || narray[start] == 1) {
					start++;
				}
				int now = countone(start, end, narray) + namuzi;
				if (now > max) {
					max = now;
				}
			}
//
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
