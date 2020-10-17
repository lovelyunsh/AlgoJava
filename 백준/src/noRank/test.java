package noRank;

public class test {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		x = y ^ x ^ (y = x);
		
		x = y + x - ( y = x);
		System.out.println(x+" "+ y);
		

		
		
	}

}
