package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP_2342 {
    static int[] move;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        move = new int[line.length-1];
        for(int i=0; i<line.length-1; i++) {
            move[i] = Integer.parseInt(line[i]);
        }

        dp = new int[5][5][line.length];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0,0,0));
    }

    static int solve(int left, int right, int cnt) {

        if(cnt == move.length) return 0;

        if(dp[left][right][cnt] != -1 ) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(solve(move[cnt],right, cnt+1) + check(left, move[cnt]),
                solve(left, move[cnt], cnt+1) + check(right,move[cnt]));
        return dp[left][right][cnt];
    }
    public static int check(int i, int j){
        if(i == 0){
            return 2;
        }
        if(i==j){
            return 1;
        }
        if(Math.abs(i-j) == 2){
            return 4;
        }else{
            return 3;
        }
    }

}
