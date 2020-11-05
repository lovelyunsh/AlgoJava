package Silver;

import java.util.*;

public class P2108통계학 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int map[] = new int[N];
      int tmp[] = new int[N];
      int many[] = new int[8001];

      for (int i = 0; i < N; i++) {
         map[i] = sc.nextInt();
         tmp[i] = map[i];
         many[(map[i] + 4000)]++;
      }

      // 평균
      int avg = 0;
      float sum = 0;
      for (int i = 0; i < N; i++) {
         sum = sum + map[i];
      }

      avg = (int) Math.round(sum / N);

      // 중앙값
      Arrays.sort(tmp);
      int mid = tmp[N / 2];

      // 최빈값
      int alot = 0;
      int many_min = 0;
      boolean flag = false;

      for (int i = 0; i < many.length; i++) {
         if (many_min < many[i]) {
            many_min = many[i];
            alot = i - 4000;
            flag = true;
         } else if (many_min == many[i] && flag == true) {
            alot = i - 4000;
            flag = false;
         }
      }

      // 범위
      int minus = tmp[N - 1] - tmp[0];

      System.out.println(avg);
      System.out.println(mid);
      System.out.println(alot);
      System.out.println(minus);

   }
}