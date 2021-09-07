package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16139인간컴퓨터상호작용 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int [][] sumthing = new int[26][S.length()];
        sumthing[S.charAt(0)-'a'][0]++;
        for(int i = 1 ; i < S.length() ; i++){
            for(int j = 0 ; j < 26 ; j++)
                sumthing[j][i] = sumthing[j][i-1];
            sumthing[S.charAt(i)-'a'][i]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s>0)
                sb.append(sumthing[a-'a'][e]-sumthing[a-'a'][s-1]);
            else
                sb.append(sumthing[a-'a'][e]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
