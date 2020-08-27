package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11721열개씩끊어출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		for(char i : br.readLine().toCharArray()) {
			cnt++;
			System.out.print(i);
			if(cnt%10 == 0)
				System.out.println();
		}
	}

}
