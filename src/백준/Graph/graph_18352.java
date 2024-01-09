package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class graph_18352 {
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    static int[] ans;
    static List<Integer> answer;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        ans = new int[N+1];
        answer = new ArrayList<>();
        Arrays.fill(ans,-1);
        check = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr[S].add(E);
        }
        BFS(X);
        for(int i=1; i<=N; i++){
            if(ans[i] == K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int temp : answer){
                System.out.println(temp);
            }
        }

    }

/*
    public static void 백준.DFS(int A){
        if(check[A] || arr[A].size() == 0){
            if(ans[A] > cnt){
                ans[A] = cnt;
            }
            return;
        }
        check[A] = true;
        for(int a : arr[A]){
            if(!check[a]){
                cnt++;
                백준.DFS(a);
                cnt -= 1;
            }
            check[a] = false;
        }
    }
*/

    public static void BFS(int A){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(A);
        ans[A]++;
        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i : arr[a]){
                if(ans[i] == -1){
                    ans[i] = ans[a]+1;
                    queue.add(i);
                }
            }
        }
    }
}
