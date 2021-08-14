package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G3_1516게임개발 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new List[N + 1];
        int dp[] = new int[N + 1];
        int timeArr[] = new int[N + 1];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) break;
                list[i].add(n);
            }
            if (list[i].size() == 0) {
                dp[i] = time;
                cnt++;
            }
        }
        while (cnt < N) {
            gg:
            for (int i = 1; i <= N; i++) {
                if (dp[i] != 0)
                    continue;
                int max = 0;
                for (int j : list[i]) {
                    if (dp[j] == 0)
                        continue gg;
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + timeArr[i];
                cnt++;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(dp[i]);
        }
    }
}
