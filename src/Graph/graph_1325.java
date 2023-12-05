package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_1325 {

    static ArrayList<Integer>[] arr;
    static int cnt;
    static int ans = 0;
    static int[] check;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check = new int[N+1];
        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[e].add(s);
        }
        for(int i=1; i<N+1; i++){
            cnt = 0;
            DFS(i);
            check[i] = cnt;
        }
        for(int i=1; i<N+1; i++){
            if(check[i] > ans){
                ans = check[i];
            }
        }
        for(int i=1; i<N+1; i++){
            if(check[i] == ans){
                sb.append(i+" ");
            }
        }
        System.out.print(sb);
    }

    public static void DFS(int x){
        cnt++;
        for(int a : arr[x]){
            DFS(a);
        }
    }

}
