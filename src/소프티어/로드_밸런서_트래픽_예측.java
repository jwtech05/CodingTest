package 소프티어;

import java.io.*;
import java.util.*;

public class 로드_밸런서_트래픽_예측 {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] arrBig;
    static long[] arrCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        arr = new ArrayList<>();
        arrBig = new int[N+1];
        arrCnt = new long[N+1];
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
            }
        }
        for(long i = 0; i< K; i++){
            DFS(1, arrCnt[1]);
        }
        for(int i=1; i<=N; i++){
            System.out.print(arrCnt[i]+" ");
        }
    }
    public static void DFS(int num, long cnt){
        arrCnt[num]++;
        if(arrBig[num] == 0){
            return;
        }
        int nextNum = (int) cnt % arrBig[num];
        DFS(arr.get(num).get(nextNum), arrCnt[arr.get(num).get(nextNum)]);
    }
}
