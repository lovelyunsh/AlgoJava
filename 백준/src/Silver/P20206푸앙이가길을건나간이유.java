package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20206푸앙이가길을건나간이유 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		boolean flag = false;

		int num1 = A*x1 + B*y1+C;
		int num2 = A*x1 + B*y2+C;
		int num3 = A*x2 + B*y1+C;
		int num4 = A*x2 + B*y2+C;
		if(num1 >= 0 && num2 >= 0 && num3 >= 0 && num4 >= 0)
			flag = true;
		if(num1 <= 0 && num2 <= 0 && num3 <= 0 && num4 <= 0)
			flag = true;
		
		
		System.out.println(flag ? "Lucky" : "Poor");
	}
}
