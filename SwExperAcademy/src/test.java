import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		int a= 10;
		int b = 20;
		a = b ^ a ^(b=a);
		System.out.println(a+" "+ b);
	}

}
