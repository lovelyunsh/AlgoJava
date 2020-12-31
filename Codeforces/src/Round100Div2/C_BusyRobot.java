package Round100Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_BusyRobot {
	static class Point{
		int x;
		int y;
		int z = Integer.MIN_VALUE;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			Point arr[] = new Point[n+1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int time = Integer.parseInt(st.nextToken());
				int point = Integer.parseInt(st.nextToken());
				arr[i] = new Point(time,point);
			}
			arr[n] = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);
			
			int nowpoint = 0;
			int nowtime = 0;
			for(int i = 0 ; i < n ; i++) {
				int time = arr[i].x;
				int point = arr[i].y;
				boolean cango = false;
				if(time >= nowtime)
					cango = true;
				if(cango) {
					arr[i+1].z = nowpoint;
					nowpoint = point;
					nowtime = time + (Math.abs(nowpoint - point));
					if(nowtime <= arr[i+1].x)
						cnt++;
				}else {
					int goperson = 0;
					for(int j = i-1 ; j >= 0 ; j++) {
						if(arr[j].z == Integer.MIN_VALUE)
							continue;
						goperson = j;
						break;
					}
					if(arr[goperson].z + time-arr[goperson].x  < point && point < nowpoint ) {
						int tttt = arr[goperson].z + time-arr[goperson].x;
						
					}
				}
				
				
				
			}
			
			
			

			System.out.println(cnt);

		}
	}

}
