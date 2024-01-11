package 백준.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra_2307 {

    static int N,M;//지점 수, 도로 수
    static List[] adj;
    static int[] dij;
    static int[] path;//최단 경로 저장
    static final int max = Integer.MAX_VALUE;
    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N+1];

        for(int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<int[]>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[s].add(new int[] {e,d});//s -> e까지 d만큼
            adj[e].add(new int[] {s,d});//e -> s까지 d만큼
        }

        dij = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            dij[i]  = max;
        }
        dij[1] = 0;

        pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {//출발점으로부터 길이 짧은 순으로 꺼냄
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.add(new int[] {1,0});

        path = new int[N+1];
        boolean[] check = new boolean[N+1];

        while(!pq.isEmpty()) {//최단경로 dijkstra
            int[] cur = pq.poll();
            int node = cur[0];

            if(node == N) break;//도착
            check[node] = true;

            for(int i = 0, size = adj[node].size(); i < size; i++) {
                int[] tmp = (int[]) adj[node].get(i);
                int next = tmp[0];

                if(check[next]) continue;//이미 방문했으면
                if(dij[next] > dij[node] + tmp[1]) {
                    dij[next] = dij[node] + tmp[1];

                    path[next] = node;
                    pq.add(new int[] {next, dij[next]});
                }
            }
        }

        int ori = dij[N];

        int to = N;//N에서 시작해서 최단경로 엣지 하나씩 제거하고 dijkstra 돌려보기
        int maxDelay = -1;//최대 딜레이 값 저장

        while(to != 1) {//시작노드 도착 전까지
            int from = path[to];//경로 찾아가면서

            dij = new int[N+1];
            for(int i = 1; i < N+1; i++) {
                dij[i]  = max;
            }
            dij[1] = 0;

            pq.clear();
            pq.add(new int[] {1,0});

            check = new boolean[N+1];

            while(!pq.isEmpty()) {//최단경로 dijkstra
                int[] cur = pq.poll();
                int node = cur[0];

                if(node == N) break;//도착
                check[node] = true;

                for(int i = 0, size = adj[node].size(); i < size; i++) {
                    int[] tmp = (int[]) adj[node].get(i);
                    int next = tmp[0];

                    if(node == from && next == to) continue;//검문하는 도로로는 지나갈 수 X

                    if(check[next]) continue;//이미 방문했으면
                    if(dij[next] > dij[node] + tmp[1]) {
                        dij[next] = dij[node] + tmp[1];

                        path[next] = node;
                        pq.add(new int[] {next, dij[next]});
                    }
                }
            }


            if(dij[N] == max) {//영원히 못빠져나가게 할 수 있음
                maxDelay = -1;
                break;
            }else {
                if(maxDelay < dij[N] - ori) {
                    maxDelay = dij[N] - ori;
                }
            }

            to = from;

        }

        System.out.println(maxDelay);
    }

}