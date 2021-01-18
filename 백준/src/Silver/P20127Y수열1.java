package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20127Y수열1 {
	static boolean pline, mline;
	static boolean pcant, mcant;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt1 = 1;
		int cnt2 = 1;
		int firstnum = Integer.parseInt(st.nextToken());
		int lastnumP = firstnum;
		int lastnumM = firstnum;
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!pline) {
				if (lastnumP <= num) {
					lastnumP = num;
					cnt1++;
				}
				else {
					pline = true;
					lastnumP = num;
				}
			} else if(!pcant) {
				if (lastnumP <= num)
					lastnumP = num;
				else
					pcant = true;
			}
			if (!mline) {
				if (lastnumM >= num) {
					lastnumM = num;
					cnt2++;
				}
				else {
					mline = true;
					lastnumM = num;
				}
			} else if(!mcant) {
				if (lastnumM >= num)
					lastnumM = num;
				else
					mcant = true;
			}
		}
		int ans = 100000000;
		if (!pline || !mline) {
			ans = 0;
		} else {
			if (firstnum < lastnumP)
				pcant = true;
			if (firstnum > lastnumM)
				mcant = true;
		}
		if(!pcant)
			ans = Math.min(ans, cnt1);
		if(!mcant)
			ans = Math.min(ans, cnt2);
		if(pcant && mcant)
			ans = -1;
		System.out.println(ans);
	}

}
