package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열조합_백준_1722_보류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long F[] = new long[21];
        int S[] = new int[21];
        boolean visited[] = new boolean[21];
        int type = Integer.parseInt(st.nextToken());
        F[0] = 1;
        for(int i=1; i<=N; i++){
            F[i] = F[i-1] * i;
        }
        if(type == 1){
            long k = Long.parseLong(st.nextToken());
            for(int i=1; i<=N; i++){
                for(int j=1, cnt =1; j <=N; j++){
                    if(visited[j])
                        continue;
                    if( k <= cnt * F[N-1]){
                        k-= ((cnt-1) * F[N-i]);
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
        }else{
            long K=1;
            for(int i=1; i<=N; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for(int j=1; j< S[i]; j++){
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
