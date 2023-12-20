package TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tree_11438 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] depth;
    static int[][] parent;
    public static void DFS(int num, int dep){
        if(visited[num]){
            return;
        }
        depth[num] = dep;
        visited[num] = true;
        for(int x : arr.get(num)){
            if(!visited[x]) {
                parent[0][x] = num;
                DFS(x, dep + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        depth[1] = 1;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        int tmp = 1;
        int kMax = 0;
        while (tmp <= N){
            tmp <<= 1;
            kMax++;
        }
        parent = new int[kMax +1][N+1];
        DFS(1, 0);
        for(int i=1; i<= kMax; i++){
            for(int j = 1; j<= N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(depth[left] > depth[right]){
                int temp = left;
                left = right;
                right = temp;
            }
            for(int k= kMax; k >=0; k--){
                if(Math.pow(2, k) <= depth[right] - depth[left]){
                    if(depth[left] <= depth[parent[k][right]]){
                        right = parent[k][right];
                    }
                }
            }
            for(int k= kMax; k >= 0; k--){
                if(parent[k][left] != parent[k][right]){
                    left = parent[k][left];
                    right = parent[k][right];
                }
            }
            int LCA = left;
            if(left != right){
                LCA = parent[0][LCA];
            }
            System.out.println(LCA);
        }
    }
}