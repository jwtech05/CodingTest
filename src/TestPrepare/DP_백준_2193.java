package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_백준_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[][] D = new long[N+1][2];
        D[1][1] = 1;
        D[1][0] = 0;
        for(int i=2; i<N+1 ; i++){
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];
        }

        System.out.println(D[N][0]+D[N][1]);
    }
}
