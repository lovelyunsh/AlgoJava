package Silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2304창고다각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		int height[] = new int[N];
		Point position[] = new Point [N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			position[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(position,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		
		});
		
		
		int max = 0;
		int maxpos = 0 ;
		for(int i = 0 ; i < N ; i++) {
			if(position[i].y>max) {
				max = position[i].y;
				maxpos = i;
			}
		}
		int now = 0;
		int left = 1;
		int result = max;
		while(left <= maxpos) {
			if(position[left].y >= position[now].y) {
				result += (position[left].x - position[now].x)*position[now].y;
				now = left;
			}
			left++;
		}
		now = N-1;
		int right = N-2;
		while(right >= maxpos) {
			if(position[right].y >= position[now].y) {
				result += ( position[now].x - position[right].x)*position[now].y;
				now = right;
			}
			right--;
		}
		
		System.out.println(result);
	}

}
