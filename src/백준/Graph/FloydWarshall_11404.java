package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j) distance[i][j] = 0;
                else distance[i][j] = 10000001;
            }
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(distance[s][e] > v) distance[s][e] = v;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(distance[i][j] == 10000001)
                    distance[i][j] = 0;
                sb.append(distance[i][j]+ " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
 