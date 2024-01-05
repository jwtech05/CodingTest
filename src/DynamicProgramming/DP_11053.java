package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_11053 {
    static int N;
    static int[] DP;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        DP = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 1;
        for(int i=0; i<N; i++){
            DP[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j] ){
                    DP[i] = Math.max(DP[j] + 1,DP[i]);
                }
            }
        }
        result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(DP[i], result);
        }
        System.out.println(result);
    }

}
