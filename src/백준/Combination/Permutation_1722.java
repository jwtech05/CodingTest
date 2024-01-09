package 백준.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation_1722 {
    public static void main(String[] args) throws IOException {
        long[] F = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        F[0] = 1;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            F[i] = F[i-1] * i;
        }
        if(M == 1){
            int k = Integer.parseInt(st.nextToken());
            for(int i=1; i<=N; i++){
                for(int j=1, cnt=1; j<=N; j++){
                    if(visited[j]){
                        continue;
                    }
                    if(k <= (cnt * F[N-1])){
                        k -= (cnt-1)*F[N-i];
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i=1; i<=N; i++){
                System.out.print(S[i] + " ");
            }
        }else if(M==2) {
            long K = 1;
            for(int i=1; i<=N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j=1; j < S[i]; j++){
                    if(!visited[j]){
                        cnt++;
                    }
                }
                K += cnt * F[N-i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}
