package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DepthFirstSearch_11724 {
    static ArrayList<Integer>[] A;
    static boolean[] check;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        check = new boolean[N+1];
        int answer = 0;
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1; i<N+1; i++){
            if(!check[i]){
                answer ++;
                DFS(i);
            }
        }

        System.out.print(answer);

    }

    static void DFS(int num){
        if(check[num]){
            return;
        }
        check[num] = true;
        for(int i : A[num]){
            if(!check[i]){
                DFS(i);
            }
        }
    }
}
