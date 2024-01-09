package 백준.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class pNode implements Comparable<pNode>{
    int head;
    int cost;
    pNode(int head, int cost){
        this.head = head;
        this.cost = cost;
    }
    @Override
    public int compareTo(pNode o) {
        if(this.cost > o.cost) return 1;
        else return -1;
    }
}
public class Dijkstra_1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<pNode>> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tripCost = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
            tripCost.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(s).add(new pNode(e,c));
        }
        boolean[] visited = new boolean[n+1];
        PriorityQueue<pNode> pq = new PriorityQueue<>();
        pq.offer(new pNode(1,0));
        tripCost.get(1).add(0);
        while(!pq.isEmpty()){
            pNode now = pq.poll();
            for(pNode x : arr.get(now.head)){
                if(now.head == x.head){
                    tripCost.get(x.head).add(x.cost);
                }else {
                    for (int y : tripCost.get(now.head)) {
                        tripCost.get(x.head).add(y + x.cost);
                    }
                }
                pq.offer(new pNode(x.head, x.cost));
            }
        }
        for(int i=1; i<=n; i++){
            ArrayList<Integer> checkArr = tripCost.get(i);
            if(checkArr.size() < k || (checkArr.get(0) == 0 && checkArr.size() == 1)){
                bw.write(-1+"\n");
            }else{
                Collections.sort(checkArr);
                bw.write(checkArr.get(k-1)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
