import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P42890후보키 {

	 int colSize;
	 int rowSize;
	 int answer = 0;
	 boolean sel[];
	 String[][] globalRelation;
	 List<boolean[]> selList = new ArrayList<boolean[]>();

	 public int solution(String[][] relation) {
		globalRelation = relation;
		colSize = relation[0].length;
		rowSize = relation.length;
		sel = new boolean[colSize];
		comb(0);
		return answer;
	}

	 public boolean check() {
		if (selList.size() == 0)
			return true;
		int cnt = 0;
		gg: for (boolean[] comp : selList)
			for (int i = 0; i < sel.length; i++)
				if (comp[i] && !sel[i]) {
					cnt++;
					continue gg;
				}
		if(cnt == selList.size())
			return true;
		return false;
	}

	 public void comb(int selidx) {
		if (selidx == colSize) {
			if (!check())
				return;
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < rowSize; i++) {
				String one = "";
				for (int j = 0; j < colSize; j++) {
					if (sel[j])
						one += globalRelation[i][j];
				}
				if (!set.add(one))
					return;
			}
			answer++;
			selList.add(sel.clone());
			return;
		}
		sel[selidx] = false;
		comb(selidx + 1);
		sel[selidx] = true;
		comb(selidx + 1);
	}
}
