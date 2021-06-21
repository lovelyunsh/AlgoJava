package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G1_2470두용액 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer [] arr = new Integer [N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.parallelSort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		int min = Integer.MAX_VALUE;
		int x = 0;
		int y = 0;
		for(int i = 0 ; i < N-1; i++) {
			if(Math.abs(Integer.sum(arr[i], arr[i+1])) < min) {
				x = arr[i];
				y = arr[i+1];
				min = Math.abs(x+y);
			}
		}
		if(x > y)
			x = y ^ x ^(y=x);
		System.out.println(x+" "+y);
		
	}

}
