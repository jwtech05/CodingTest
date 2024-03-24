package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class fNode{

    int toward;
    int cost;
    public fNode(int toward, int cost){
        this.toward = toward;
        this.cost = cost;
    }
}
public class Dijkstra_1854_third {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<fNode>> arr = new ArrayList<>();
        Queue<Integer>[] pq = new PriorityQueue[N+1];
        for(int i=0; i<N+1; i++){
            pq[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(start).add(new fNode(end,cost));
        }
        int[] costArr = new int[N+1];
        costArr[1] = 0;
        boolean[] check = new boolean[N+1];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        Queue<fNode> queue = new LinkedList<>();
        queue.offer(new fNode(1,0));
        pq[1].add(0);
        while(!queue.isEmpty()){
            fNode num = queue.poll();
            int to = num.toward;
            int cost = num.cost;
            for(fNode x : arr.get(to)) {
                if (pq[x.toward].size() < K) {
                    pq[x.toward].add(cost + x.cost);
                    queue.add(new fNode(x.toward, cost + x.cost));
                } else if (pq[x.toward].peek() > cost + x.cost) {
                    pq[x.toward].poll();
                    pq[x.toward].add(cost + x.cost);
                    queue.add(new fNode(x.toward, cost + x.cost));
                }
            }
        }
        for (int i = 1; i < N+1; ++i){
            if (pq[i].size() == K) System.out.println(pq[i].peek());
            else System.out.println(-1);
        }
    }
}