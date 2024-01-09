package 백준.Graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int start;
    int head;
    int cost;
    Edge(int start,int head, int cost){
        this.start = start;
        this.head = head;
        this.cost = cost;
    }
}
public class BellmanFord_11657 {
    static long distance[];
    static Edge edges[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges = new Edge[M+1];
        distance = new long[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s,e,c);
        }
        distance[1] = 0;
        for(int i=1; i< N; i++){
            for(int j=0; j<M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.head] > distance[edge.start] + edge.cost){
                    distance[edge.head] = distance[edge.start] + edge.cost;
                }
            }
        }
        boolean mCycle = false;
        for(int i=0; i<M; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.head] > distance[edge.start] + edge.cost){
                mCycle = true;
            }
        }
        if(!mCycle) {
            for(int i=2; i <=N; i++){
                if(distance[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(distance[i]);
            }
        }else{
            System.out.println("-1");
        }
    }
}
