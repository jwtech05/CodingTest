package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_1463_BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        for (int i = N; i >= 1; i--) {
            if (i / 3 >= 1 && i % 3 == 0) dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);
            if (i / 2 >= 1 && i % 2 == 0) dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);
            if (i - 1 >= 1) dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
        }
        System.out.println(dp[1]);
    }
}
