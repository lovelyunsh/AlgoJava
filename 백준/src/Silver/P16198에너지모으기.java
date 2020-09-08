package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P16198에너지모으기 {
    static int result;
    static ArrayList<Integer> eList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        eList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            eList.add(Integer.parseInt(st.nextToken()));
        }
        result =0;
        dfs(0);
        System.out.println(result);
    }
    private static void dfs(int sum) {
        if(eList.size() ==2) {
            result = Math.max(result,sum);
            return;
        }

        for(int i=1; i<eList.size()-1; i++) {
            int mul = eList.get(i-1)*eList.get(i+1);
            int energy = eList.remove(i);
            dfs(sum+mul);
            eList.add(i,energy);
        }
    }
}