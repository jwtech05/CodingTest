package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class dNode implements Comparable<dNode>{
    int head;
    int cost;
    dNode (int head, int cost){
        this.head = head;
        this.cost = cost;
    }
    public int compareTo(dNode o){
        if(this.cost > o.cost) return 1;
        else return -1;
    }
}
public class Dijkstra_1753 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> arr = new ArrayList<>();
        for(int i=0; i<=V; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(u).add(new dNode(v,w));
        }
        int[] shortWay = new int[V+1];
        Arrays.fill(shortWay, Integer.MAX_VALUE);
        shortWay[start] = 0;
        boolean[] visited = new boolean[V+1];
        PriorityQueue<dNode> queue = new PriorityQueue<>();
        queue.offer(new dNode(start, 0));
        while(!queue.isEmpty()){
            dNode now = queue.poll();
            if(visited[now.head]){
                continue;
            }
            visited[now.head] = true;
            for(dNode x : arr.get(now.head)){
                if(shortWay[x.head] > shortWay[now.head] + x.cost){
                    shortWay[x.head] = shortWay[now.head] + x.cost;
                    queue.offer(new dNode(x.head, shortWay[x.head]));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(!visited[i]){
                System.out.println("INF");
            }else{
                System.out.println(shortWay[i]);
            }
        }
    }
}
