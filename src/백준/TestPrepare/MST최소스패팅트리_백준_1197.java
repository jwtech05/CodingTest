package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start;
    int head;
    int weight;
    Edge(int start, int head, int weight){
        this.start = start;
        this.head = head;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}

public class MST최소스패팅트리_백준_1197 {
    static PriorityQueue<Edge> arr;
    static int[] uf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        uf= new int[v+1];
        for(int i = 0; i< v+1; i++){
            uf[i] = i;
        }
        arr = new PriorityQueue<>();
        for(int i=0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int head = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Edge(start,head,weight));
        }
        int useEdge = 0;
        int result = 0;
        while(useEdge < v-1){
            Edge now = arr.poll();
            if (find(now.head) != find(now.start)){
                union(now.start, now.head);
                result += now.weight;
                useEdge++;
            }
        }
        System.out.println(result);
    }


    public static void union(int start, int head){
        uf[find(head)] = find(start);
    }
    public static int find(int x){
        if(x == uf[x]){
            return x;
        }
        return uf[x] = find(uf[x]);
    }

}
