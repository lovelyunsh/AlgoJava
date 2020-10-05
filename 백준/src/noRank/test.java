package noRank;

public class test {
	public static void main(String[] args) {
		
		
		for(int i = 0 ; i <= 9 ; i++) {
			for(int j = 0 ; j <= 9 ; j++) {
				int gop = i*j%10;
				int firstgop = gop;
				for(int k = 0 ; k < 4 ; k++) {
					System.out.print(gop +" ");
					gop = gop * j % 10;
					
				}
				if(gop == firstgop)
					System.out.println(i +" "+ j);
				
			}
		}
		
		
	}

}
