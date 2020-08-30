
public class test {
	public static void main(String[] args) {
		int start = 1;
		int end = 2;
		start = end ^ start^(end = start);
		System.out.println(start);
		System.out.println(end);
	}

}
