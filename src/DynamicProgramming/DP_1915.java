package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1915 {
    static int[][] arr;
    static int N, M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        result = 0;
        for(int i=1; i<=N; i++){
            String num = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = num.charAt(j-1) - 48;
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(arr[i][j] == 1) {
                    check(i, j, 1);
                }
            }
        }
        System.out.println(result);
    }
    public static void check(int i, int j, int level){
        if(i+level > N || j+level > M){
            return;
        }
        boolean flag = true;
        for(int a = i; a <= i+level; a++){
            for(int b = j; b<= j+level; b++){
                if(arr[a][b] == 0){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            check(i, j, level+1);
        }else{
            result = Math.max(result, level * level);
        }
    }
}
