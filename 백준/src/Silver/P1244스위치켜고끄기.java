package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1244스위치켜고끄기 {
	
	public static void main(String[] args) throws Exception{
		//남학생은 배수 번호 스위치 상태 바꾸기
		//여학생은 번호로 부터 양옆 대칭인 스위치 상태 바꾸기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean switchlist[] = new boolean [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			char status = st.nextToken().charAt(0);
			if(status == '1')
				switchlist[i] = true;
		}
		
		int SN = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < SN ; i++) {
			st= new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int place = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j = 1 ; place*j-1 < N ; j++) {
					int newplace = place*j-1;
					switchlist[newplace] = !switchlist[newplace];
				}
			}
			else {
				int start = place-1;
				int end = place-1;
				switchlist[start] = !switchlist[end];
				if(--start <0)
					continue;
				if(++end >=N)
					continue;
				while(switchlist[start] == switchlist[end]) {
					switchlist[start] = !switchlist[start];
					switchlist[end] = !switchlist[end];
					if(--start <0)
						break;
					if(++end >=N)
						break;
				}
			}
		}
		for(int i = 0 ; i < N-1 ; i++) {
			if(switchlist[i])
				System.out.print(1 +" ");
			else
				System.out.print(0+" ");
			if(i%20 == 19)
				System.out.println();
		}
		if(switchlist[N-1])
			System.out.println(1);
		else
			System.out.println(0);
	}
}
