package Combination;

import java.util.*;
import java.io.*;

public class Combination_1256{
    static int N,M,K;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[101][101];

    static int init(int n, int m){
        if(n==0 || m==0){
            dp[n][m] = 1;
            return dp[n][m];
        }


        else if(dp[n][m]==0){
            dp[n][m] = Math.min(init(n-1,m) + init(n,m-1), 1000000001);
            return dp[n][m];
        }

        else return dp[n][m];
    }

    static void setString(int n, int m, int k){
        // 만약 a의 개수가 0일 경우 z만 이어서 추가
        if(n==0){
            for(int i=0;i<m;i++) sb.append("z");
            return;
        }

        // 만약 z의 개수가 0일 경우 a만 이어서 추가
        if(m==0){
            for(int i=0;i<n;i++) sb.append("a");
            return;
        }


        if(k > dp[n-1][m]){
            sb.append("z");
            setString(n,m-1,k-dp[n-1][m]);
        }

        else{
            sb.append("a");
            setString(n-1,m,k);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // dp 배열 값 추가
        init(N,M);

        // K가 문자열 개수보다 클 경우 -1 출력
        if(dp[N][M] < K) System.out.println(-1);

            // 아닐 경우 : 문자열 생성
        else{
            setString(N,M,K);
            System.out.println(sb);
        }
    }
}

//출처 : https://velog.io/@gale4739/%EB%B0%B1%EC%A4%80-1256-%EC%82%AC%EC%A0%84Java