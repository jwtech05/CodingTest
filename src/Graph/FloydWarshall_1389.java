package Graph;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] relateArr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                relateArr[i][j] = 10000001;
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relateArr[s][e] = 1;
            relateArr[e][s] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(relateArr[i][j] > relateArr[i][k] + relateArr[k][j]){
                        relateArr[i][j] = relateArr[i][k] + relateArr[k][j];
                    }
                }
            }
        }
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                if (relateArr[i][j] == 10000001) {
                    relateArr[i][j] = 0;
                }
            }
        }
        int num = 10000001;
        int answer = 0;
        for(int i=1; i<=N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                cnt += relateArr[i][j];
            }
            if(cnt < num){
                num = cnt;
                answer = i;
            }
            cnt = 0;
        }
        System.out.println(answer);
    }
}
