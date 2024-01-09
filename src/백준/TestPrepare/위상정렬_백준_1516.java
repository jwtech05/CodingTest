package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 위상정렬_백준_1516 {

    static int[] cost;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] enterCnt;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cost = new int[N+1];
        enterCnt = new int[N+1];
        arr = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            arr.add(new ArrayList<>());
        }
        answer = new int[N+1];
        for(int i=1; i< N+1 ; i++){
            st = new StringTokenizer(br.readLine());
            int buildCost = Integer.parseInt(st.nextToken());
            int cnt = 0;
            cost[i] = buildCost;
            int preBuild = Integer.parseInt(st.nextToken());
            while(preBuild != -1){
                cnt++;
                arr.get(preBuild).add(i);
                preBuild = Integer.parseInt(st.nextToken());
            }
            enterCnt[i] = cnt;
        }
        BFS(N);
        for(int i=1; i< N+1 ; i++){
            System.out.println(cost[i] + answer[i]);
        }

    }

    public static void BFS(int num){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<= num; i++){
            if(enterCnt[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int std = q.poll();
            for(int x : arr.get(std)){
                enterCnt[x]--;
                //answer[x] += cost[std];
                answer[x] = answer[std] + cost[std];
                //answer[x] = Math.max(answer[x] , answer[std] + cost[std]);
                if(enterCnt[x] == 0){
                    q.offer(x);
                }
            }
        }
    }
}
