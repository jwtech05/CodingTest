package 백준.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalSum_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] graph = new int[W+1][W+1];
        for(int i=1; i<=W; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j <=W; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sGraph = new int[W+1][W+1];
        for(int i=1; i<=W; i++){
            for(int j=1; j<=W; j++) {
                sGraph[i][j] = sGraph[i][j-1] + sGraph[i-1][j] + graph[i][j] - sGraph[i-1][j-1];
            }
        }
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sGraph[x2][y2] - sGraph[x1-1][y2]-sGraph[x2][y1-1]+sGraph[x1-1][y1-1];
            System.out.println(result);
        }

    }
}
