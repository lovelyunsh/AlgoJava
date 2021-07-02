
public class P64062징검다리건너기 {
	
	
	public int solution(int[] stones, int k) {
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < stones.length-k+1; i++) {
			int max = -1;
			for(int j = i ; j < i +k ; j++)
				max = Math.max(stones[j], max);
			min = Math.min(min, max);
		}
		
		
		return min;
	}
}

