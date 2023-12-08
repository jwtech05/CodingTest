package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSorting_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i<N+1; i++){
            arr.add(new ArrayList<>());
        }
        int[] buildTime = new int[N+1];
        int[] preTemp = new int[N+1];
        int[] answerArr = new int[N+1];
        for(int i = 1; i<=N; i++){
            st  = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int nextToken = Integer.parseInt(st.nextToken());
            while(nextToken != -1){
                arr.get(nextToken).add(i);
                nextToken = Integer.parseInt(st.nextToken());
                preTemp[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i< preTemp.length; i++){
            if(preTemp[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int x : arr.get(now)){
                answerArr[x] = Math.max(answerArr[x],answerArr[now] + buildTime[now]);
                preTemp[x]--;
                if(preTemp[x] == 0){
                    queue.offer(x);
                }
            }
        }
        for(int i=1; i<buildTime.length;i++){
            System.out.println(buildTime[i]+answerArr[i]);
        }
    }
}
