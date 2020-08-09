package 백준;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P19542전단지돌리기승화 {

   
   static int n,s,d,visit[];
   static ArrayList<Integer> a[];
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(kb.readLine());
      n=Integer.parseInt(st.nextToken());
      s=Integer.parseInt(st.nextToken());
      d=Integer.parseInt(st.nextToken());
      a=new ArrayList[n+1];
      visit=new int[n+1];
      for(int i=1;i<=n;i++) {
         a[i]=new ArrayList<Integer>();
      }
      for(int i=1;i<n;i++) {
         st=new StringTokenizer(kb.readLine());
         int first=Integer.parseInt(st.nextToken());
         int second=Integer.parseInt(st.nextToken());
         a[first].add(second);
         a[second].add(first);
      }
      visit[s]=1;
      System.out.println(dfs(s).x);
      
      
   }
   public static Point dfs(int num) {
      Point dis=new Point(0,0);
      for(int i=0;i<a[num].size();i++) {
         if(visit[a[num].get(i)]==0) {
            visit[a[num].get(i)]=1;
            Point re=dfs(a[num].get(i));
            dis.x+=re.x;
            dis.y=Math.max(re.y, dis.y);
         }
      }
      if(dis.y<d) {
         return new Point(0,dis.y+1);
      }
      if(num!=s)
         dis.x+=2;
      dis.y++;
      return dis;
   }

}