package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Tree_11725 {
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        arr = new ArrayList<>();
        parent = new int[N+1];
        for(int i=0; i<N+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        DFS(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int num){
        if(visited[num]){
            return;
        }
        visited[num] = true;
        for(int x : arr.get(num)){
            if(!visited[x]) {
                parent[x] = num;
                DFS(x);
            }
        }
    }
}
