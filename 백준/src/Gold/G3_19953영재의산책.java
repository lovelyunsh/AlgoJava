package Gold;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class G3_19953영재의산책 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int arr[] = new int[5];
		arr[0] = (v * m) % 10;
		for(int i = 1 ; i < 5 ; i++)
			arr[i] = (arr[i-1] * m)%10;
		long row = 0;
		long col = 0;
		row += v;
		t--;
		col += arr[0];
		t--;
		int all = t/4;
		int mod = t%4;
		row -= 1L * arr[1] * all;
		col -= 1L *arr[2] * all;
		row += 1L *arr[3] * all;
		col += 1L *arr[4] * all;
		if(mod > 0) 
			row -= arr[1];
		if(mod>1) 
			col -= arr[2];
		if(mod>2)
			row+= arr[3];
		System.out.println(col + " " + row);
	}
}
