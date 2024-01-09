package 백준.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_14501 {
    static int N;
    static int[] dp;
    static int[] time;
    static int[] pay;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        time = new int[N+1];
        pay = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        DFS(1, 0);

        System.out.println(result);

    }
    public static void DFS(int d, int p){
        if(d > N){
            result = Math.max(p, result);
            return;
        }
        if(time[d] + d <= N + 1) {
            DFS(d+time[d], p + pay[d]);
        }else{
            DFS(d+time[d], p);
        }

        DFS(d+1,p);
    }

}
