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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseArr = new ArrayList<>();
        for(int i = 0 ; i<=N; i++){
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }
        int[] roadTemp = new int[N+1];
        int[] roadCost = new int[N+1];
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(s).add(new Node(e, c));
            reverseArr.get(e).add(new Node(s, c));
            roadTemp[e]++;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node next : arr.get(now)){
                roadTemp[next.targetNode]--;
                roadCost[next.targetNode] = Math.max(roadCost[next.targetNode], roadCost[now] + next.value);
                if(roadTemp[next.targetNode] == 0){
                    queue.offer(next.targetNode);
                }
            }
        }
        int resultCnt = 0;
        boolean[] visited = new boolean[N+1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Node next : reverseArr.get(now)){
                if(roadCost[now] == next.value + roadCost[next.targetNode]){
                    resultCnt++;
                    if(!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }

            }
        }
        System.out.println(roadCost[N]);
        System.out.println(resultCnt);
    }
}
