package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int targetNode;
    int value;
    Node (int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
}
public class TopologicalSorting_1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseArr = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }
        int[] cityArr = new int[N+1];
        int[] costArr = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, cost));
            reverseArr.get(end).add(new Node(start, cost));
            cityArr[end]++;
        }
        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node x : arr.get(now)){
                cityArr[x.targetNode]--;
                costArr[x.targetNode] = Math.max(costArr[x.targetNode], costArr[now] + x.value);
                if(cityArr[x.targetNode] == 0){
                    queue.offer(x.targetNode);
                }
            }
        }

        int resultCount = 0;
        boolean visited[] = new boolean[N+1];
        queue = new LinkedList<>();
        queue.offer(endCity);
        visited[endCity] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node x : reverseArr.get(now)){
                if(costArr[x.targetNode] + x.value == costArr[now]){
                    resultCount++;
                    if(!visited[x.targetNode]){
                        visited[x.targetNode] = true;
                        queue.offer(x.targetNode);
                    }
                }
            }
        }
        System.out.println(costArr[endCity]);
        System.out.println(resultCount);
    }
}
