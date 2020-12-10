import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Watermelon {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weigh = Integer.parseInt(br.readLine());
		if (weigh % 2 == 0 && weigh != 2)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
