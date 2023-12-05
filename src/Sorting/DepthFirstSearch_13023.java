package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DepthFirstSearch_13023 {
    static ArrayList<Integer>[] A;
    static int result = 0;
    static boolean[] check;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        check = new boolean[N];
        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }
        for(int i=0; i<N; i++){
            DFS(i,1);
            if(result == 1) break;
        }
        System.out.print(result);
    }

    static void DFS(int num, int depth){
        if(depth == 5){
            result = 1;
            return;
        }
        check[num] = true;
        for(int i : A[num]){
            if(!check[i]) {
                DFS(i, depth + 1);
            }
        }
        check[num] = false; //이 부분을 추가해주지 않아서 틀렸다.
    }

}
