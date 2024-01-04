package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] D = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        D[0] = arr[0];
        for(int i=1; i<N; i++){
            D[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    D[i] = Math.max(D[i],D[j] + arr[i]);

                }
            }
        }
        int result = 0;
        for(int i=0; i<N; i++){
            result = Math.max(result, D[i]);
        }
        System.out.println(result);
    }

}
