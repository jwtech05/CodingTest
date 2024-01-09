package 백준.TestPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유니온파인드_백준_1717 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for(int i=0; i<= n; i++){
            arr[i] = i ;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int head = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(head == 0){
                union(a,b);
            }else{
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb.toString());
    }


    public static void union(int a, int b){
        arr[find(b)] = find(a);
    }

    public static int find(int num){
        if(arr[num] != num){
            arr[num] = find(arr[num]);
        }
        return arr[num];
    }

}
