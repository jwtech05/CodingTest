package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class graph_1707 {
    static boolean[] visited;
    static String[] check;
    static boolean IsEven;
    static int cnt;
    static ArrayList<Integer>[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int time = Integer.parseInt(br.readLine());
        for(int i =0 ; i< time; i++){
            String[] st = br.readLine().split(" ");
            int V = Integer.parseInt(st[0]);
            int E = Integer.parseInt(st[1]);
            arr = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new String[V+1];
            IsEven = true;
            cnt = 0;
            Arrays.fill(check, "A");
            for(int j = 1 ; j<V+1; j++){
                arr[j] = new ArrayList<Integer>();
            }
            for(int k = 0; k<E; k++){
                st = br.readLine().split(" ");
                int v = Integer.parseInt(st[0]);
                int e = Integer.parseInt(st[1]);
                arr[v].add(e);
                arr[e].add(v);
            }
            for(int j=1; j<V+1; j++){
                if(IsEven){
                    DFS(j);
                }else{
                    break;
                }
            }
            if(IsEven)
                sb.append("YES : "+cnt +"\n");
            else
                sb.append("NO : "+cnt +"\n");
        }
        System.out.print(sb);
    }

    private static void DFS(int num) {
        visited[num] = true;
        for(int i : arr[num]){
            if(!visited[i]){
                if(check[num].equals("A")){
                    check[i] = "B";
                }else{
                    check[i] = "A";
                }
                DFS(i);
            }
            else if(check[num].equals(check[i])){
                IsEven = false;
            }
            cnt++;
        }
    }
}
