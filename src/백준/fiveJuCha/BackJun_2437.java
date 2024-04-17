package 백준.fiveJuCha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 시도 : 5회
 * 시간 : 3시간 40분
 * 성공 여부 : 실패
 * */
public class BackJun_2437 {
    static int N;
    static int[] arr;
    static boolean[] stop, flag;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        stop = new boolean[N];
        flag = new boolean[1000000000];
        flag[0] = true;
        pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);
        int size = pq.size();
        for(int i = 1; i<size+1; i++){
            int a = pq.poll();
            if(i != a) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int start, int sum){
        if(start == N){
            return;
        }
        for(int i=0; i<N; i++){
            if(stop[i]) continue;
            if(!flag[sum]) {
                pq.offer(sum);
                flag[sum] = true;
            }
            stop[i] = true;
            DFS(i,sum+arr[i]);
            stop[i] = false;
        }
    }
}

