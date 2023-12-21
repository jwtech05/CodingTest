package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] com = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            com[i][1] = i;
            com[i][0] = 1;
            com[i][i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                com[i][j] = com[i-1][j-1]+com[i-1][j];
            }
        }
        System.out.println(com[n][r]);
    }

}
