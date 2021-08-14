import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P42892길찾기게임 {
	class node implements Comparable<node> {
		int num;
		int x;
		int y;
		int left;
		int right;

		@Override
		public int compareTo(node o) {
			return o.y - this.y;
		}

		public node(int num, int x, int y, int left, int right) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.left = left;
			this.right = right;
		}

		public node() {
		}

	}

	// 레벨 순으로 하나씩 뽑기
	// 이분탐색으로 위치 찾기
	// 왼쪽 오른쪽 보고 노드 저장
	//
	List<Integer> preorder;
	List<Integer> postorder;

	public int[][] solution(int[][] nodeinfo) {

		List<node> nodeListLevel = new ArrayList<node>();
		List<node> nodeListNum = new ArrayList<node>();
		List<node> nodeListFind = new ArrayList<node>();
		preorder = new ArrayList<Integer>();
		postorder = new ArrayList<Integer>();
		for (int i = 0; i < nodeinfo.length; i++) {
			node one = new node();
			one.num = i + 1;
			one.x = nodeinfo[i][0];
			one.y = nodeinfo[i][1];
			nodeListLevel.add(one);
			nodeListNum.add(one);
		}

		Collections.sort(nodeListLevel, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o2.y - o1.y;
			}
		});
		Collections.sort(nodeListNum, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.num - o2.num;
			}
		});

		nodeListFind.add(new node(-1, -1, 100001, 0, 0));
		nodeListFind.add(nodeListLevel.get(0));
		nodeListFind.add(new node(-1, 1000000, 100001, 0, 0));
		int first = nodeListFind.get(1).num;
		for (int i = 1; i < nodeListLevel.size(); i++) {
			node now = nodeListLevel.get(i);
			int loc = findLoc(nodeListFind, now);
			if (nodeListFind.get(loc).y < nodeListFind.get(loc + 1).y)
				nodeListFind.get(loc).right = now.num;
			else
				nodeListFind.get(loc + 1).left = now.num;
			nodeListFind.add(loc + 1, now);
		}
		getOrder(first, nodeListNum);
		int[][] answer = new int[2][nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++) {
			answer[0][i] = preorder.get(i);
			answer[1][i] = postorder.get(i);
		}
		return answer;
	}

	public int findLoc(List<node> nodeListFind, node now) {
		int left = 0;
		int right = nodeListFind.size();

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (nodeListFind.get(mid).x > now.x)
				right = mid;
			if (nodeListFind.get(mid).x < now.x)
				left = mid;
		}
		return left;
	}

	public void getOrder(int now, List<node> nodeListNum) {
		preorder.add(now);
		node nowNode = nodeListNum.get(now - 1);
		if (nowNode.left != 0)
			getOrder(nowNode.left, nodeListNum);
		if (nowNode.right != 0)
			getOrder(nowNode.right, nodeListNum);
		postorder.add(now);
	}

}
