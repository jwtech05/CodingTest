package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BreathFirstSearch_1260 {
    static ArrayList<Integer>[] A;
    static StringBuilder sb;
    static boolean check[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        A = new ArrayList[N+1];
        check = new boolean[N+1];

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for(int i=1; i<N+1; i++) {
            Collections.sort(A[i]);
        }
        DFS(start);
        sb.append("\n");
        check = new boolean[N+1];
        BFS(start);

        System.out.print(sb);
    }
    static void DFS(int num){
        if(check[num]){
            return;
        }
        check[num] = true;
        sb.append(num+ " ");
        for(int i : A[num]){
            if(!check[i]){
                DFS(i);
            }
        }

    }

    static void BFS(int num){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(num);
        check[num] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now+" ");
            for (int i : A[now]){
                if(!check[i]){
                    check[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
