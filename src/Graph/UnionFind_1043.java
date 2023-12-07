package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UnionFind_1043 {
    static int[] unionFind;
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(a < b) {
                unionFind[b] = a;
            }else{
                unionFind[a] = b;
            }
        }
    }
    public static int find(int num){
        if(unionFind[num] == num){
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int answer = 0;
        unionFind = new int[N+1];
        for(int i=0; i<= N; i++){
            unionFind[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int noticer = Integer.parseInt(st.nextToken());
        if(noticer == 0){
            cnt = M;
        }else{
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i=0; i<M; i++){
                arr.add(new ArrayList<Integer>());
            }
            int first = Integer.parseInt(st.nextToken());
            for(int i=1; i <noticer; i++){
                union(first, Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int attends = Integer.parseInt(st.nextToken());
                int attendee1 = Integer.parseInt(st.nextToken());
                arr.get(i).add(attendee1);
                if(attends > 1){
                    for(int j=1; j<attends; j++){
                        int attendee2 = Integer.parseInt(st.nextToken());
                        arr.get(i).add(attendee2);
                    }
                }
            }
            for(int i=0; i<M; i++){
                for(int x : arr.get(i)){
                    if(unionFind[x] == unionFind[first]){
                        for(int y : arr.get(i)){
                            union(first, y);
                        }
                        break;
                    }
                }
            }
            for(int i=0; i<M; i++){
                boolean flag = true;
                for(int x : arr.get(i)){
                    if(unionFind[x] == unionFind[first]){
                        flag = false;
                    }
                }
                if(flag){
                    cnt++;
                }
            }
        }
        answer = cnt;
        System.out.println(answer);
    }
}
