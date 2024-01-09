package 백준.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int west = 0;
        int east = 0;
        int[][] bridge = new int[31][31];
        for(int i=0; i<31; i++){
            bridge[i][i] = 1;
            bridge[i][0] = 1;
            bridge[i][1] = i;
        }
        for(int i=2; i<31; i++){
            for(int j = 2; j<i; j++){
                bridge[i][j] = bridge[i-1][j-1] + bridge[i-1][j];
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            west = Integer.parseInt(st.nextToken());
            east = Integer.parseInt(st.nextToken());
            System.out.println(bridge[east][west]);
        }
    }
}
