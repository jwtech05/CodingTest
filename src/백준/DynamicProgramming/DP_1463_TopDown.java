package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_1463_TopDown {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        System.out.println(dp(N));
    }

    public static int dp(int num){

        if(num <= 1){
            return 0;
        }

        if(memo[num] != 0){
            return memo[num];
        }

        if(num % 6 == 0){
            memo[num] = Math.min(num - 1, Math.min(dp(num / 3), dp(num/2))) + 1;
            return memo[num];
        }else if(num % 3 == 0){
            memo[num] = Math.min(dp(num-1), dp(num/3)) + 1;
            return memo[num];
        }else if(num % 2 == 0){
            memo[num] = Math.min(dp(num-1), dp(num/2)) + 1;
            return memo[num];
        }else{
            memo[num] = dp(num-1)+1;
            return memo[num];
        }
    }
}
