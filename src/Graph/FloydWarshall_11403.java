package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydWarshall_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int N = Integer.parseInt(br.readLine());
        int[][] dis = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                dis[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=1; k<=N; k++){
            for(int s=1; s<=N; s++){
                for(int e=1; e<=N; e++){
                    if(dis[s][k] ==1 && dis[k][e] == 1){
                        dis[s][e] = 1;
                    }
                }
            }
        }
        sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sb.append(dis[i][j]+ " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
