package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14003가장긴증가하는부분수열 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[n + 1];
        int indexArr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            if(num > list.get(list.size() - 1)) {
                list.add(num);
                indexArr[i] = list.size() - 1;
            }
            else{
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
                indexArr[i] = right;
            }
        }
        sb.append(list.size() - 1 + "\n");
        Stack<Integer> stack = new Stack<Integer>();

        int index = list.size() - 1;

        for(int i = n; i > 0; i--){
            if(indexArr[i] == index){
                index--;
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}