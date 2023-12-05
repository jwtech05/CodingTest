package TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트라_백준_1753 {
    static List<List<Node>> arr;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        distance = new int[n+1];
        arr = new ArrayList<>();
        visited = new boolean[n+1];
        Arrays.fill(distance, 100000000);
        for(int i=0; i<n+1; i++){
            arr.add(new ArrayList<>());
        }
        int start = Integer.parseInt(st.nextToken());
        distance[start] = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new Node(v,w));
        }
        BFS(start);

        for(int i=1; i<n+1; i ++){
            if(distance[i] == 100000000){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    public static void BFS(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node x = pq.poll();
            if(!visited[x.v]){
                visited[x.v] = true;
                for(Node node : arr.get(x.v)){
                    if(distance[node.v] > distance[x.v] + node.w){
                        distance[node.v] = distance[x.v] + node.w;
                        pq.offer(new Node(node.v, distance[node.v]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v;
    int w;
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    public int compareTo(Node e){
        if (this.w > e.w) return 1;
        else return -1;
    }

}