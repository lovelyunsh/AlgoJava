package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_20209선미 {
   static int N, K, ans, cube[], sw[][], sel[], tmp[];
   static boolean success;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      cube = new int[N];
      sw = new int[K][N];
      sel = new int[K];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++)
         cube[i] = Integer.parseInt(st.nextToken());
      for (int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine());
         int B = Integer.parseInt(st.nextToken());
         for (int j = 0; j < B; j++) {
            int b = Integer.parseInt(st.nextToken()) - 1;
            sw[i][b] = i + 1;
         }
      }
      ans = 0;
      while (ans <= 32) {
         comb(0, ans);
         if (success)
            break;
         ans++;
      }
      if (success)
         System.out.println(ans);
      else
         System.out.println(-1);
   }
   static void comb(int idx, int num) {
      if (success)
         return;
      if (idx == K) {
         check();
         return;
      }
      for (int i = 0; i <= num; i++) {
         if (i > 5)
            break;
         sel[idx] = i;
         comb(idx + 1, num - i);
      }
   }

   static void check() {
      tmp = new int[N];
      for (int i = 0; i < K; i++) {
         if (sel[i] != 0) {
            for (int j = 0; j < N; j++) {
               tmp[j] += (sw[i][j] * sel[i]);
            }
         }
      }
      int val = (cube[0] + tmp[0]) % 5;
      for (int i = 1; i < N; i++) {
         if ((cube[i] + tmp[i]) % 5 != val)
            return;
      }
      success = true;
   }
}