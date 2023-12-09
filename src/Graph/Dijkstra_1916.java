package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class bNode implements Comparable<bNode>{
    int head;
    int cost;
    bNode (int head, int cost){
        this.head = head;
        this.cost = cost;
    }
    public int compareTo(bNode o){
        if(this.cost > o.cost) return 1;
        else return -1;
    }
}
public class Dijkstra_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<bNode>> arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new bNode(v,w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] shortWay = new int[N+1];
        Arrays.fill(shortWay, Integer.MAX_VALUE);
        shortWay[start] = 0;
        boolean[] visited = new boolean[N+1];
        PriorityQueue<bNode> queue = new PriorityQueue<>();
        queue.offer(new bNode(start,0));
        while(!queue.isEmpty()){
            bNode now = queue.poll();
            if(visited[now.head]){
                continue;
            }
            visited[now.head] = true;
            for(bNode x : arr.get(now.head)){
                if(shortWay[x.head] > shortWay[now.head] + x.cost){
                    shortWay[x.head] = shortWay[now.head] + x.cost;
                    queue.offer(new bNode(x.head, shortWay[x.head]));
                }
            }
        }
        System.out.println(shortWay[end]);
    }
}
