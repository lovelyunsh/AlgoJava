import java.util.HashSet;

public class test {
	static class testclass{
		int x;
		int y;

		public testclass(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			testclass testclass = (testclass) o;
			return x == testclass.x && y == testclass.y;
		}
	}

	public static void main(String[] args) {
		HashSet<int [][]> map = new HashSet<>();
		int [][] a = new int [][] {{1,2,3},{1,2,3}};
		int [][] b = new int [][] {{1,2,3},{1,2,3}};
		map.add(a);
		map.add(b);
		System.out.println(map.size());
	}
}


