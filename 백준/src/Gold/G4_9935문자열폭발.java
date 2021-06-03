package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G4_9935문자열폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder target = new StringBuilder();
		target.append(br.readLine());
		String bomb = br.readLine();
		boom(target,bomb);
		if(target.length() == 0)
			target.append("FRULA");
		System.out.println(target);
	}

	static void boom(StringBuilder target,String bomb) {
		int bombidx = 0;
		int startidx = 0;
		for(int i = 0 ; i < target.length() ; i++) {
			if(bomb.charAt(bombidx) == target.charAt(i)) {
				if(bombidx == 0 && bomb.length() != 1) {
					startidx = i;
					bombidx += 1;
					
				}
				else if(bombidx == bomb.length()-1) {
					target.delete(startidx, i+1);
					bombidx = 0;
					i-= bomb.length() + bomb.length()/2 + bomb.length()%2 +1;
					if(i < 0)
						i = -1;
				}else {
					bombidx += 1;
				}
			}else {
				if(bombidx != 0) {
					i-=1;
					bombidx = 0;
				}
					
			}
		}
	}
}
