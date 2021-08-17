import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
		Set<List> a = new HashSet<>();
		testclass tcA = new testclass(1,2);
		testclass tcB = new testclass(1,2);
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(1,2,3);

		a.add(list1);
		a.add(list2);

		System.out.println(a);

	}
}


