package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryTree_1300 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long start = 1;
        long end = K;
        long ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt >= K) {
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        System.out.print(ans);
    }
}
