package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 위상정렬_백준_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> height = new ArrayList<>();
        int[] counter = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            height.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            height.get(s).add(e);
            counter[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<counter.length;i++){
            if(counter[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num+" ");
            for(int x : height.get(num)){
                counter[x]--;
                if(counter[x] == 0){
                    q.offer(x);
                }
            }
        }
    }
}
