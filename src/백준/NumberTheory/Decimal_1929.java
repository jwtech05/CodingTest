package 백준.NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal_1929 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] A = new boolean[N+1];
        double n = Math.sqrt(N);
        for(int i=2; i<=n; i++){
            if(A[i]){
                continue;
            }
            for(int j = i+i; j<=N; j+=i){
                if(j % i == 0){
                    A[j] = true;
                }
            }
        }
        for(int i=M; i<=N; i++){
            if(!A[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

}
