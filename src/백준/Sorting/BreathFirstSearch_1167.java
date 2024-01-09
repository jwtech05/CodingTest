package 백준.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BreathFirstSearch_1167 {
    static ArrayList<Node>[] A;
    static int sum = 0;
    static int lastSum = 0;
    static int len = 0;
    static boolean[] check;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        for(int i=1; i <N+1; i++){
            A[i] = new ArrayList<>();
        }
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int node=0;
            int edge=0;
            while(st.hasMoreTokens()) {
                node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                edge = Integer.parseInt(st.nextToken());
                A[i].add(new Node(node, edge));
            }
        }
        check = new boolean[N+1];
        DFS(1);
        check = new boolean[N+1];
        lastSum = 0;
        sum = 0;
        DFS(len);
        System.out.print(lastSum);
    }

    static void DFS(int num){
        if(check[num]){
            return;
        }
        check[num] = true;
        for(int i=0; i<A[num].size(); i++){
            Node a = A[num].get(i);
            if(!check[a.node]){
                sum += a.edge;
                DFS(a.node);
                sum -= a.edge;
            }
        }
        if(lastSum < sum){
            lastSum = sum;
            len = num;
        }
    }
}

class Node{
    int node;
    int edge;
    public Node(int n, int e) {
        node = n;
        edge = e;
    }
}
