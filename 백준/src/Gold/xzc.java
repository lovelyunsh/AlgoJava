package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class xzc {
   static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
   static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
   static int ans;

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int[][] map = new int[4][4];
      Fish[] fish = new Fish[16];
      for (int i = 0; i < 4; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 4; j++) {
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            fish[a] = new Fish(i, j, b);
            map[i][j] = a;
         }
      }
//      for (int i = 0; i < 4; i++) {
//         for (int j = 0; j < 4; j++)
//            System.out.print(map[i][j] + 1 + " ");
//         System.out.println();
//      }
//      System.out.println();
      Fish shark = fish[map[0][0]];
      fish[map[0][0]] = null;
      simulation(map, fish, shark, map[0][0] + 1);
      System.out.println(ans);
   }

   static void simulation(int[][] map, Fish[] fish, Fish shark, int cnt) {
      System.out.println(cnt + " " + shark);
      // 물고기가 전부 이동한다.
      for (int i = 0; i < 16; i++) {
         if (fish[i] == null)
            continue;
//         if (fish[i].x == shark.x && fish[i].y == shark.y)
//            continue;
         Fish f = fish[i];
         for (int d = f.d, j = 0; j <= 8; d = (d + 1) % 8, j++) {
            int nx = f.x + dx[d];
            int ny = f.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == shark.x && ny == shark.y))
               continue;
            // 물고기 위치 교환
            // map 세팅
            int f2 = map[nx][ny];
            map[nx][ny] = i;
            map[f.x][f.y] = f2;

            // fish[f2]와 fish[i]를 교체
            // 방향은 유지하고 좌표만 바꿔야함...
            if (fish[f2] == null) {
               fish[i].x = nx;
               fish[i].y = ny;
            } else {
               fish[i].x = nx;
               fish[i].y = ny;
               fish[f2].x = nx - dx[d];
               fish[f2].y = ny - dy[d];
            }
            break;
         }
      }
      // 상어가 이동할수 있는 곳이 있다면 다 이동해 본다.
      for (int i = 1; i <= 3; i++) {
         int nx = shark.x + (dx[shark.d] * i);
         int ny = shark.y + (dy[shark.d] * i);
         if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
            break;
         if (fish[map[nx][ny]] == null)
            continue;
         
         Fish[] nfish = fish.clone();
         nfish[map[nx][ny]] = null;
         
         int[][] nmap = new int[4][4];
         for (int j = 0; j < 4; j++)
            nmap[j] = map[j].clone();

         simulation(nmap, nfish, fish[map[nx][ny]], cnt + map[nx][ny] + 1);
      }
      System.out.println(cnt);
      ans = Math.max(ans, cnt);
   }

   static class Fish {
      int x, y, d;

      public Fish(int x, int y, int d) {
         super();
         this.x = x;
         this.y = y;
         this.d = d;
      }

      @Override
      public String toString() {
         return "Fish [x=" + x + ", y=" + y + ", d=" + d + "]";
      }

   }
}