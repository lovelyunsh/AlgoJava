package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_19542전단지돌리기 {

	static boolean visited[];
	static ArrayList<Integer> list[];
	static int cnt, D, parents[];

	static int find(int x) {
		if (parents[x] == x) //루프 노드를 만나면 지금까지 세어논 길이 return
			return cnt;
		if (visited[x]) { // 방문 했던 노드를 만나면 지금까지 세어논 길이 return 
			return cnt - 1;
		}
		cnt++;
		if (D < cnt) //힘이 거리보다 크면 방문을 하지 않으니 거리가 힘보다 클때만 방문처리 
			visited[x] = true;
		return find(parents[x]);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}

		visited = new boolean[N + 1];
		ArrayList<Integer> leaflist = new ArrayList<Integer>();
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(S);
		while (!que.isEmpty()) { //bfs로 각 노드들의 부모 자식연결 (트리 생성)
			int now = que.poll();
			boolean isleaf = true;
			for (int i = 0; i < list[now].size(); i++) {
				if (parents[now] != list[now].get(i)) {
					isleaf = false;	
					que.add(list[now].get(i));
					parents[list[now].get(i)] = now;
				}
			}
			if (isleaf) //자식이 하나도 없다면 리프노드
				leaflist.add(now);
		}
		int result = 0;
		for (int leaf : leaflist) {
			cnt = 0;
			find(leaf);
			if (cnt - D > 0)
				result += (cnt - D) * 2; //세어논 거리에서 힘만큼 빼고 왕복이니 2배
		}
		System.out.println(result);
	}
}
