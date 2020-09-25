package noRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경연이스위치 {

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      int[] light = new int[num+1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= num; i++) {
         light[i] = Integer.parseInt(st.nextToken());
      }

      int count = Integer.parseInt(br.readLine());
      for (int i = 0; i < count; i++) {
         st = new StringTokenizer(br.readLine());
         int one = Integer.parseInt(st.nextToken());
         int two = Integer.parseInt(st.nextToken());
         if (one == 1) {
            int a=1;
            while (true) {
               two = two * a;
               if (two > num)
                  break;
               light[two] ^= 1;
               a++;
            }

         } else { // 여학생일때니까
            light[two] ^= 1;
            int start = two - 1;
            int end = two + 1;
            while (true) {
               if (start <= 0 || end > num)
                  break;
               if(light[start]==light[end]) {
                  light[start] ^= 1;
                  light[end] ^= 1;
                  start--;
                  end++;                  
               }else {
                  break;
               }
            }

         }

      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= num; i++) {
         sb.append(light[i] + " ");
         if(i%20 ==0) {
            sb.append("\n");
         }
      }

      System.out.println(sb);

   }

}