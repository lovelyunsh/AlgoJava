package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class P1233사칙연산유효성검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int ans = 1;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                char c = st.nextToken().charAt(0);
                if (ans == 1) {
                    if (c >= '0' && c <= '9') {
                        if (st.hasMoreTokens()) {
                            ans = 0;
                        }
                    }
                    else {
                    	if(st.countTokens() != 2) {
                    		ans = 0;
                    	}
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}

