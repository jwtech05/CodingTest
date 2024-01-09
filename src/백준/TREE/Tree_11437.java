package 백준.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_11437 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] depth;
    static int[] parent;
    public static void DFS(int num, int dep){
        if(visited[num]){
            return;
        }
        depth[num] = dep;
        visited[num] = true;
        for(int x : arr.get(num)){
            if(!visited[x]) {
                parent[x] = num;
                DFS(x, dep + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[N+1];
        arr = new ArrayList<>();
        for(int i=0 ; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        depth[1] = 1;
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        DFS(1,0);
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int height = left;
            while(depth[left] != depth[right]){
                if(depth[left] > depth[right]){
                    left = parent[left];
                }else if(depth[left] < depth[right]){
                    right = parent[right];
                }
                height = left;
            }
            while(left != right){
                left = parent[left];
                right = parent[right];
                height = left;
            }
            System.out.println(height);
        }
    }
}
