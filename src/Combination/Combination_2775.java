package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_2775 {
    static int[][] village;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            village = new int[15][15];
            for (int j = 0; j <= 14; j++) {
                village[j][1] = 1;
            }
            for (int j = 1; j <= 14; j++) {
                village[0][j] = j;
            }
            for (int j = 1; j <= 14; j++) {
                for (int o = 1; o <= 14; o++) {
                    village[j][o] = village[j][o-1] + village[j-1][o];
                }
            }
            System.out.println(village[k][n]);
        }
    }

}
