package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] D = new long[N+1];
        D[1] = 1;
        D[2] = 2;
        for(int i=3; i<=N; i++){
            D[i] = (D[i-1] + D[i-2]) % 10007;
        }
        System.out.println(D[N]);
    }
}
