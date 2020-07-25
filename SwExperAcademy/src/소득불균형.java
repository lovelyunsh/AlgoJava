import java.util.Scanner;

public class 소득불균형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {			
			int num = sc.nextInt();
			int numarr [] = new int [num];
			int sum = 0;
			for(int N = 0; N < num ; N++) {
				numarr[N] = sc.nextInt();
				sum += numarr[N]; 
			}
			sum = sum / num;
			int count = 0;
			for(int i : numarr) {
				if(i<=sum)
					count++;
			}

			System.out.printf("#%d %d\n",test_case,count);

		}

	}

}
