package 소프티어;

import java.io.*;
import java.util.*;

public class 로드_밸런서_트래픽_예측 {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] arrBig;
    static long[] arrCnt;
    static int[] arrBfs;
    static boolean[] arrFlag;
    static ArrayList<Integer> ordering;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        arr = new ArrayList<>();
        ordering = new ArrayList<>();
        ordering.add(0);
        arrBig = new int[N+1];
        arrCnt = new long[N+1];
        arrBfs = new int[N+1];
        arrFlag = new boolean[N+1];
        arrFlag[1] = true;
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arrBig[i] = num;
            while(st.hasMoreTokens()){
                int next = Integer.parseInt(st.nextToken());
                arr.get(i).add(next);
                arrBfs[next]++;
            }
        }
        BFS(1);
        long[] answer = new long[N+1];
        answer[1] = K;
        for(int i=1; i < answer.length; i++){
            int node = ordering.get(i);
            long request = answer[node];
            if(arr.get(node).size() == 0) continue;
            long ans = request / arr.get(node).size();
            long left = request % arr.get(node).size();
            for(int j=0; j<arr.get(node).size(); j++){
                answer[arr.get(node).get(j)] += ans;
            }
            for(int j=0; j<left; j++){
                answer[arr.get(node).get(j)] += 1;
            }
        }
        for(int i=1; i<answer.length; i++){
            System.out.print(answer[i]);
            if(i != answer.length-1) System.out.print(" ");
        }
    }
/*    public static void DFS(int num, long cnt){
        arrCnt[num]++;
        if(arrBig[num] == 0){
            return;
        }
        int nextNum = (int) cnt % arrBig[num];
        DFS(arr.get(num).get(nextNum), arrCnt[arr.get(num).get(nextNum)]);
    }*/

    public static void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        while(!q.isEmpty()){
            int next = q.poll();
            ordering.add(next);
            for(int x : arr.get(next)){
                arrBfs[x]--;
                if(arrBfs[x] == 0 && !arrFlag[x]){
                    q.offer(x);
                    arrFlag[x] = true;
                }
            }
        }
    }
}
