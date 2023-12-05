package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Greedy_1931 {
    public static void main(String args[]) throws IOException {
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                // First, compare by start values
                int startComparison = Integer.compare(node1.end , node2.end);

                // If start values are equal, compare by end values
                if (startComparison == 0) {
                    return Integer.compare(node1.start, node2.start);
                }

                return startComparison;
            }
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>(nodeComparator);
        int start = 0;
        int end = -1;
        int cnt = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int nextStart = Integer.parseInt(st.nextToken());
            int nextEnd = Integer.parseInt(st.nextToken());
            pq.add(new Node(nextStart,nextEnd));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int newStn = node.start;
            int newStn2 = node.end;
            if(node.start >= end){
                end = node.end;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}

class Node{
    int start;
    int end;
    Node(int start, int end){
        this.start = start;
        this.end = end;
    }

}

