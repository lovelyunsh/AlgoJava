public class P72414광고삽입 {
	
	
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String [] logs = new String [] {"00:00:00-00:14:15","00:14:14-00:14:17","01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		solution(play_time, adv_time, logs);
	}
	static public String solution(String play_time, String adv_time, String[] logs) {
		int playTime = timeToSec(play_time);
		int advTime = timeToSec(adv_time);
		int startTable[] = new int[playTime + 1];
		int endTable[] = new int[playTime + 1];
		long cnt = 0;
		int plus = 0;
		int minus = 0;

		for (String log : logs) {
			String[] logSplit = log.split("-");
			int start = timeToSec(logSplit[0]);
			int end = timeToSec(logSplit[1]);
			startTable[start]++;
			endTable[end]++;
			if(start < advTime) {
				if(end >=advTime)
					plus++;
				cnt += advTime - start;
			}
		}
		cnt -= plus;
		long max = cnt;
		int maxTime = 0;
		for(int i = 0 ; i <= playTime-advTime ; i++) {
			cnt+=plus;
			cnt-=minus;
			minus += startTable[i];
			minus -= endTable[i];
			plus += startTable[i+advTime];
			plus -= endTable[i+advTime];
			if(max < cnt) {
				max = cnt;
				maxTime = i;
			}
		}
		int h = maxTime/60/60;
		int m = maxTime/60%60;
		int s = maxTime%60;
		
		return String.format("%02d:%02d:%02d",h,m,s);
	}

	static int timeToSec(String time) {
		String[] times = time.split(":");
		int sec = Integer.parseInt(times[0]) * 60 * 60 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);
		return sec;
	}
}
