package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P20127Y수열 {
	static List<Integer> p1, p2, p3;
	static List<Integer> m1, m2, m3;
	static boolean plus = false;
	static boolean minus = false;
	static boolean pisgroup = false;
	static boolean misgroup = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p1 = new ArrayList<Integer>();
		p1.add(0);
		p2 = new ArrayList<Integer>();
		p3 = new ArrayList<Integer>();
		m1 = new ArrayList<Integer>();
		m1.add(1000000001);
		m2 = new ArrayList<Integer>();
		m3 = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!pisgroup)
				groupP(num);
			else if (plus)
				plusF(num);
			if (!misgroup)
				groupM(num);
			else if (minus)
				minusF(num);
		}
		int ans = 10000000;
		if (!pisgroup || !misgroup)
			ans = 0;
		else if (plus)
			ans = Math.min(ans, p3.size());
		else if (minus)
			ans = Math.min(ans, m3.size());
		else
			ans = -1;
		System.out.println(ans);
	}

	static void groupP(int num) {
		if (p1.get(p1.size() - 1) <= num)
			p1.add(num);
		else {
			pisgroup = true;
			plus = true;
			for (int i = 1; i < p1.size(); i++) {
				if (p1.get(i) > num) {
					p2.addAll(p1.subList(1, i));
					p2.add(num);
					p3.addAll(p1.subList(i, p1.size()));
					for(int j = 0 ; j < p3.size() ; j++) {
						if(p3.get(0) != p3.get(j)) {
							iswhattheP = false;
							break;
						}
					}
					break;
				}
			}
		}
	}

	static void groupM(int num) {
		if (m1.get(m1.size() - 1) >= num)
			m1.add(num);
		else {
			misgroup = true;
			minus = true;
			for (int i = 1; i < m1.size(); i++) {
				if (m1.get(i) < num) {
					m2.addAll(m1.subList(1, i));
					m2.add(num);
					m3.addAll(m1.subList(i, m1.size()));
					for(int j = 0 ; j < m3.size() ; j++) {
						if(m3.get(0) != m3.get(j)) {
							iswhattheM = false;
							break;
						}
					}
					break;
				}
			}
		}
	}

	static List<Integer> whattheP = new ArrayList<Integer>();
	static List<Integer> whattheM = new ArrayList<Integer>();
	static boolean iswhattheP = true;
	static boolean iswhattheM = true;

	static void plusF(int num) {
		if (iswhattheP && p3.get(p3.size() - 1) == num) {
			whattheP.add(num);
		} else if (p3.get(p3.size() - 1) <= num) {
			if (iswhattheP) {
				iswhattheP = false;
				p3.addAll(whattheP);
			}
			p3.add(num);
		} else if (p3.get(0) < num)
			plus = false;
		else if (p2.get(p2.size() - 1) <= num) {
			p2.add(num);
			if (iswhattheP) {
				p3.addAll(whattheP);
				whattheP.clear();
			}
		} else
			plus = false;
	}

	static void minusF(int num) {
		if (iswhattheM && m3.get(m3.size() - 1) == num) {
			whattheM.add(num);
		}
		else if (m3.get(m3.size() - 1) >= num) {
			if (iswhattheM) {
				iswhattheM = false;
				m3.addAll(whattheM);
			}
			m3.add(num);
		}
		else if (m3.get(0) > num)
			minus = false;
		else if (m2.get(m2.size() - 1) >= num) {
			m2.add(num);
			if (iswhattheM) {
				m3.addAll(whattheM);
				whattheM.clear();
			}
		}
		else
			minus = false;
	}

}
