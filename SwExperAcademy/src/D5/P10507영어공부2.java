package D5;

import java.util.ArrayList;
import java.util.Scanner;

public class P10507영어공부2 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int numbers[] = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = sc.nextInt(); // 숫자들 입력
			}

			int size = numbers[n - 1] + 1; // 가장 큰숫자를 배열의 크기로
			int narray[] = new int[size];
			for (int i : numbers)
				narray[i] = 1;

			int max = 0;
			int result = 0;

			int start = numbers[0];
			int end = start;
			int namuzi = 0;
			for (int i = 0; i < p; i++) {
				end++;
				while (narray[end] == 1) {
					end++;
					if (end >= size) {
						end--;
						namuzi = p - i; // 처음 초기화부터 넘어가버리면 나머지 p 저장
						break;
					}
				}
			}
			if (narray[end + 1] == 1) {
				end++;
				while (narray[end] == 1) {
					end++;
					if (end >= size) {
						end--;
						break;
					}
				}
				end--;
			}

			max = end - start;

			while (end < size) { // 한칸식 전진
				end++;

				while (end<size && narray[end] == 1)
					end++;
				
				if (end+1 < size && narray[end + 1] == 1) {
					end++;
					while (narray[end] == 1) {
						end++;
						if (end >= size) {
							end--;
							break;
						}
					}
					end--;
				}
				
				start++;
				while (narray[start] == 1)
					start++;

				if (narray[start - 1] == 1) {
					start--;
					while (narray[start] == 1) {
						start--;
						if (start < 0) {
							start++;
							break;
						}
					}
					start++;
				}
				result = end - start;
				if (result > max) {
					max = result;
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
