import java.util.Scanner;
import java.io.FileInputStream;


public class basicform {
	
		public static void main(String args[]) throws Exception
		{
			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt();
		
			for(int tc = 1; tc <= T; tc++)
			{
				//solving
				String ab = "";
				char a = 65;
				ab = ab+ a ;
				System.out.println(ab);
				
				System.out.printf("#%d \n", tc );
			}
		}
	

}
