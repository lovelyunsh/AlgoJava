package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17471게리멘더링 {
	static int people[];
	static int N;
	static boolean matrix[][];
	static int min = 123456789;
	public static void main(String[] args) throws IOException {
		// 모든 부분 집합을 비트마스크로 뽑는다.
		// 모든구역 - 뽑은 비트마스크 하면 반대편 선거구도 뽑힌다.
		// 두 구역 모두 연결 되어있는지 bfs검사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		matrix = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) { //입력 받기
			st = new StringTokenizer(br.readLine());
			int etc = Integer.parseInt(st.nextToken());
			for (int j = 0; j < etc; j++) {
				int target = Integer.parseInt(st.nextToken());
				matrix[i][target] = true;
				matrix[target][i] = true;
			}
		}

		for (int i = 1; i <= ((1 << N) - 1) / 2; i++) {
			ArrayList<Integer> section_1 = makeSection(i);
			if (!check(section_1))
				continue;
				
			
			ArrayList<Integer> section_2 = makeSection((1 << N)-1 - i);
			if (!check(section_2))
				continue;
			
			int diff = Math.abs(getPeople(section_1) - getPeople(section_2));
			min = Math.min(diff, min);
		}
		if(min == 123456789)
			min = -1;
		System.out.println(min);

	}

	static ArrayList<Integer> makeSection(int Section) {
		ArrayList<Integer> section = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if ((Section & (1 << i)) != 0)
				section.add(i+1);
		}
		return section;
	}
	static boolean check(ArrayList<Integer> originSection) {
		ArrayList<Integer> section = (ArrayList<Integer>) originSection.clone(); 
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(section.get(0));
		section.remove(0);
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int i = section.size() - 1; i >= 0; i--) {
				if (matrix[now][section.get(i)]) {
					que.offer(section.get(i));
					section.remove(i);
				}
			}
		}
		if(section.size() == 0)
			return true;
		return false;
	}

	static int getPeople(ArrayList<Integer> section) {
		int sum = 0;
		for(int i : section)
			sum += people[i];
		return sum;
	}
}
