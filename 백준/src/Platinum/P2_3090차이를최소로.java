package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2_3090차이를최소로 {
    static int N, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int min = 1000000000;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        max = max - min;
        min = 0;
        StringBuilder sb = new StringBuilder();
        while (min < max) {
            int mid = (min + max) / 2;
            int[] copyarr = arr.clone();
            if (check(copyarr, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        int[] copyarr = arr.clone();
        check(copyarr, max);
        for (int i = 0; i < N; i++)
            sb.append(copyarr[i] + " ");
        System.out.println(sb);
    }

    static boolean check(int[] arr, int target) {
        long cnt = 0;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i + 1] - arr[i] > target) {
                cnt += arr[i + 1] - arr[i] - target;
                arr[i + 1] = arr[i] + target;
            }

        }
        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] - arr[i] > target) {
                cnt += arr[i - 1] - arr[i] - target;
                arr[i - 1] = arr[i] + target;
            }
        }
        if (cnt > T)
            return false;
        return true;
    }
}
